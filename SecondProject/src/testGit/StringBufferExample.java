package testGit;

import java.nio.Buffer;

public class StringBufferExample {

	public static void main(String[] args) {
		String x = "abc";
		
		String y = x.toUpperCase();
		
		StringBuffer sb = new StringBuffer();
		sb.append("abc");
		sb.append("xyz");
		
		sb.reverse();
		String sub = sb.substring(0,3);
		System.out.println(sb.toString());
		System.out.println(sub);
		
		sb.insert(3, "123");
		System.out.println("length="+sb.length());
		System.out.println(sb.toString());
		sb.delete(3, 6);
		System.out.println("length="+sb.length());
		System.out.println("capacity="+sb.capacity());
		System.out.println(sb.toString());
		//change x to be abc123xyz
		String x2 = "FGHUIO";
		x2 = x2.substring(0,3)+"123"+x2.substring(3);
		System.out.println(x2);
		x2 = x2.substring(0,3)+x2.substring(6);
		System.out.println(x2);
		
		
		
		StringBuffer sT = new StringBuffer ("Java");
		sT.replace(0, 2, "Hello");
		System.out.println(sT);
		
	}
}
