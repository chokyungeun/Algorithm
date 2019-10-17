package a1017;

import java.io.*;
import java.util.*;

public class Main_백준_16235_나무재테크_서울9반_조경은 {
	public static int N;
	public static int[][] A, nutri;
	public static int[] di = { -1, -1, -1, 0, 0, 1, 1, 1 };
	public static int[] dj = { -1, 0, 1, -1, 1, -1, 0, 1 };
	public static ArrayList<Integer>[][] tinfo;
	
	public static void spring() {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int sum=0;
				for(int k=0; k<tinfo[i][j].size(); ) {
					if(nutri[i][j] < tinfo[i][j].get(k)) {
						sum += tinfo[i][j].get(k)/2;
						tinfo[i][j].remove(k);
						
					}
					else {
						nutri[i][j] -= tinfo[i][j].get(k);
						tinfo[i][j].set(k, tinfo[i][j].get(k)+1);
						k++;
					}
				}
				nutri[i][j] += sum;
			}
		}
		
	}


	public static void fall() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<tinfo[i][j].size(); k++) {
					if(tinfo[i][j].get(k)%5==0) {
						for (int l = 0; l < 8; l++) {
							int ni = i + di[l];
							int nj = j + dj[l];
							if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
								tinfo[ni][nj].add(0,1);
							}
						}
					}
				}
			}
		}
		
	}

	public static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				nutri[i][j] += A[i][j];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		A = new int[N][N];
		nutri = new int[N][N];
		tinfo = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				tinfo[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			
			tinfo[r][c].add(age);
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(nutri[i], 5);
		}

		for (int i = 0; i < K; i++) {
			spring();
			fall();
			winter();
		}
		
		int res=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				res += tinfo[i][j].size();
			}
		}

		System.out.println(res);

	}
}