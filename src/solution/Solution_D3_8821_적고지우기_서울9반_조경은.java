package solution;

import java.io.*;
import java.util.*;

public class Solution_D3_8821_적고지우기_서울9반_조경은 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			ArrayList<Character> list = new ArrayList<>();
			char[] c = br.readLine().toCharArray();
			for(int i=0; i<c.length; i++) {
				if(list.contains(c[i])) list.remove(Character.valueOf(c[i]));
				else list.add(c[i]);
			}
			System.out.println("#" + t + " " + list.size());
		}

	}

}
