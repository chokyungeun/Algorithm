package a1017;

import java.io.*;

public class Solution_D3_5601_쥬스나누기_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			int N = Integer.parseInt(br.readLine());
			System.out.print("#" + t + " " );
			for(int i=0; i<N; i++) {
				System.out.print("1/" + N + " ");
			}
			System.out.println();
		}

	}

}
