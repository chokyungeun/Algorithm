package nhn0929;

import java.io.*;
import java.util.*;

public class Test1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		ArrayList<String[]> list = new ArrayList<>();
		
		
		for(int i=0; i<N; i++) {
			boolean tf=false;
			for(int j=0; j<list.size(); j++) {
				if(list.get(j)[0].equals(s[i])) {
					list.set(j, new String[] {s[i], Integer.toString(Integer.parseInt(list.get(j)[1])+1)});
					tf = true;
					break;
				}
			}
			if(!tf) {
				list.add(new String[] {s[i],Integer.toString(1)});
			}
		}
		
		int max = Integer.parseInt(list.get(0)[1]);
		int n1=0;
		int n2=0;
		for(int i=1; i<list.size(); i++) {
			if(max < Integer.parseInt(list.get(i)[1])) {
				max = Integer.parseInt(list.get(i)[1]);
			}
		}
		
		for(int i=0; i<list.size(); i++) {
			if(max == Integer.parseInt(list.get(i)[1]))
				n1++;
			else if((max-1) == Integer.parseInt(list.get(i)[1]))
				n2++;
		}
		
		if(n1 == list.size()) {
			System.out.println("Y");
			System.out.println(N);
			System.out.println(list.size());
		}
		
		
		else if(n1==list.size()-1 && n2==1) {
			System.out.println("Y");
			System.out.println(N+1);
			System.out.println(list.size());
		}
		else {
			System.out.println("N");
			System.out.println(N);
			System.out.println(list.size());
		}
	}

}
