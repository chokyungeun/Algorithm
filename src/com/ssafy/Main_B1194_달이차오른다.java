package com.ssafy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 김태희
 */
public class Main_B1194_달이차오른다 {

	static int row,col,startX,startY;
	static char map[][];
	static boolean[][][] visited;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new char[row][col];
		visited = new boolean[row][col][1<<6];
		
		char chArr[];
		for(int i=0; i<row; ++i) {
			chArr = br.readLine().toCharArray();
			for(int j=0; j<col; ++j) {
				if(chArr[j]=='0') {
					startX = i;
					startY = j;
				}
				map[i][j] = chArr[j];
			}
		}
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		visited[startX][startY][0] = true;
		queue.offer(new int[] {startX,startY,0,0}); // x,y,key,count
		
		int temp[],nx,ny,nk=0;
		while(!queue.isEmpty()) {
			temp = queue.poll();
			
          	// 출구이면
			if(map[temp[0]][temp[1]] == '1') return temp[3];
			
			for(int d=0; d<4; ++d) {
				nx = temp[0]+dx[d];
				ny = temp[1]+dy[d];
				nk = temp[2];
				
				// 경계를 벗어나거나  벽이면 다음으로
				if(nx<0 || nx >= row || ny<0 || ny>=col || map[nx][ny] == '#') continue;

				//이동할 위치에 문이 있다면 기존 열쇠들로 문을 열수 있는지 판단
				if(map[nx][ny]>='A' && map[nx][ny]<='F') {
					if((nk &(1<<(map[nx][ny]-'A')))==0 ) continue; //열쇠 없으면 다음으로
				//이동할 위치에 열쇠가 있다면 기존 열쇠의 조합에 처리
				}else if(map[nx][ny]>='a' && map[nx][ny]<='f') {	
					nk |= (1<<(map[nx][ny]-'a'));
				}
				
				if(!visited[nx][ny][nk]) {
					visited[nx][ny][nk] = true;
					queue.offer(new int[] {nx,ny,nk,temp[3]+1});
				}
			}// end for(direction)
		}// end while(queue)
		return -1;
	}
}
