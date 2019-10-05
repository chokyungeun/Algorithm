package nhn0929;

import java.io.*;
import java.util.*;

public class Test3 {

	public static boolean hasfollow(int num, ArrayList<int[]> list) {
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i)[0] == num) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] candy = new int[N+1];
		int p = 0;
		
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int i=0; i<s.length; i++) {
			if(s[i].equals("A")) {
				candy[p]++;
				if(hasfollow(p, list)) {
					for(int j=0; j<list.size(); j++) {
						if(list.get(j)[0] == p) {
							candy[list.get(j)[1]]++;
							
						}
					}
				}
				
			}
			else if(s[i].equals("J")) {
				if(p+1==N) {
					candy[p-1]++;
					for(int j=0; j<list.size(); j++) {
						if(list.get(j)[0] == p-1) {
							candy[list.get(j)[1]]++;
						}
					}
					candy[0]++;
					for(int j=0; j<list.size(); j++) {
						if(list.get(j)[0] == 0) {
							candy[list.get(j)[1]]++;
						}
					}
				}
				else if(p-1==-1) {
					candy[N-1]++;
					for(int j=0; j<list.size(); j++) {
						if(list.get(j)[0] == N-1) {
							candy[list.get(j)[1]]++;
						}
					}
					candy[1]++;
					for(int j=0; j<list.size(); j++) {
						if(list.get(j)[0] == 1) {
							candy[list.get(j)[1]]++;
						}
					}
				}
				else {
					candy[p-1]++;
					for(int j=0; j<list.size(); j++) {
						if(list.get(j)[0] == p-1) {
							candy[list.get(j)[1]]++;
						}
					}
					candy[p+1]++;
					for(int j=0; j<list.size(); j++) {
						if(list.get(j)[0] == p+1) {
							candy[list.get(j)[1]]++;
						}
					}
				}
			}
			else if(s[i].equals("Q")) {
				for(int j=0; j<N; j++) {
					candy[j]++;
				}
			}
			else if(s[i].equals("K")) {
				list.add(new int[] {p, Integer.parseInt(s[++i])});
				
			}
			
			
			
			p++;
			if(p == 5) {
				p=0;
			}
			
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(candy[i] + " ");
		}

	}

}
