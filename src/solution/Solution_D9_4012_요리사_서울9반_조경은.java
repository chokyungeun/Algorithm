package solution;
import java.io.*;
import java.util.*;

public class Solution_D9_4012_요리사_서울9반_조경은 {
	public static int N,res;
	public static int[][] arr;
	public static int[] A,B;
	public static boolean[] v;
	
	public static void calc() {
		int a=0, b=0;
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N/2; j++) {
				a+=arr[A[i]][A[j]];
				b+=arr[B[i]][B[j]];
			}
		}
		res = Math.min(res, Math.abs(a-b));
	}
	
	public static void permComb(int start, int count) {
		if(count==N/2) {
			int idx=-1;
			int x=0;
			for(int i=0; i<N; i++) {
				x=0;
				for(int j=0; j<A.length; j++) {
					if(A[j]==i) {
						x++;
					}
				}
				if(x==0) B[++idx]=i;
			}
			calc();
			return;
		}
		for(int i=start; i<N; i++) {
			if(!v[i]) {
				v[i] = true;
				A[count]=i;
				permComb(i,count+1);
				v[i]=false;
			}
		}
	}
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			v = new boolean[N];
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			A = new int[N/2];
			B = new int[N/2];
			res = Integer.MAX_VALUE;
			permComb(0,0);
			System.out.println("#" + t + " " + res);
		}
		
	}
}