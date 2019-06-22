package com.fod.service;

/**
* HelloServerHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从HelloServer.idl
* 2019年6月19日 星期三 下午08时52分21秒 CST
*/

public final class HelloServerHolder implements org.omg.CORBA.portable.Streamable
{
  public HelloServer value = null;

  public HelloServerHolder ()
  {
  }

  public HelloServerHolder (HelloServer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = HelloServerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    HelloServerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return HelloServerHelper.type ();
  }

}
