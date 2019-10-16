package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4008_숫자만들기_서울9반_조경은 {
	public static int N, max, min, tot, res, plus, minus, mul, div;
	public static int[] num;
	public static char[] op;
	public static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			num = new int[N];
			tot = N - 1;
			v = new boolean[tot];
			op = new char[tot];
			StringTokenizer st = new StringTokenizer(br.readLine());
			plus = Integer.parseInt(st.nextToken());
			minus = Integer.parseInt(st.nextToken());
			mul = Integer.parseInt(st.nextToken());
			div = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;

			
			dfs(0);

			System.out.println("#" + t + " " + (max - min));
		}
	}

	private static void dfs(int count) {
		if(count>=tot) {
			cal();
			return;
		}
		if(plus != 0) {
			plus--;
			op[count] = '+';
			dfs(count+1);
			plus++;
		}
		if(minus != 0) {
			minus--;
			op[count] = '-';
			dfs(count+1);
			minus++;
		}
		if(mul != 0) {
			mul--;
			op[count] = '*';
			dfs(count+1);
			mul++;
		}
		if(div != 0) {
			div--;
			op[count] = '/';
			dfs(count+1);
			div++;
		}
		
	}

	private static void cal() {
		int n = -1;
		res = num[0];
		for (int i = 1; i < tot + 1; i++) {
			n++;
			if (op[n] == '+') {
				res += num[i];
			} else if (op[n] == '-') {
				res -= num[i];
			} else if (op[n] == '*') {
				res *= num[i];
			} else if (op[n] == '/') {
				if (res < 0) {
					res = ((res * (-1)) / num[i]) * -1;
				} else {
					res /= num[i];
				}
			}
		}
		max = Math.max(res, max);
		min = Math.min(res, min);

	}

}
