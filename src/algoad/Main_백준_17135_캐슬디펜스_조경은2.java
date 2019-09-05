package algoad;

import java.io.*;
import java.util.*;

public class Main_백준_17135_캐슬디펜스_조경은2 {
	public static int N, M, D, endLine,max;
	public static int[] l;
	public static boolean[] v;
	public static int[][] arr;
	public static ArrayList<int[]> pos;

	private static void comb(int a, int b) {
		if (b == 3) {
			func();
			return;
		}

		for (int i = a; i < M; i++) {
			if(!v[i]) {
				v[i]=true;
				l[b] = i;
				comb(i, b+1);
				v[i] = false;
			}
			
		}
	}

	private static void func() {
		int[][] arr2 = new int[N + 1][M];
		for (int i = 0; i < arr.length; i++) {
			System.arraycopy(arr[i], 0, arr2[i], 0, arr[i].length);
		}
		
		int cnt=0; int sum=0;
		while(cnt<endLine) {
			pos.clear();
			
			for(int k=0; k<3; k++) {
				int shotI=77;
				int shotJ=77;
				int distT=D;
				for(int i=N-1; i>=0; i--) {
					for(int j=0; j<M; j++) {
						if(arr2[i][j]==1 && distance(i,j,N,l[k])<distT) {
							distT=distance(i,j,N,l[k]);
							shotI=i;
							shotJ=j;
						}
						else if(arr2[i][j]==1 && distance(i,j,N,l[k])==distT) {
							if(j<shotJ) {
								shotI=i;
								shotJ=j;
							}
						}
					}
				}
				if(shotI!=77 && shotJ!=77) {
					pos.add(new int[] {shotI,shotJ});
				}
			}
			for(int i=0; i<pos.size(); i++) {
				if(arr2[pos.get(i)[0]][pos.get(i)[1]]==1) {
					arr2[pos.get(i)[0]][pos.get(i)[1]]=0;
					sum++;
				}
			}
			
			for(int i=N-1; i>=1; i--)
				arr2[i]=arr2[i-1].clone();
			Arrays.fill(arr2[N-1], 0);
		}
		max = Math.max(max, sum);
		
	}

	private static int distance(int i1, int j1, int i2, int j2) {
		
		return Math.abs(i1 - i2) + Math.abs(j1 - j2);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		endLine=0;
		l = new int[3];
		v=new boolean[M];
		arr = new int[N + 1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1 && endLine==-1)
					endLine=N-i;
			}
		}
		max = 0;
		pos = new ArrayList<>();
		comb(0, 0);


		System.out.println(max);
	}

}
