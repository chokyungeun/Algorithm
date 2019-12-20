package a1220;

import java.io.*;
import java.util.*;

public class Solution2_2 {
	public static int N,M;
	public static Node[] adjList;
	public static int[] indegree;
	
	public static class Node{
		int num;
		Node next;
		
		public Node(int num, Node next) {
			this.num = num;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", next=" + next + "]";
		}
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			adjList = new Node[N+1];
			indegree = new int[N+1];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int small = Integer.parseInt(st.nextToken()); 
				int big = Integer.parseInt(st.nextToken()); 
				adjList[small] = new Node(big, adjList[small]);
				indegree[big]++;
			}
			//System.out.println();
			go();
			//System.out.println(adjList[5].num);
		}
	}
	
	public static void go() {
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(indegree[i]==0) q.offer(i);
		}
		Node temp;
		while(!q.isEmpty()) {
			int curr = q.poll();
			System.out.println(curr);
			temp = adjList[curr];
			indegree[temp.num]--;
			q.offer(temp.num);
			if(indegree[temp.num]>0) q.offer(curr);
		}
	}

}
