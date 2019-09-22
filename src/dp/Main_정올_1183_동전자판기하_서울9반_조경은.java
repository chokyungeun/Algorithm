package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1183_동전자판기하_서울9반_조경은 {
	public static int[] coin = { 500, 100, 50, 10, 5, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int W = Integer.parseInt(br.readLine());
		int[] arr = new int[6];
		int[] arr2 = new int[6];
		int[] m = new int[W + 1];
		int num = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Loop: while (true) {
			for (int i = 5; i >= 0; i--) {
				if (W == 0) {
					break Loop;
				} 
				
				else {
					if(W/coin[i] > arr[i]) {
						num += arr[i];
						arr2[i] = arr[i];
						W -= (arr[i]*coin[i]);
					}
					else if(W/coin[i] == 0){
						
					}
					else {
						num += W / coin[i];
						arr2[i] += num;
						W %= coin[i];
					}
				}

			}
		}

		System.out.println(num);
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}

	}

}
