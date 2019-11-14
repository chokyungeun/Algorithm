package algoad2;
import java.io.*;
import java.util.*;

public class Main_백준_17143_낚시왕_서울9반_조경은 {
	public static int R,C,M,res;
	public static ArrayList<int[]>[][] shark;
	public static ArrayList<int[]> slist;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,1,-1};
	
	public static void eatShark() {
		for(int i=0; i<slist.size(); i++) {
			
			if(shark[slist.get(i)[0]][slist.get(i)[1]]==null) {
				shark[slist.get(i)[0]][slist.get(i)[1]].add(slist.get(i));
			}
			else {
				if(shark[slist.get(i)[0]][slist.get(i)[1]].get(0)[4]>slist.get(i)[4]) {
					slist.remove(i);
					i--;
				}
				else {
					shark[slist.get(i)[0]][slist.get(i)[1]].remove(0);
					shark[slist.get(i)[0]][slist.get(i)[1]].add(slist.get(i));
				}
			}
		}
	}
	
	public static void moveShark() {
		for(int i=0; i<slist.size(); i++) {
			//System.out.println(slist.get(i)[0] + " " + slist.get(i)[1]);
			int ni = slist.get(i)[0];
			int nj = slist.get(i)[1];
			for(int j=0; j<slist.get(i)[2]; j++) {
				if(slist.get(i)[3]==0 || slist.get(i)[3]==1) {
					if(ni==0) slist.get(i)[3]=1;
					if(ni==R-1) slist.get(i)[3]=0;
				}
				else {
					if(nj==0) slist.get(i)[3]=2;
					if(nj==C-1) slist.get(i)[3]=3;
				}
				ni += di[slist.get(i)[3]];
				nj += dj[slist.get(i)[3]];
			}
			shark[slist.get(i)[0]][slist.get(i)[1]].remove(0);
			slist.get(i)[0]=ni;
			slist.get(i)[1]=nj;
			//System.out.println(slist.get(i)[0] + " " + slist.get(i)[1]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		shark = new ArrayList[R][C];
		slist = new ArrayList<>();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				shark[i][j] = new ArrayList<>();
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			slist.add(new int[] {r,c,s,d,z});
			shark[r][c].add(new int[] {r,c,s,d,z});
		}
		
		for(int i=0; i<C; i++) {
			for(int j=0; j<R; j++) {
				if(shark[j][i].size()!=0) {
					res+=shark[j][i].get(0)[2];
					for(int k=0; k<slist.size(); k++) {
						if(slist.get(k)[0]==j && slist.get(k)[1]==i) {
							slist.remove(k);
							break;
						}
					}
					//slist.remove((Object)shark[j][i].get(0)); //어떻게지워...?
					shark[j][i]=null;
					break;
				}
			}
			
			moveShark();
			eatShark();
		}
		System.out.println(res);
	}

}
