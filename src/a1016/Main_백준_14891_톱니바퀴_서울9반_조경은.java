package a1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_14891_톱니바퀴_서울9반_조경은 {
	public static char[][] gear;
	public static int K;
	public static boolean[] v;
	public static int[] d;
	
	public static void rotate(int num, int dir) {
		if(dir == 1) { //시계방향인 경우
			char temp = gear[num][7];
			for(int i=7; i>0; i--) {
				gear[num][i] = gear[num][i-1];
			}
			gear[num][0] = temp;
		}
		else { //반시계방향인 경우
			char temp = gear[num][0];
			for(int i=0; i<7; i++) {
				gear[num][i] = gear[num][i+1];
			}
			gear[num][7] = temp;
		}
	}
	
	public static void check(int num) {
		
		if(num-1>=0 && !v[num-1] && gear[num][6] != gear[num-1][2]) {
			v[num-1] = true;
			d[num-1] = d[num]*-1;
			check(num-1);
		}
		if(num+1<4 && !v[num+1] && gear[num][2] != gear[num+1][6]) {
			v[num+1] = true;
			d[num+1] = d[num]*-1;
			check(num+1);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gear = new char[4][8];
		for(int i=0; i<4; i++) {
			gear[i] = br.readLine().toCharArray();
		}
		
		K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			String[] s = br.readLine().split(" ");
			int num = Integer.parseInt(s[0])-1;
			int dir = Integer.parseInt(s[1]);
			
			d = new int[4];
			v = new boolean[4];
			
			v[num] = true;
			d[num] = dir;
			
			check(num);
			for(int j=0; j<4; j++) {
				if(v[j]) {
					rotate(j, d[j]);
				}
			}
		}
		
		int result = 0;
		for(int i=0; i<4; i++) {
			result += (gear[i][0]-'0')*(Math.pow(2, i));
		}
		
		System.out.println(result);
		
	}

}
