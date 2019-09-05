package a0905;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_정올_2634_사냥꾼_서울9반_조경은2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> mx = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			mx.add(Integer.parseInt(st.nextToken()));
		}
		int res = 0;

		int min = Collections.min(mx);
		int max = Collections.max(mx);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (x == min - L || x == max + L) {
				if (y == 0)
					res++;
			} 
			else if (y <= L && x > min - L && x < max + L) {
				for (int j = 0; j < M; j++) {
					if (Math.abs(x - mx.get(j)) + y <= L) {
						res++;
						break;
					}
				}
			}
		}

		System.out.println(res);
	}

}
