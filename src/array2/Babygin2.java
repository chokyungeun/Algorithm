package array2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
//run보다 triple을 먼저 체크 해줘야함. 트리플이거나 런일 경우 다시 한 번 더 체크 해줘야함(i--)
public class Babygin2 {
	public static final int N = 6;
	public static int[] n = new int[6];
	public static int[] c;
	
	public static boolean solve () {
			int tri = 0;
			int run = 0;
			for(int i=0; i<c.length; i++) {
				if(c[i]>=3) {
					c[i] -= 3;
					tri++;
					i--;
				}
				else if(c[i]>=1 && c[i+1]>=1 && c[i+2]>=1 && i<=7) { //[i+2]에서 9를 넘어가지 않기 위해 i<=7 조건 추가
					c[i]--;
					c[i+1]--;
					c[i+2]--;
					run++;
					i--;
				}
			}
			if(tri + run == 2)
				return true;
			else
				return false;
		}
		
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_babygin.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<T+1; tc++) {
			c = new int[10];
			for(int i=0; i<N; i++) {
				n[i] = sc.nextInt();
				c[n[i]]++;
			}
			System.out.println("#" + tc + " " + solve());
		}
		sc.close();
	}

}
