package solution;

import java.io.*;
import java.util.*;

public class Main_백준_15663_N과M9_서울9반_조경은 {
	public static int N, M;
	public static int[] a, d;
	public static boolean[] v;
	public static ArrayList<int[]> list;

	public static void permComb(int start, int count) {
		if (count == M) {
			//System.out.println(Arrays.toString(a));
			boolean flag2 = false;
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).equals(a)) {
					flag2=true;
					break;
				}
			}
			if(!flag2) {
				System.out.println("yes");
				list.add(a);
			}
			System.out.println(list.get(0)[0]);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				a[count] = d[i];
				permComb(i, count + 1);
				v[i] = false;
				
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[M];
		d = new int[N];
		v = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(d);
		permComb(0, 0);
		
		/*for(int i=0; i<list.size(); i++) {
			for(int j=0; j<list.get(i).length; j++) {
				System.out.print(list.get(i)[j] + " ");
			}
			System.out.println();
		}*/
	}

}
