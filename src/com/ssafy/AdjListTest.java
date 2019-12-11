package com.ssafy;

import java.io.*;
import java.util.*;

/*
5
0 2 10
1 3 5
2 4 7
0 4 3
3 4 10
*/
public class AdjListTest {
	static int N=5;
	static Node[] adjList;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine()); // 간선수
		adjList = new Node[N]; // 0,1,2,3,4
		visited = new boolean[N];
		
		StringTokenizer st = null;
		int from, to, weight;
		for(int i=0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]); // 0 2 10
			adjList[to] = new Node(from, weight, adjList[to]); // 2 0 10 양방향일때 처리
		}
		
		System.out.println("adjList 생성");
		//dfs(0);
		bfs(0);
	}

	private static void bfs(int current) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[current] = true;
		q.offer(current);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			System.out.println(curr);
			Node temp = adjList[curr];
			while(temp != null) {
				if(!visited[temp.vertex]) {
					visited[temp.vertex] = true;
					q.offer(temp.vertex);
				}
				temp = temp.next;
			}
			
		}
	}

	// 현재 탐색 정점 기준으로 인접한 정점 방문
	private static void dfs(int current) {
		visited[current] = true;
		System.out.println(current);
		//자신의 인접리스트 처리
		Node temp = adjList[current];
		
		while(temp != null) {
			if(!visited[temp.vertex]) dfs(temp.vertex);
			temp = temp.next;
		}
	}

}
