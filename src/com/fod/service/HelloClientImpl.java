package com.fod.service;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Properties;

class HelloClientImpl {
    private HelloServer target = null;
    private org.omg.CORBA.ORB orb = null;


    /**
     * Constructor for HelloClientImpl
     *
     */
    public HelloClientImpl() throws Exception {
        initORB(null);
    }


    /**
     * Constructor for HelloClientImpl
     * @see java.lang.Object#Object()
     */
    public HelloClientImpl(String[] args) throws Exception {
        initORB(args);
    }


    /**
     * Initialize ORB.
     *
     * @param args
     */
    public void initORB(String[] args) throws Exception {
        //设置远程调用ip和端口
        Properties props = System.getProperties();
        props.put("org.omg.CORBA.ORBInitialPort", "1050");
        props.put("org.omg.CORBA.ORBInitialHost", "192.168.0.106");

        // Initialize the ORB
        orb = org.omg.CORBA.ORB.init((String[])args, props);

        // ---- Uncomment below to enable Naming Service access. ----
//        LineNumberReader input = new LineNumberReader(new FileReader("server.ior"));
//        String ior = input.readLine();
        org.omg.CORBA.Object obj = orb.string_to_object("IOR:000000000000001449444c3a48656c6c6f5365727665723a312e3000000000010000000000000096000102000000000a3132372e302e312e3100b49100000048afabcb00000000206fe9875200000001000000000000000200000008526f6f74504f41000000000f48656c6c6f536572766572504f4100000000000b416e794f626a656374494414000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002");


        target = HelloServerHelper.narrow(obj);
    }


    /**
     * Obtain ORB Interface.
     *
     * @return
     */
    public HelloServer getORBInterface() {
        return target;
    }


    /**
     * Shutdown ORB.
     */
    public void shutdown() {
        orb.shutdown(true);
    }


    /**
     * Test driver for HelloClientImpl.
     * @param args
     */
    public static void main(String[] args) {
        try {
            HelloClientImpl test = new HelloClientImpl();
            test.getORBInterface().sayHello("liguofa");
            //停止
            test.shutdown();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}