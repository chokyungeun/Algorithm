package a1106;
import java.io.*;
import java.util.*;

public class Solution_D9_5644_무선충전_서울9반_조경은 {
	public static int M,BC,ares,bres;
	public static ArrayList<Integer>[][] map;
	public static int[] di= {0,-1,0,1,0}; //가만, 상, 우, 하, 좌
	public static int[] dj= {0,0,1,0,-1};
	public static int[] A,B;
	public static ArrayList<int[]> BCinfo;
	public static boolean[][] v;
	
	public static void range(int j, int i, int C, int num) {
		Queue<int[]> q = new LinkedList<>();
		map[i][j].add(num);
        v[i][j] = true;
        q.offer(new int[] {i,j});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int d = 0; d < di.length; d++) {
                int ni = curr[0]+di[d];
                int nj = curr[1]+dj[d];
                if(0<=ni && ni<10 && 0<=nj && nj<10 && !v[ni][nj] && Math.abs(i-ni)+Math.abs(j-nj)<=C) {
                    v[ni][nj] = true;
                    map[ni][nj].add(num);
                    q.offer(new int[] {ni,nj});
                }
            }
        }
	}
	
	
	
	
	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input_d9_5644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			BC = Integer.parseInt(st.nextToken());
			map = new ArrayList[10][10];
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					map[i][j] = new ArrayList<>();
				}
			}
			
			A = new int[M];
			B = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			BCinfo = new ArrayList<>();
			for(int i=0; i<BC; i++) {
				st = new StringTokenizer(br.readLine());
				BCinfo.add(new int[] {Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
				
			}
			
			Collections.sort(BCinfo, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[3]-o2[3];
				}
			});
			for(int i=0; i<BC; i++) {
				v = new boolean[10][10];
				range(BCinfo.get(i)[0],BCinfo.get(i)[1],BCinfo.get(i)[2],i);
			}
			
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					System.out.print(map[i][j] + "    ");
				}
				System.out.println();
			}
			System.out.println();
			ares=0;
			bres=0;
			int ai=0;
			int aj=0;
			int bi=9;
			int bj=9;
			
			for(int i=0; i<=M; i++) {
				int num=0;
				for(int k=0; k<map[bi][bj].size(); k++) {
					if(map[ai][aj].contains(map[bi][bj].get(k))) {
						num++;
						
						if(map[ai][aj].size()==1 && map[bi][bj].size()==1) {
							ares += BCinfo.get(map[ai][aj].get(0))[3]/2;
							bres += BCinfo.get(map[bi][bj].get(0))[3]/2;
						}
						else if(map[ai][aj].size()==1) {
							ares+=BCinfo.get(map[ai][aj].get(0))[3];
							if(map[bi][bj].size()-1 == map[ai][aj].get(0)) {
								bres+=BCinfo.get(map[bi][bj].get(map[bi][bj].size()-2))[3];
							}
							else {
								bres+=BCinfo.get(map[bi][bj].get(map[bi][bj].size()-1))[3];
							}
							
						}
						else if(map[bi][bj].size()==1) {
							bres+=BCinfo.get(map[bi][bj].get(0))[3];
							if(map[ai][aj].get(map[ai][aj].size()-1) == map[bi][bj].get(0)) {
								ares+=BCinfo.get(map[ai][aj].get(map[ai][aj].size()-2))[3];
							}
							else {
								ares+=BCinfo.get(map[ai][aj].get(map[ai][aj].size()-1))[3];
							}
						}
						else {
							if(map[ai][aj].get(map[ai][aj].size()-1)==map[bi][bj].get(map[bi][bj].size()-1)) {
								if(map[ai][aj].get(map[ai][aj].size()-2)>map[bi][bj].get(map[bi][bj].size()-2)) {
									ares+=BCinfo.get(map[ai][aj].get(map[ai][aj].size()-2))[3];
									bres+=BCinfo.get(map[bi][bj].get(map[bi][bj].size()-1))[3];
								}
								else {
									ares+=BCinfo.get(map[ai][aj].get(map[ai][aj].size()-1))[3];
									bres+=BCinfo.get(map[bi][bj].get(map[bi][bj].size()-2))[3];
								}
							}
							else {
								ares+=BCinfo.get(map[ai][aj].get(map[ai][aj].size()-1))[3];
								bres+=BCinfo.get(map[bi][bj].get(map[bi][bj].size()-1))[3];
							}
						}
						
						break;	
						
					}
					
					
				}
				if(num==0) {
					if(map[ai][aj].size()!=0) {
						ares+=BCinfo.get(map[ai][aj].get(map[ai][aj].size()-1))[3];
					}
					if(map[bi][bj].size()!=0) {
						bres+=BCinfo.get(map[bi][bj].get(map[bi][bj].size()-1))[3];
					}
				}
				System.out.println(i + "     " + ares + " " + bres);
				if(i==M) {
					break;
				}
				ai += di[A[i]];
				aj += dj[A[i]];
				bi += di[B[i]];
				bj += dj[B[i]];
				
			}
			
			
			System.out.println("#" + t +  " " + (ares+bres));
		}
		
	}
}