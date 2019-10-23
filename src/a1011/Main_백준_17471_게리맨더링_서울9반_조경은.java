package a1011;

import java.io.*;
import java.util.*;

public class Main_백준_17471_게리맨더링_서울9반_조경은 {
	public static int N, res;
	public static int[][] arr;
	public static int[] ppl, d,p;
	public static boolean[] v;
	public static boolean[][] visit;
	public static ArrayList<Integer> B;

	public static void powerset(int count) {
		if (count == N) {
			ArrayList<Integer> A = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				if (v[i])
					A.add(i);
			}
			p=new int[N];
			for(int i=0; i<N; i++) {
				p[i]=i;
			}
			possible(A);
			return;
		}
		v[count] = false;
		powerset(count + 1);
		v[count] = true;
		powerset(count + 1);
	}

	public static void possible(ArrayList<Integer> A) {
		
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.size(); j++) {
				if (visit[A.get(i)][A.get(j)] && getparent(A.get(i)) != getparent(A.get(j)))
					union(A.get(i), A.get(j));
			}
		}
		ArrayList<Integer> B = new ArrayList<>();
		for (int i = 0; i < A.size() - 1; i++) {
			for (int j = i + 1; j < A.size(); j++) {
				if (getparent(A.get(i)) != getparent(A.get(j))) {
					return;
				}
			}
		}
		boolean[] tf = new boolean[N];
		for (int i = 0; i < A.size(); i++) {
			tf[A.get(i)] = true;
		}
		for (int i = 0; i < N; i++) {
			if (!tf[i])
				B.add(i);
		}
		
		for (int i = 0; i < B.size(); i++) {
			for (int j = 0; j < B.size(); j++) {
				if (visit[B.get(i)][B.get(j)] && getparent(B.get(i)) != getparent(B.get(j)))
					union(B.get(i), B.get(j));
			}
		}
		for (int i = 0; i < B.size() - 1; i++) {
			for (int j = i + 1; j < B.size(); j++) {
				if (getparent(B.get(i)) != getparent(B.get(j))) {
					return;
				}
			}
		}
		cal(A, B);
	}

	public static void cal(ArrayList<Integer> A, ArrayList<Integer> B) {
		int a = 0;
		int b = 0;
		for (int i = 0; i < A.size(); i++) {
			a += ppl[A.get(i)];
		}
		for (int j = 0; j < B.size(); j++) {
			b += ppl[B.get(j)];
		}
		res = Math.min(res, Math.abs(a - b));
	}
	
	public static int getparent(int i) {
		if (p[i] == i)
			return i;
		return getparent(p[i]);
	}

	public static void union(int i, int j) {
		int pi = getparent(i);
		int pj = getparent(j);

		if (pi > pj)
			p[pi] = pj;
		else
			p[pj] = pi;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		v = new boolean[N];
		ppl = new int[N];
		d = new int[N];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			ppl[i] = Integer.parseInt(s[i]);
		}
		
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < Integer.parseInt(s[0]); j++) {
				visit[i][Integer.parseInt(s[j + 1]) - 1] = true;
				visit[Integer.parseInt(s[j + 1]) - 1][i] = true;
			}
		}
		
		
		res = Integer.MAX_VALUE;

		powerset(0);
		if (res == Integer.MAX_VALUE) {
			res = -1;
		}
		System.out.println(res);
		
	}

}
