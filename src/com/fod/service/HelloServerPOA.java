package com.fod.service;
/**
* HelloServerPOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从HelloServer.idl
* 2019年6月19日 星期三 下午08时52分21秒 CST
*/

public abstract class HelloServerPOA extends org.omg.PortableServer.Servant
 implements HelloServerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("sayHello", new java.lang.Integer (0));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // HelloServer/sayHello
       {
         String name = in.read_string ();
         this.sayHello (name);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:HelloServer:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public HelloServer _this() 
  {
    return HelloServerHelper.narrow(
    super._this_object());
  }

  public HelloServer _this(org.omg.CORBA.ORB orb) 
  {
    return HelloServerHelper.narrow(
    super._this_object(orb));
  }


} // class HelloServerPOA
