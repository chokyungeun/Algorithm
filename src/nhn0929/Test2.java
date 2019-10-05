package nhn0929;

import java.io.*;
import java.util.*;

public class Test2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		int[] num = new int[101];
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			if(s[0].equals("enqueue")) {
				list.add(Integer.parseInt(s[1]));
				num[Integer.parseInt(s[1])]++;
			}
			else if(s[0].equals("dequeue")) {
				int max = num[0];
				int index=-1;
				for(int j=0; j<list.size(); j++) {
					if(max<num[list.get(j)]) {
						max = num[list.get(j)];
						index = j;
					}
				}
				
				if(max == 0)
					System.out.println("-1");
				else {
					System.out.println(list.get(index));
					num[list.get(index)]--;
					list.remove(index);
				}
				
				
			}
		}

	}

}
