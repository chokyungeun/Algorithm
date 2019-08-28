package Solution;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Solution_D3_1289_원재의메모리복구하기_서울9반_조경은 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		char[][] ca = new char[50][50];
		
		for(int k=0; k<T; k++) {
			String s = sc.next();
			ca[k] = s.toCharArray();
		}	
		for(int k=0; k<T; k++){
			int result = 0;
			
			for(int i=1; i<ca[k].length; i++) {
				if(ca[k][i] != ca[k][i-1]) 
					++result;
			}
			if(ca[k][0] == '1')
				++result;
			
			System.out.println("#" + (k+1) + " " + result);
		
		}
		
		/*
		for(int tc = 1; tc<=T; tc++) {
			String line = sc.next();
			//char[] chs = line.toCharArray();
			//System.out.println(Arrays.toString(chs));
			char cur ='0';
			int count = 0;
			//for(char ch:chs)
			for(int i=0; i<line.length(); i++) {
				char ch = line.charAt(i);
				if(ch!=cur) {
					count++;
					cur=ch;
				}
			}
			System.out.println("#" + tc + " " + count);
		}
		 */
	}

}
