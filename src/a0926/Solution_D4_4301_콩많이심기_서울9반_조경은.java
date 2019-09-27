package a0926;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_D4_4301_콩많이심기_서울9반_조경은 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            String[] s = br.readLine().split(" ");
            int M = Integer.parseInt(s[0]);
            int N = Integer.parseInt(s[1]);
             
            int[][] arr = new int[N][M];
            boolean[][] v = new boolean[N][M];
            int res = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(!v[i][j]) {
                        arr[i][j] = 1;
                        if(i+2<N)
                            v[i+2][j] = true;
                        if(j+2<M)
                            v[i][j+2] = true;
                    }
                }
            }
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(arr[i][j] == 1)
                        res++;
                }
            }
             
            System.out.println("#" + t + " " + res);
        }
    }
}