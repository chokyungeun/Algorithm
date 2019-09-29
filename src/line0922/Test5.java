package line0922;

import java.util.*;
import java.io.*;

public class Test5 {
	public static int[] di = { -1, 1, 0, 0 }; // 상하좌우
	public static int[] dj = { 0, 0, -1, 1 }; // 상하좌우
	public static int R, C, I, J, res, index;
	public static int[][] arr;
	public static boolean[][] v;

	public static void dfs(int i, int j) {
		v[i][j] = true;
		index++;
		if(i==I && j==J) {
			if(index == I+J+1)
				res++;
		}
		for(int k=0; k<di.length; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if(ni>=0 && ni<R && nj>=0 && nj<C && v[ni][nj] == false && index < I+J+1) {
				dfs(ni, nj);
			}
		}
		index--;
		v[i][j] = false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		arr = new int[R][C];
		v = new boolean[R][C];
		I = sc.nextInt();
		J = sc.nextInt();
		res = 0;
		index = 0;

		if (I < 0 || I >= R || J < 0 || J >= C) {
			System.out.println("fail");
		} else {
			dfs(0, 0);

			System.out.println(I + J);
			System.out.println(res);
		}

	}

}
