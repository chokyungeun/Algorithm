package a0926;

import java.util.*;
import java.io.*;

public class Main_정올_2247_도서관_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s;
		ArrayList<int[]> list = new ArrayList<>();
		ArrayList<Integer> yes = new ArrayList<>();
		ArrayList<Integer> no = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			list.add(new int[] {Integer.parseInt(s[0]), Integer.parseInt(s[1])});
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		while(list.size() != 0) {
			int start = list.get(0)[0];
			int end = list.get(0)[1];
			
			if(list.size() == 1) {
				yes.add(end-start);
				break;
			}
			
			ArrayList<int[]> nlist = new ArrayList<>();
			
			for(int i=1; i<list.size(); i++) {
				if(end < list.get(i)[0]) {
					nlist.add(list.get(i));
					
				}
				else {
					end = Math.max(end, list.get(i)[1]);
				}
			}
			
			yes.add(end - start);
			
			if(nlist.size() == 0) {
				break;
			}
			
			Collections.sort(nlist, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}
			});
			
			no.add(nlist.get(0)[0]-end);
			
			list = new ArrayList<>();
			for(int i=0; i<nlist.size(); i++) {
				list.add(nlist.get(i));
			}
			
		}
		
		int yes_max = 0;
		for(int i=0; i<yes.size(); i++) {
			yes_max = Math.max(yes_max, yes.get(i));
		}
		int no_max = 0;
		for(int i=0; i<no.size(); i++) {
			no_max = Math.max(no_max, no.get(i));
		}
		System.out.println(yes_max + " " + no_max);
		

	}

}
