package com.fod.service;
/**
* HelloServerHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从HelloServer.idl
* 2019年6月19日 星期三 下午08时52分21秒 CST
*/

abstract public class HelloServerHelper
{
  private static String  _id = "IDL:HelloServer:1.0";

  public static void insert (org.omg.CORBA.Any a, HelloServer that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static HelloServer extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (HelloServerHelper.id (), "HelloServer");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static HelloServer read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_HelloServerStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, HelloServer value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static HelloServer narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof HelloServer)
      return (HelloServer)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _HelloServerStub stub = new _HelloServerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static HelloServer unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof HelloServer)
      return (HelloServer)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _HelloServerStub stub = new _HelloServerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
