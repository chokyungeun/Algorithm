package com.ssafy;
import java.io.*;
import java.util.*;

public class Main_백준_2252_줄세우기_서울9반_조경은 {
	static int N,M;
	static Node[] adjList;
	static int[] inDegree;
	
	public static class Node{
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
		
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", next=" + next + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		adjList = new Node[N+1];
		inDegree = new int[N+1];
		
		int from, to;
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			from = Integer.parseInt(s[0]);
			to = Integer.parseInt(s[1]);
			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++; // to정점의 진입차수 증가
		}
		System.out.println(go());
	}

	private static String go() {
		Queue<Integer> q = new LinkedList<>();
		//1. 진입차수가 0인 정점들 큐에 넣기
		for(int i=1; i<=N; i++) {
			if(inDegree[i]==0) q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		int visitCnt = 0, current;
		while(!q.isEmpty()) {
			current = q.poll();
			visitCnt++;
			sb.append(current + " ");
			
			Node temp = adjList[current];
			while(temp != null) { //현재 정점의 인접 정점 처리(진입차수 1 감소 : 간선 끊음의 의미)
				if(--inDegree[temp.vertex] == 0) q.offer(temp.vertex);	
				temp = temp.next;
			}
		}
		return visitCnt==N?sb.toString():null;
	}

}
