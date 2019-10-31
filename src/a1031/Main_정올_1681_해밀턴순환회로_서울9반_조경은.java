package a1031;

import java.io.*;
import java.util.*;

public class Main_정올_1681_해밀턴순환회로_서울9반_조경은 {
	public static int N,res;
    public static int[][] arr;
    public static boolean[] v;
    public static int[] a;
     
    public static int func(int start) {
        int cost=0;
        for(int i=0; i<N; i++) {
            if(arr[a[i]][a[i+1]]!=0)
                cost += arr[a[i]][a[i+1]];
            else
                return Integer.MAX_VALUE;
        }
        return cost;
    }
     
    public static void permComb(int count) {
        if (count == N) {
            res= Math.min(res, func(0));
            return;
        }
        for (int i = 1; i < N; i++) {
            if (!v[i] && arr[a[count-1]][i]!=0) {
                v[i] = true;
                a[count] = i;
                permComb(count + 1);
                v[i] = false;
            }
        }
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        v = new boolean[N];
        a = new int[N+1];
        res = Integer.MAX_VALUE;
        permComb(1);
         
        System.out.println(res);
    }
 
}