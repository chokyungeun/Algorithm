package solution;

import java.io.*;
import java.util.*;

public class Main_백준_3190_뱀_서울9반_조경은2 {
	public static int N,K,L,sec, dir,length,ci,cj;
	public static boolean[][] map, apple;
	public static ArrayList<String[]> snake;
	public static ArrayList<int[]> move;
	public static int[] di= {0,-1,0,1};
	public static int[] dj = {1,0,-1,0};
	
	public static void game() {
		int index=0;
		move.add(new int[] {0,0});
		map[0][0] = true;
		while(true) {
			ci += di[dir];
			cj += dj[dir];
			
			index++;
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
			if(ci<0 || ci>=N || cj<0 || cj>=N || map[ci][cj]) {
				sec = index;
				
				return;
			}
			
			move.add(new int[] {ci,cj});
			map[ci][cj] = true;
			if(apple[ci][cj]) {
				apple[ci][cj] = false;
			}
			else {
				map[move.get(0)[0]][move.get(0)[1]] = false;
				move.remove(0);
			}
			
			if(snake.size()>0 && index==Integer.parseInt(snake.get(0)[0])) {
				if(snake.get(0)[1].equals("L")) {
					dir = (dir+1)%4;
				}
				else {
					dir = (dir+3)%4;
				}
				snake.remove(0);
			}
			
		}
	}
			
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		snake = new ArrayList<>();
		move = new ArrayList<>();
		
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		apple = new boolean[N][N];
		
		K = Integer.parseInt(br.readLine());
		int x=0;
		int y=0;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			apple[x][y] = true;
		}
		
		L = Integer.parseInt(br.readLine());
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			snake.add(new String[] {st.nextToken(), st.nextToken()});
		}
		dir = 0;
		ci = 0;
		cj = 0;

		game();
		
		System.out.println(sec);
	}

}
