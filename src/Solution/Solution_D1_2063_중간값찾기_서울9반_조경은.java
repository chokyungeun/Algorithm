package Solution;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Arrays;

public class Solution_D1_2063_중간값찾기_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d1_2063.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[]arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int num = N/2;
		System.out.println(arr[num]);

	}

}
