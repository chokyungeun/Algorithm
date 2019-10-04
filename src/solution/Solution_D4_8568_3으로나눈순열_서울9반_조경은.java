package solution;

import java.io.*;
import java.util.*;

public class Solution_D4_8568_3으로나눈순열_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_8568.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] p = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				p[i] = Integer.parseInt(st.nextToken());
				if(p[i]%3 == (i+1)%3){
					p[i]=-1;
				}
			}
			int res = 0;
			while (true) {
				int n=0;
				for (int i = 0; i < N; i++) {
					boolean tf = false;
					if (p[i] != -1) {
						n++;
						for (int j = i + 1; j < N; j++) {
							if (p[j]!=-1 && (p[j] % 3) == (i + 1) % 3 && (p[i] % 3) == (j + 1) % 3) {
								res++;
								int temp = p[j];
								p[j] = p[i];
								p[i] = temp;
								p[i]=-1;
								p[j]=-1;
								tf = true;
								break;
							}
						}
						if(!tf) {
							for (int j = i + 1; j < N; j++) {
								if (p[j]!=-1 && (p[j] % 3) == (i + 1) % 3) {
									res++;
									int temp = p[j];
									p[j] = p[i];
									p[i] = temp;
									p[i]=-1;
									break;
								}
							}
						}
						
					}
				}
				if(n==0) {
					break;
				}
			}

			System.out.println("#" + t + " " + res);
		}
	}

}
