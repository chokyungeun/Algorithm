package algoad3;
import java.io.*;
import java.util.*;

public class Main_백준_16985_Maaaaaaaaaze_서울9반_조경은 {
	public static int[][][] map,temp;
	public static int[][][] memo;
	public static boolean[] v;
	public static int[] d;
	public static int res;
	public static int[][] di;
	public static int[][] dj;
	
	//회전 powerset, 위치 permcomb
	public static void permComb(int start, int count) {
		if(count==5) {
			temp = new int[5][5][5];
			for(int i=0; i<d.length; i++) {
				for(int j=0; j<temp[i].length; j++) {
					temp[i][j] = Arrays.copyOf(map[d[i]][j], map[d[i]][j].length);
				}
			}
			go();
			return;
		}
		for(int i=0; i<5; i++) {
			if(!v[i]) {
				v[i] = true;
				d[count] = i;
				permComb(i,count+1);
				v[i] = false;
			}
		}
	}
	
	//회전은 powerset
	public static void go() {
		//5가지 판을 0,1,2,3번 돌렸을 경우. => 4^5
		int[] arr;
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				for(int k=0; k<4; k++) {
					for(int l=0; l<4; l++) {
						for(int m=0; m<4; m++) {
							arr = new int[]{i,j,k,l,m};
							rotate(arr);
						}
					}
				}
			}
		}
		
	}
	
	public static void rotate(int[] num) {
		for(int i=0; i<5; i++) {
			int n = num[i];
			for(int j=0; j<n; j++) {
				
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[5][5][5];
		memo = new int[5][5][5];
		res=-1;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				st = new StringTokenizer(br.readLine());
				Arrays.fill(memo[i][j], Integer.MAX_VALUE);
				for(int k=0; k<5; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		v = new boolean[5];
		
		d = new int[5];
		permComb(0,0);
		System.out.println(res);
	}

}
