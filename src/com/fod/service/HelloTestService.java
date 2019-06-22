package com.fod.service;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Policy;
import org.omg.PortableServer.IdAssignmentPolicyValue;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.ThreadPolicyValue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Properties;

public class HelloTestService {

    public static void main(String[] args) {

        // 生成一个ORB，并初始化，这个和Server端一样
        Properties props = System.getProperties();
        //配置发布端口和ip
        props.put("org.omg.CORBA.ORBInitialPort", "1050");
        props.put("org.omg.CORBA.ORBInitialHost", "192.168.0.106");


        System.out.println("ORB initialised\n");
        try {
            // Initialize the ORB.
            ORB orb = ORB.init(args, props);

            // get a reference to the root POA
            org.omg.CORBA.Object obj = orb.resolve_initial_references("RootPOA");
            POA poaRoot = POAHelper.narrow(obj);

            // Create policies for our persistent POA
            Policy[] policies = {
                    // poaRoot.create_lifespan_policy(LifespanPolicyValue.PERSISTENT),
                    poaRoot.create_id_assignment_policy(IdAssignmentPolicyValue.USER_ID),
                    poaRoot.create_thread_policy(ThreadPolicyValue.ORB_CTRL_MODEL)
            };

            // Create myPOA with the right policies
            POA poa = poaRoot.create_POA("HelloServerPOA", poaRoot.the_POAManager(), policies);

            // Create the servant
            HelloServerImpl servant = new HelloServerImpl();



            // Activate the servant with the ID on myPOA
            byte[] objectId = "AnyObjectID".getBytes();
            poa.activate_object_with_id(objectId, servant);

            // Activate the POA manager
            poaRoot.the_POAManager().activate();

            // Get a reference to the servant and write it down.
            obj = poa.servant_to_reference(servant);


            PrintWriter ps = new PrintWriter(new FileOutputStream(new File("server.ior")));
            ps.println(orb.object_to_string(obj));
            ps.close();


            System.out.println("CORBA Server ready...");

            // Wait for incoming requests
            orb.run();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
