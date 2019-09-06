package imtest_0827;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		String s = "123456";
		s += '7';
		int num = 7;
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		num++;
		sb.append('9');
		
		sb.delete(num-1, num);
		
		System.out.println(sb);
		
	}

}
