package com.ssafy;
import java.io.*;
import java.util.*;

public class Main_정올_3118_최단경로2_서울9반_조경은 {
	public static int N,M;
	public static Node[] adjList;
	
//	public static class Node implements Comparator<Node>{
//		int v; //정점 정보
//		int weight; //가중치
//		Node next; //연결하고있는 노드
//		
//		public Node(int v, int weight) {
//			this.v = v;
//			this.weight = weight;
//		}
//
//		public Node(int v, int weight, Node next) {
//			this.v = v;
//			this.weight = weight;
//			this.next = next;
//		}
//
//		@Override
//		public String toString() {
//			return "Node [v=" + v + ", weight=" + weight + ", next=" + next + "]";
//		}
//
//		@Override
//		public int compare(Node o1, Node o2) {
//			return o1.weight-o2.weight;
//		}
//		
//	}
	public static class Node implements Comparable<Node>{
		int v; //정점 정보
		int weight; //가중치
		Node next; //연결하고있는 노드
		
		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		
		public Node(int v, int weight, Node next) {
			this.v = v;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [v=" + v + ", weight=" + weight + ", next=" + next + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight; //음수 or 0: 그대로. 양수: 교환
		}

	}
	
	public static int go() {
		int[] D = new int[N+1];
		boolean[] v = new boolean[N+1];
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		Arrays.fill(D, Integer.MAX_VALUE);
		D[1] = 0;
		q.offer(new Node(1,0));
		Node temp,cur;
		while(true) {
			//1. 미방문정점중 최소비용 정점 찾기
			cur=q.poll();
			if(v[cur.v]) continue;
			if(cur.v==N) return cur.weight; //도착점이면 그때의 최소비용 리턴
			v[cur.v] = true;
			//2. cur을 경유지로 하여 미방문정점까지의 최소비용 갱신
			temp=adjList[cur.v];
			while(temp!=null) {
				if(!v[temp.v] && D[temp.v]>cur.weight+temp.weight) {
					D[temp.v] = cur.weight+temp.weight;
					q.offer(new Node(temp.v, D[temp.v]));
				}
				temp=temp.next;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new Node[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to,weight,adjList[from]);
		}
		
		System.out.println(go());
	}

}
