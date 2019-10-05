package nhn0929;

import java.io.*;
import java.util.*;

public class Test4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		
		int road = Integer.parseInt(br.readLine());
		ArrayList<char[]> list = new ArrayList<>();
		for(int i=0; i<road; i++) {
			s = br.readLine().split(" ");
			list.add(new char[] {s[0].charAt(0), s[1].charAt(0), s[2].charAt(0)});
			
		}
		

	}

}
