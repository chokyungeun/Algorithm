package queue;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Bfs {
	public static int V;
	public static int E;
	public static int[][] graph;
	public static boolean[] visit;
	public static Queue<Integer> queue;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bfs.txt"));
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		graph = new int[V][V];
		queue = new LinkedList<Integer>();

		for (int i = 0; i < E; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			graph[v1][v2] = 1;
			graph[v2][v1] = 1; // 양방향
		}
		/*
		 * for(int[] a: graph) System.out.println(Arrays.toString(a));
		 */
		bfs2(0);
		System.out.println();
	}

	public static void bfs2(int node) { //queue에 중복해서 들어가는 경우가 없음.(queue에 들어가는 양이 줄어듬)
		int cnt = 0;
		visit = new boolean[V];
		visit[node] = true;
		queue.offer(node);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				int curr = queue.poll();
				System.out.print(curr + " ");
				for (int next = 0; next < V; next++) { // 0 1 2 3 4 5 6
					if (visit[next] == false && graph[curr][next] == 1) {
						visit[next] = true;
						queue.offer(next);
					}
				}
			}
			System.out.println("cnt=" + cnt++);
		}
	}

	public static void bfs(int node) {
		visit = new boolean[V];
		queue.offer(node);
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			if (visit[curr] == false) {
				visit[curr] = true;
				System.out.print(curr + " ");

				for (int next = 0; next < V; next++) { // 0 1 2 3 4 5 6
					if (visit[next] == false && graph[curr][next] == 1) {
						queue.offer(next);
					}
				}
			}
		}
	}

}
