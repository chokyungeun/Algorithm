
public class Test0925 {

	public static void main(String[] args) {
		char[] ca = {'1', '1', '0'};
		//char[] -> String
		String s = String.valueOf(ca);
		System.out.println(s);
		System.out.println(s+1);
		
		//String->long
		long l1 = Long.valueOf(s);
		System.out.println(l1);
		System.out.println(l1+1);
		
		long l2 = Long.valueOf(s,2);
		System.out.println(l2);
		System.out.println(l2+1);
		
		int i1 = Integer.valueOf(s, 3);
		System.out.println(i1);
	}

}
