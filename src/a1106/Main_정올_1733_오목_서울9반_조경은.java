package a1106;

import java.io.*;
import java.util.*;

public class Main_정올_1733_오목_서울9반_조경은 {
	 public static int[][] arr;
	    public static int N = 19, res,dir,num;
	    public static int[] di = { 0, 1, 1, -1 };
	    public static int[] dj = { 1, 1, 0, 1 };
	  
	    public static boolean dfs(int i, int j) {
	        if (num == 5 && (i + di[dir] < 0 || i + di[dir] >= N || j + dj[dir] <= 0 || j + dj[dir] > N
	                || arr[i + di[dir]][j + dj[dir]] != arr[i][j])) {
	            res = arr[i][j];
	            return true;
	        }
	        int ni = i + di[dir];
	        int nj = j + dj[dir];
	        if (ni >= 0 && ni < N && nj >= 0 && nj < N && arr[ni][nj] == arr[i][j]) {
	            num++;
	            if (dfs(ni, nj))
	                return true;
	        }
	        return false;
	    }
	  
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        arr = new int[N][N];
	        for (int i = 0; i < N; i++) {
	            st = new StringTokenizer(br.readLine());
	            for (int j = 0; j < N; j++) {
	                arr[i][j] = Integer.parseInt(st.nextToken());
	            }
	        }
	        int x = 0;
	        int y = 0;
	        res = 0;
	        Loop: for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                if (arr[i][j] != 0) {
	                    for (int k = 0; k < 4; k++) {
	                        if ((i - di[k] < 0 || i - di[k] >= N || j - dj[k] < 0 || j - dj[k] >= N
	                                || arr[i - di[k]][j - dj[k]] != arr[i][j])) {
	                            dir=k;
	                            num=1;
	                            if (dfs(i, j)) {
	                                x = i;
	                                y = j;
	                                break Loop;
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        if (res == 0) {
	            System.out.println(0);
	        } else {
	            System.out.println(res);
	            System.out.println(x + 1 + " " + (y + 1));
	        }
	    }
	  
	}