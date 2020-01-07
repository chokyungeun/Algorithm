package solution;
import java.io.*;
import java.util.*;

public class Main_백준_17825_주사위윷놀이_서울9반_조경은 {
	public static int[] dice,curr,temp;
	public static int res;
	public static boolean[] v;
	public static int[][] map = {{0,2,4,6,8,10},
								{10,12,14,16,18,20},
								{20,22,24,26,28,30},
								{30,32,34,36,38,40,0},
								{10,13,16,19,25},
								{20,22,24,25},
								{25,30,35,40,0},
								{30,28,27,26,25}};
			
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		dice = new int[10];
		temp = new int[10];
		curr = new int[2];
		for(int i=0; i<10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		curr[0]=0;
		curr[1]=0;
		res=0;
		v = new boolean[10];
		permComb(0,0);
		System.out.println(res);
		
	}
	
	public static void permComb(int start, int count) {
		if(count==10) {
			go();
			return;
		}
		for(int i=start; i<10; i++) {
			if(!v[i]) {
				v[i] = true;
				temp[count] = dice[i];
				permComb(i, count+1);
				v[i] = false;
			}
		}
	}
	
	public static void go() {
		for(int i=0; i<10; i++) {
			if(curr[1]+temp[i]<map[curr[0]].length) {
				curr[1]+=temp[i];
				res+=map[curr[0]][curr[1]];
				if(curr[1]==map[curr[0]].length-1) {
					move(curr[0]);
				}
			}
			else {
				if(curr[0]==1 || curr[0]==2 || curr[0]==0) {
					int t = (curr[1]+temp[i])%map[curr[0]].length;
					curr[0]++;
					if(t<map[curr[0]].length) {
						curr[1] = t;
					}
				}
			}
		}
	}
	
	public static void move(int x) {
		if(curr[0]==0 || curr[0]==1 || curr[0]==2) {
			int t = (curr[1]+temp[x])%map[curr[0]].length;
			curr[0]++;
			if(t<map[curr[0]].length) {
				curr[1] = t;
			}
			else {
				if(curr[0]==4) {
					curr[0]
				}
			}
			
		}
		else if()
	}
}

