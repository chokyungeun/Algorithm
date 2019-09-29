package line0922;

import java.util.*;
import java.io.*;

public class Test6 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		String x = s[1];
		ArrayList<String[]> list = new ArrayList<>();
		ArrayList<Character> ch = new ArrayList<>();
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			list.add(new String[] {s[0], s[1]});
			char[] c = s[1].toCharArray();
			for(int j=0; j<c.length; j++)
				ch.add(c[j]);
		}
		int max = Integer.parseInt(list.get(0)[0]);
		for(int i=1; i<list.size(); i++) {
			if(max < Integer.parseInt(list.get(i)[0]))
				max = Integer.parseInt(list.get(i)[0]);
		}
		
		int[][] arr = new int[2*max-1][ch.size()];
		
		printfunc();

	}

	private static void printfunc() {
		
		
	}

}
