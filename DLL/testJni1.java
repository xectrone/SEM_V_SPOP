public class testJni1
{
	static{
		System.loadLibrary("native");
	}
		public static void main(String args[])
		{
			System.out.println("Addition is: " + new testJni1().add(10,20));
			
		}
		private native int add(int n1,int n2);
}



testJni1.java

public class testJni1
{
	static{ loadLibrary("native"); }

	public static void main(String args[])
	{
		System.out.println("Addition is : "+ new testJni1().add(10, 20));
	}

	private native int add(int n1, int n2);
}



testJni1.java

public class testJni1
{
	static{ loadLibrary("native"); }
	public static void main(String args[])
	{
		SYstem.out.println("Addition is :" + new testJni1().add(10, 20));
	}
	private native int add(int n1, int n2);
}











