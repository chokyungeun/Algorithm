package com.ssafy;

// 연결리스트의 구성요소
public class Node {
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
