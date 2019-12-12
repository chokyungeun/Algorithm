package com.ssafy;

import java.io.*;
import java.util.*;

public class Main_백준_2623_음악프로그램_서울9반_조경은 {
	public static int N,M;
	public static Node[] adjList;
	public static int[] inDegree;
	
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new Node[N+1];
		inDegree = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int[] arr = new int[num];
			for(int j=0; j<arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			for(int j=1; j<arr.length; j++) {
				int from = arr[j-1];
				int to = arr[j];
				adjList[from] = new Node(to, adjList[from]);
				inDegree[to]++;
			}
		}
		String res = go();
		if(res==null) {
			System.out.println(0);
		}
		else {
			System.out.println(res);
		}
		
	}

	private static String go() {
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(inDegree[i]==0) q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		int visitCnt = 0, current;
		while(!q.isEmpty()) {
			current = q.poll();
			visitCnt++;
			sb.append(current + "\n");
			
			Node temp = adjList[current];
			while(temp != null) {
				if(--inDegree[temp.vertex] == 0) q.offer(temp.vertex);	
				temp = temp.next;
			}
		}
		return visitCnt==N?sb.toString():null;
	}

}
