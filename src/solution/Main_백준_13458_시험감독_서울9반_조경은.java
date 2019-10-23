package solution;

import java.io.*;
import java.util.*;

public class Main_백준_13458_시험감독_서울9반_조경은 {
	public static long[] ppl;
	public static long N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		ppl = new long[(int) N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			ppl[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());

		long res=N;
		for(int i=0; i<N; i++) {
			ppl[i] -= B;
			if(ppl[i]<=0) {
				continue;
			}
			res += ppl[i]/C;
			if(ppl[i]%C!=0) {
				res++;
			}
		}
		
		System.out.println(res);
	}

}
