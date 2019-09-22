package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D2_2005_파스칼의삼각형_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] arr2 = new int[N];
			arr[0] = 1;
			System.out.println("#" + t);
			System.out.println(1);
			int n=1;
			for(int i=1; i<N; i++) {
				++n;
				System.out.print(1 + " ");
				for(int j=1; j<n; j++) {
					System.out.print(arr[j-1] + arr[j] + " ");
					arr2[j] = arr[j-1] + arr[j];
				}
				for(int j=1; j<n; j++) {
					arr[j] = arr2[j];
				}
				
				System.out.println();
			}
		}


	}

}
