package a1004;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_D4_1486_장훈이의높은선반_서울9반_조경은 {
	public static int N,r,a[],v[],H[];
	public static ArrayList<Integer> list;
	public static void permComb(int start, int count) {
		if(count == r) {
			int sum =0;
			for(int i=0; i<a.length; i++) {
				sum+= a[i];
			}
			list.add(sum);
			return;
		}
		for(int i=start; i<N; i++) {
			if(v[i]==0) {
				v[i] = 1; 
				a[count] = H[i];
				permComb(i,count+1);
				v[i] = 0; 
			} 
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1486.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken()); 
			st = new StringTokenizer(br.readLine());
			H = new int[N];
			for(int i=0; i<N; i++) {
				H[i] = Integer.parseInt(st.nextToken());
			}
			list = new ArrayList<>();
			for(int i=1; i<=N; i++) {
				r = i;
				a = new int[i];
				v = new int[N];
				permComb(0,0);
			}
			Collections.sort(list);
			int res = 0;
			for(int i=0; i<list.size(); i++) {
				if(list.get(i)>=B) {
					res = list.get(i)-B;
					break;
				}
			}
			System.out.println("#" + t + " " + res);
		}

	}

}
