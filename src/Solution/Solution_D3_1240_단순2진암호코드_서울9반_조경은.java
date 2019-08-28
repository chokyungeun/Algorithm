package Solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1240_단순2진암호코드_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D3_1240.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			String s = br.readLine();
			String[] sa = s.split(" ");
			int N = Integer.parseInt(sa[0]);
			int M = Integer.parseInt(sa[1]);
			String str = new String();
			int index = 0;
			for(int i=0; i<N; i++) {
				s = br.readLine();
				if(s.contains("1")) {
					str = s;
					for (int j = 0; j < M; j++) {
						if (s.charAt(j) == '1')
							index = j;
					}
				}
			}
			int[] arr = new int[8];
			String[] num = new String[8];
			for(int i=7; i>=0; i--) {
				num[i] = str.substring(index - 6, index + 1); 
				index -= 7;
			}
			for(int i=0; i<8; i++) {
				if(num[i].equals("0001101")) {
					arr[i] = 0;
				}
				else if(num[i].equals("0011001")) {
					arr[i] = 1;
				}
				else if(num[i].equals("0010011")) {
					arr[i] = 2;
				}
				else if(num[i].equals("0111101")) {
					arr[i] = 3;
				}
				else if(num[i].equals("0100011")) {
					arr[i] = 4;
				}
				else if(num[i].equals("0110001")) {
					arr[i] = 5;
				}
				else if(num[i].equals("0101111")) {
					arr[i] = 6;
				}
				else if(num[i].equals("0111011")) {
					arr[i] = 7;
				}
				else if(num[i].equals("0110111")) {
					arr[i] = 8;
				}
				else if(num[i].equals("0001011")) {
					arr[i] = 9;
				}
				
				
			}
			int res = ((arr[0] + arr[2] + arr[4] + arr[6])*3) + (arr[1] + arr[3] + arr[5]) + arr[7];
			int result = 0;
			if(res % 10 == 0) {
				for(int i=0; i<8; i++) {
					result+=arr[i];
				}
				
			}
			System.out.println("#" + t + " " + result);
		}

	}

}
