package SWmaestro2;
import java.io.*;
import java.util.*;

public class Solution3 {
	public static int N;
	public static ArrayList<int[]> list;
	public static int[] num;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		list = new ArrayList<>();
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new int[] {s,e});
		}
		
		for(int i=0; i<N; i++) {
			int start = list.get(i)[0];
			int end = list.get(i)[1];
			for(int j=0; j<N; j++) {
				if(list.get(j)[0]<start && list.get(j)[1]>start) {
					num[i]++;
				}
			}
		}
		for(int i=0; i<N; i++) {
			System.out.println(num[i]);
		}
	}

}
