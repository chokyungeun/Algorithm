package com.ssafy;
import java.io.*;
import java.util.*;

import com.ssafy.Main_백준_2252_줄세우기_서울9반_조경은.Node;

public class Main_백준_1707_이분그래프_서울9반_조경은 {
	public static int V,E;
	public static int[] color;
	static Node[] adjList;
	
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
	
	//현재 정점을 c색상으로 색칠하고 자신의 모든 인접 정점들의 색상을 c가 아닌 반대색으로 칠한다.
	public static boolean dfs(int cur, int c) {
		color[cur] = c;
		Node temp = adjList[cur];
		while(temp!=null) {
			//인접정점이 색이 칠해지지 않은 경우
			if(color[temp.vertex]==0) {
				if(!dfs(temp.vertex, 3-c)) {
					return false;//1이면 2를 주고 2면 1을 주기 위한 3-c
				}
			}
			else if(color[temp.vertex]==c) { //인접정점이 색이 칠해졌고 자신과 같은 색상이면 이분그래프 불가
				return false;
			}
			
			temp = temp.next;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		for(int t=0; t<K; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			color = new int[V+1]; //(0:칠해지지 않은 상태)
			adjList = new Node[V+1];
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adjList[from] = new Node(to, adjList[from]); // 0 2 10
				adjList[to] = new Node(from, adjList[to]);
				
			}
			
			boolean flag = true;
			for(int i=1; i<=V; i++) {
				if(color[i]==0) {
					if(!dfs(i,1)) {
						flag = false;
						break;
					}
				}
			}
			if(flag) System.out.println("YES");
			else System.out.println("NO");
			
		}
		
	}
	
	
	

}
