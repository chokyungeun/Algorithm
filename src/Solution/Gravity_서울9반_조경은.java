package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Gravity_서울9반_조경은 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_gravity.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] num=new int[T+1];
		int[] arr = new int[T+1];
		
		int[] arr2 = new int[T+1];
		
		for(int i=0; i<T; i++) {
			arr2[i] = T-i-1;
			arr[i] = sc.nextInt();
		}

		for(int i=0; i<T; i++) {
			for(int j=i+1; j<T; j++) {
				if(arr[i] <= arr[j]) {
					arr2[i]--;
				}
			}
		}
		int max = arr2[0];
		for(int i=1; i<T; i++) {
			if(max < arr2[i])
				max = arr2[i];
		}
		System.out.println(max);
	}
}
