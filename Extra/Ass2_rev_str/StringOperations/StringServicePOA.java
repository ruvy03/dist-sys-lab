package StringOperations;


/**
* StringOperations/StringServicePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from StringOperations.idl
* Wednesday, May 7, 2025 12:13:59 PM IST
*/

public abstract class StringServicePOA extends org.omg.PortableServer.Servant
 implements StringOperations.StringServiceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("concatenate", new java.lang.Integer (0));
    _methods.put ("reverse", new java.lang.Integer (1));
    _methods.put ("toUpperCase", new java.lang.Integer (2));
    _methods.put ("toLowerCase", new java.lang.Integer (3));
    _methods.put ("getLength", new java.lang.Integer (4));
    _methods.put ("contains", new java.lang.Integer (5));
    _methods.put ("substring", new java.lang.Integer (6));
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
       case 0:  // StringOperations/StringService/concatenate
       {
         String str1 = in.read_string ();
         String str2 = in.read_string ();
         String $result = null;
         $result = this.concatenate (str1, str2);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // StringOperations/StringService/reverse
       {
         String str = in.read_string ();
         String $result = null;
         $result = this.reverse (str);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // StringOperations/StringService/toUpperCase
       {
         String str = in.read_string ();
         String $result = null;
         $result = this.toUpperCase (str);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // StringOperations/StringService/toLowerCase
       {
         String str = in.read_string ();
         String $result = null;
         $result = this.toLowerCase (str);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 4:  // StringOperations/StringService/getLength
       {
         String str = in.read_string ();
         int $result = (int)0;
         $result = this.getLength (str);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 5:  // StringOperations/StringService/contains
       {
         String str = in.read_string ();
         String substring = in.read_string ();
         boolean $result = false;
         $result = this.contains (str, substring);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 6:  // StringOperations/StringService/substring
       {
         String str = in.read_string ();
         int start = in.read_long ();
         int end = in.read_long ();
         String $result = null;
         $result = this.substring (str, start, end);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:StringOperations/StringService:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public StringService _this() 
  {
    return StringServiceHelper.narrow(
    super._this_object());
  }

  public StringService _this(org.omg.CORBA.ORB orb) 
  {
    return StringServiceHelper.narrow(
    super._this_object(orb));
  }


} // class StringServicePOA
