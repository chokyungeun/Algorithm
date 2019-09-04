package a0904;

import java.util.*;
import java.io.*;

public class Main_정올_1863_종교_서울9반_조경은2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int res = 1;
		int[] num = new int[n+1];
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int k=0; k<m; k++) {
			s = br.readLine().split(" ");
			int i = Integer.parseInt(s[0]);
			int j = Integer.parseInt(s[1]);
			num[i]++;
			num[j]++;
			if(j > i) {
				list.add(new int[] {i, j});
			}
			else {
				list.add(new int[] {j, i});
			}
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		for(int k=0; k<list.size()-1; k++) {
			int x = 0;
			for(int l=k+1; l<list.size(); l++) {
				if(list.get(k)[0] == list.get(l)[0] || list.get(k)[0] == list.get(l)[1] || list.get(k)[1] == list.get(l)[0] || list.get(k)[1] == list.get(l)[1]) {
					x++;
				}
			}
			if(x==0) {
				res++;
			}
		}
		for(int i=1; i<num.length; i++) {
			if(num[i] == 0) {
				res++;
			}
		}
		System.out.println(res);
	}

}
