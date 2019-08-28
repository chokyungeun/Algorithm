package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_3499_퍼펙트셔플_서울9반_조경은{

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_3499.txt"));
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for(int T=1; T<t+1; T++) {
			int num = sc.nextInt();
			String[] arr = new String[num];
			
			for(int i=0; i<num; i++) {
				arr[i] = sc.next();
			}
			
			String[] arr2 = new String[num];
			int n = 0;
			if(num%2 == 0) {
				for(int i=0; i<num/2; i++) {
					arr2[n] = arr[i];
					n++;
					arr2[n] = arr[i+num/2];
					n++;
				}
			}
			else {
				for(int i=0; i<(num+1)/2; i++) {
					arr2[n] = arr[i];
					n++;
					if(i == (num+1)/2-1) {
						break;
					}
					arr2[n] = arr[i+(num+1)/2];
					n++;
				}
			}
			
			System.out.print("#" + T + " " );
			for(int i=0; i<arr2.length; i++)
				System.out.print(arr2[i] + " ");
			System.out.println();
		}
	}
}
