package solution;

import java.io.FileInputStream;
import java.util.Scanner;
public class Solution_D3_1225_암호생성기_서울9반_조경은 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1225.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int tc=0; tc<10; tc++) {
			int t = sc.nextInt();
			int[] arr = new int[8];
			for(int j=0; j<8; j++) {
				arr[j] = sc.nextInt();
			}
			int i=0;
			while(true) { //0이 될 때까지 계속 반복
				++i; //i를 1씩 증가
				if(i==6) //i가 6이 되면 i를 1로 다시 설정
					i = 1;
				if(arr[7] == 0)
					break; //0이 나오면 break
				arr[0] = arr[0]-i;
				if(arr[0] < 0)
					arr[0] = 0;
				int temp = arr[0];
				for(int j=0; j<7; j++) { //하나씩 앞으로 옮김
					arr[j] = arr[j+1];
				}
				arr[7] = temp;
			}
			System.out.print("#" + t + " ");
			for(int j:arr) {
				System.out.print(j+ " ");
			}
			System.out.println();
		}
	}
}
