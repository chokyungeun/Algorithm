package Solution;
import java.io.FileInputStream;
import java.util.Scanner;


public class Solution_D2_1204_최빈수구하기_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_1204.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[][]arr = new int[T][1001];
		int[] N = new int[T];
		for(int i=0; i<T; i++) {
			N[i] = sc.nextInt();
			for(int j=0; j<1000; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<T; i++) {
			int[] num = new int[102];
			int result = 0;
			for(int j=0; j<=100; j++) {
				for(int k=0; k<=1000; k++) {
					if(arr[i][k] == j)
						++num[j];
				}
			}
			int max = num[0];
			for(int j=0; j<=100; j++) {
				if(max <= num[j]) {
					max = num[j];
					result = j;
				}
			}
			System.out.println("#" + (i+1) + " " + result);
		}

	}

}
