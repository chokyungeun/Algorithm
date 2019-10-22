package solution;

import java.io.*;
import java.util.*;

public class Main_백준_15683_감시_서울9반_조경은 {
	public static int[][] arr, temp, cctv;
	public static int N, M, min = Integer.MAX_VALUE;
	public static int[] di = { -1, 0, 1, 0 }; // 상우하좌
	public static int[] dj = { 0, 1, 0, -1 }; // 상우하좌
	public static ArrayList<int[]> c;
	public static boolean[] v;

	
	public static int up(int i, int j) {
		int temp=0;
		for(int x=i-1; x>=0; x--) {
			if(arr[x][j]==0) {
				temp++;
			}
			else if(arr[x][j]==6) {
				break;
			}
		}
		return temp;
	}
	public static int right(int i, int j) {
		int temp=0;
		for(int x=j+1; x<M; x++) {
			if(arr[i][x]==0) {
				temp++;
			}
			else if(arr[i][x]==6) {
				break;
			}
		}
		return temp;
	}
	public static int down(int i, int j) {
		int temp=0;
		for(int x=i+1; x<N; x++) {
			if(arr[x][j]==0) {
				temp++;
			}
			else if(arr[x][j]==6) {
				break;
			}
		}
		return temp;
	}
	public static int left(int i, int j) {
		int temp=0;
		for(int x=j-1; x>=0; x--) {
			if(arr[i][x]==0) {
				temp++;
			}
			else if(arr[i][x]==6) {
				break;
			}
		}
		return temp;
	}
	public static void oversee(int i, int j, int num) {
		
		if (num == 1) {
			int max = 0;
			int index = 0;
			for(int k=0; k<4; k++) {
				int ni = i;
				int nj = j;
				int temp = 0;
				for(int x=0; x<M; x++) {
					ni += di[k];
					nj += dj[k];
					if(ni<0 || ni>=N || nj<0 || nj>=M || arr[ni][nj]==6) {
						break;
					}
					else if(arr[ni][nj]==0) {
						temp++;
					}
				}
				if(max < temp) {
					max = temp;
					index = k;
				}
			}
			for(int k=0; k<4; k++) {
				if(index == k) {
					int ni = i;
					int nj = j;
					for(int x=0; x<M; x++) {
						ni += di[k];
						nj += dj[k];
						if(ni<0 || ni>=N || nj<0 || nj>=M || arr[ni][nj]==6) {
							break;
						}
						else if(arr[ni][nj]==0) {
							arr[ni][nj]=7;
						}
					}
					break;
				}
			}
			
		} else if (num == 2) {
			int temp1 = 0;
			int temp2 = 0;
			for(int x=i+1; x<N; x++) {
				if(arr[x][j]==0) {
					temp1++;
				}
				else if(arr[x][j]==6) {
					break;
				}
			}
			for(int x=i-1; x>=0; x--) {
				if(arr[x][j]==0) {
					temp1++;
				}
				else if(arr[x][j]==6) {
					break;
				}
			}
			for(int x=j+1; x<M; x++) {
				if(arr[i][x]==0) {
					temp2++;
				}
				else if(arr[i][x]==6) {
					break;
				}
			}
			for(int x=j-1; x>=0; x--) {
				if(arr[i][x]==0) {
					temp2++;
				}
				else if(arr[i][x]==6) {
					break;
				}
			}
			if(temp1>temp2) {
				for(int x=i+1; x<N; x++) {
					if(arr[x][j]==0) {
						arr[x][j]=7;
					}
					else if(arr[x][j]==6) {
						break;
					}
				}
				for(int x=i-1; x>=0; x--) {
					if(arr[x][j]==0) {
						arr[x][j]=7;
					}
					else if(arr[x][j]==6) {
						break;
					}
				}
			}
			else {
				for(int x=j+1; x<M; x++) {
					if(arr[i][x]==0) {
						arr[i][x]=7;
					}
					else if(arr[i][x]==6) {
						break;
					}
				}
				for(int x=j-1; x>=0; x--) {
					if(arr[i][x]==0) {
						arr[i][x]=7;
					}
					else if(arr[i][x]==6) {
						break;
					}
				}
			}
		} else if (num == 3) {
			three(i,j);
			
		} else if (num == 4) {
			four(i,j);
			
		} else if (num == 5) {
			for(int k=0; k<4; k++) {
				int ni = i;
				int nj = j;
				for(int x=0; x<N; x++) {
					ni += di[k];
					nj += dj[k];
					if(ni<0 || ni>=N || nj<0 || nj>=M || arr[ni][nj]==6) {
						break;
					}
					else if(arr[ni][nj]==0){
						arr[ni][nj]=7;
					}
				}
			}
		}
	}
	
