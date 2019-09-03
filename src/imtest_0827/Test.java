package imtest_0827;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		String s = "";
		char[] c = {'A', 'B', 'C'};
		
		s += c[0];
		s += c[1];
		s += c[2];
		
		//s.substring(s.length());
		s = s.substring(0, s.length()-1);
		
		System.out.println(s);
		
	}

}
