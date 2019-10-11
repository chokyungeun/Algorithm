package a1011;

import java.io.*;
import java.util.*;

public class Solution_d4_7701_염라대왕의이름정렬_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_7701.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TreeSet<String> list;
		ArrayList<String> nlist;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			list = new TreeSet<>();
			for(int i=0; i<N; i++) {
				list.add(br.readLine());
			}
			nlist = new ArrayList<>(list);
			Collections.sort(nlist, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.length()-o2.length();
				}
			});
			
			sb.append("#" + t+"\n");
			for(int i=0; i<nlist.size(); i++) {
				sb.append(nlist.get(i)+"\n");
			}
		}
		System.out.println(sb);
	}
}