	public static void three(int i, int j) {
		int temp1 = 0;
		int temp2 = 0;
		int temp3 = 0;
		int temp4 = 0;
		
		for(int x=i-1; x>=0; x--) {
			if(arr[x][j]==0) {
				temp1++;
				temp4++;
			}
			else if(arr[x][j]==6) {
				break;
			}
		}
		for(int x=j+1; x<M; x++) {
			if(arr[i][x]==0) {
				temp1++;
				temp2++;
			}
			else if(arr[i][x]==6) {
				break;
			}
		}
		for(int x=i+1; x<N; x++) {
			if(arr[x][j]==0) {
				temp2++;
				temp3++;
			}
			else if(arr[x][j]==6) {
				break;
			}
		}
		for(int x=j-1; x>=0; x--) {
			if(arr[i][x]==0) {
				temp3++;
				temp4++;
			}
			else if(arr[i][x]==6) {
				break;
			}
		}
		int max = Math.max(temp1, temp2);
		max = Math.max(max, temp3);
		max = Math.max(max, temp4);
		
		if(max == temp1) {
			for(int x=i-1; x>=0; x--) {
				if(arr[x][j]==0) {
					arr[x][j]=7;
				}
				else if(arr[x][j]==6) {
					break;
				}
			}
			for(int x=j+1; x<M; x++) {
				if(arr[i][x]==0) {
					arr[i][x]=7;
				}
				else if(arr[i][x]==6) {
					break;
				}
			}
		}
		else if(max==temp2) {
			for(int x=j+1; x<M; x++) {
				if(arr[i][x]==0) {
					arr[i][x]=7;
				}
				else if(arr[i][x]==6) {
					break;
				}
			}
			for(int x=i+1; x<N; x++) {
				if(arr[x][j]==0) {
					arr[x][j]=7;
				}
				else if(arr[x][j]==6) {
					break;
				}
			}
		}
		else if(max==temp3) {
			for(int x=i+1; x<N; x++) {
				if(arr[x][j]==0) {
					arr[x][j]=7;
				}
				else if(arr[x][j]==6) {
					break;
				}
			}
			for(int x=j-1; x>=0; x--) {
				if(arr[i][x]==0) {
					arr[i][x]=7;
				}
				else if(arr[i][x]==6) {
					break;
				}
			}
		}
		else if(max==temp4) {
			for(int x=i-1; x>=0; x--) {
				if(arr[x][j]==0) {
					arr[x][j]=7;
				}
				else if(arr[x][j]==6) {
					break;
				}
			}
			for(int x=j-1; x>=0; x--) {
				if(arr[i][x]==0) {
					arr[i][x]=7;
				}
				else if(arr[i][x]==6) {
					break;
				}
			}
		}
	}

	
	public static void four(int i, int j) {
		int temp1=0;
		int temp2=0;
		int temp3=0;
		int temp4=0;
		for(int x=i-1; x>=0; x--) {
			if(arr[x][j]==0) {
				temp1++;
				temp2++;
				temp4++;
			}
			else if(arr[x][j]==6) {
				break;
			}
		}
		for(int x=j+1; x<M; x++) {
			if(arr[i][x]==0) {
				temp1++;
				temp2++;
				temp3++;
			}
			else if(arr[i][x]==6) {
				break;
			}
		}
		for(int x=i+1; x<N; x++) {
			if(arr[x][j]==0) {
				temp2++;
				temp3++;
				temp4++;
			}
			else if(arr[x][j]==6) {
				break;
			}
		}
		for(int x=j-1; x>=0; x--) {
			if(arr[i][x]==0) {
				temp1++;
				temp3++;
				temp4++;
			}
			else if(arr[i][x]==6) {
				break;
			}
		}
		int max = Math.max(temp1, temp2);
		max = Math.max(max, temp3);
		max = Math.max(max, temp4);
		
		if(max == temp1) {
			for(int x=i-1; x>=0; x--) {
				if(arr[x][j]==0) {
					arr[x][j]=7;
				}
				else if(arr[x][j]==6) {
					break;
				}
			}
			for(int x=j+1; x<M; x++) {
				if(arr[i][x]==0) {
					arr[i][x]=7;
				}
				else if(arr[i][x]==6) {
					break;
				}
			}
			for(int x=j-1; x>=0; x--) {
				if(arr[i][x]==0) {
					arr[i][x]=7;
				}
				else if(arr[i][x]==6) {
					break;
				}
			}
		}
		else if(max == temp2) {
			for(int x=i-1; x>=0; x--) {
				if(arr[x][j]==0) {
					arr[x][j]=7;
				}
				else if(arr[x][j]==6) {
					break;
				}
			}
			for(int x=j+1; x<M; x++) {
				if(arr[i][x]==0) {
					arr[i][x]=7;
				}
				else if(arr[i][x]==6) {
					break;
				}
			}
			for(int x=i+1; x<N; x++) {
				if(arr[x][j]==0) {
					arr[x][j]=7;
				}
				else if(arr[x][j]==6) {
					break;
				}
			}
		}
		else if(max == temp3) {
			for(int x=j+1; x<M; x++) {
				if(arr[i][x]==0) {
					arr[i][x]=7;
				}
				else if(arr[i][x]==6) {
					break;
				}
			}
			for(int x=i+1; x<N; x++) {
				if(arr[x][j]==0) {
					arr[x][j]=7;
				}
				else if(arr[x][j]==6) {
					break;
				}
			}
			for(int x=j-1; x>=0; x--) {
				if(arr[i][x]==0) {
					arr[i][x]=7;
				}
				else if(arr[i][x]==6) {
					break;
				}
			}
		}
		else if(max == temp4) {
			for(int x=i+1; x<N; x++) {
				if(arr[x][j]==0) {
					arr[x][j]=7;
				}
				else if(arr[x][j]==6) {
					break;
				}
			}
			for(int x=j-1; x>=0; x--) {
				if(arr[i][x]==0) {
					arr[i][x]=7;
				}
				else if(arr[i][x]==6) {
					break;
				}
			}
			for(int x=i-1; x>=0; x--) {
				if(arr[x][j]==0) {
					arr[x][j]=7;
				}
				else if(arr[x][j]==6) {
					break;
				}
			}
		}
	}
	
	public static void permComb(int start, int count) {
		if(count == c.size()) {
			arr = new int[N][M];
			for(int k=0; k<temp.length; k++) {
				arr[k] = temp[k].clone();
			}
			for(int i=0; i<cctv.length; i++) {
				oversee(cctv[i][0], cctv[i][1], cctv[i][2]);
			}
			int res=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j]==0) {
						res++;
					}
				}
			}
			min = Math.min(res, min);
			return;
		}
		for(int i=0; i<c.size(); i++) {
			if(!v[i]) { 
				v[i] = true; 
				cctv[count] = c.get(i);
				permComb(i,count+1);
				v[i] = false; 
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		temp = new int[N][M];
		c = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				temp[i][j] = Integer.parseInt(st.nextToken());
				if (temp[i][j] != 6 && temp[i][j] != 0) {
					c.add(new int[] { i, j, temp[i][j] });
				}
			}
		}
		cctv = new int[c.size()][3];
		v = new boolean[c.size()];
		if(c.size()==0) {
			min=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(temp[i][j]==0) {
						min++;
					}
				}
			}
		}
		else {
			permComb(0,0);
		}
		System.out.println(min);

	}

}
