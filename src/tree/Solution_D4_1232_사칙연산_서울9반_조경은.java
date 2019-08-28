package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


class Node {

	String x;
	int left;
	int right;

	public Node(String item, int left, int right) {

		this.x = item;
		this.left = left;
		this.right = right;
	}
}

public class Solution_D4_1232_사칙연산_서울9반_조경은 {
	static Node[] a;
	static int Answer;
	static int N;

	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1232.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String x;
		int num1, num2, n;

		for (int tc = 1; tc < 11; tc++) {

			N = Integer.parseInt(br.readLine());

			a = new Node[N + 1];

			for(int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine());

				n = Integer.parseInt(st.nextToken());
				x = st.nextToken();

				if (st.hasMoreTokens())
					a[n] = new Node(x, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				else
					a[n] = new Node(x, 0, 0);
			}

			for (int i = N; i >= 1; i--) {

				if (a[i].left != 0) {
					
					num1 = Integer.parseInt(a[a[i].left].x);
					num2 = Integer.parseInt(a[a[i].right].x);

					switch (a[i].x) {

					case "+":

						a[i].x = Integer.toString((num1 + num2));
						break;

					case "-":

						a[i].x = Integer.toString((num1 - num2));
						break;

					case "*":

						a[i].x = Integer.toString((num1 * num2));
						break;

					case "/":

						a[i].x = Integer.toString((num1 / num2));
						break;
					}

				}
			}
			System.out.println("#" + tc + " " + a[1].x);
		}
		br.close();
	}

}