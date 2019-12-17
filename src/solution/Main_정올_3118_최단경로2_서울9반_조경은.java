package solution;
import java.io.*;
import java.util.*;

import com.ssafy.Node;

public class Main_정올_3118_최단경로2_서울9반_조경은 {
	public static int N,M;
	public static Node[] adjList;
	public static boolean[] v;
	public static int[] inDegree;
	
	public static class Node{
		int vertex; //정점 정보
		int weight; //가중치
		Node next; //연결하고있는 노드
		
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + ", next=" + next + "]";
		}
		
	}
	
	public static int bfs() {
		int w=Integer.MAX_VALUE;
		Queue<int[]> q = new LinkedList<>();
		//1. 진입차수가 0인 정점들 큐에 넣기
		q.offer(new int[] {1,0});
		
		int[] current;
		while(!q.isEmpty()) {
			current = q.poll();
			if(current[0]==N) {
				w = Math.min(w, current[1]);
			}
			Node temp = adjList[current[0]];
			while(temp != null) { //현재 정점의 인접 정점 처리(진입차수 1 감소 : 간선 끊음의 의미)
				if(--inDegree[temp.vertex] == 0) q.offer(new int[] {temp.vertex,current[1]+temp.weight});	
				temp = temp.next;
			}
		}
		return w;
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
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to,weight,adjList[from]);
			inDegree[to]++; 
		}
		System.out.println(bfs());
		
	}

}
