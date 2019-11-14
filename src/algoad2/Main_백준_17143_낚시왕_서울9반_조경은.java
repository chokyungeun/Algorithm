package algoad2;
import java.io.*;
import java.util.*;

public class Main_백준_17143_낚시왕_서울9반_조경은 {
	public static int R,C,M,res;
	public static ArrayList<int[]>[][] shark;
	public static ArrayList<int[]> slist;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,1,-1};
	
	//상어중복제거
	public static void eatShark() {
		for(int i=0; i<slist.size();) {
			if(shark[slist.get(i)[0]][slist.get(i)[1]].size()==0) {
				shark[slist.get(i)[0]][slist.get(i)[1]].add(slist.get(i));
				 i++;
			}
			else {
				if(shark[slist.get(i)[0]][slist.get(i)[1]].get(0)[4]>slist.get(i)[4]) {
					slist.remove(i);
				}
				else {
					shark[slist.get(i)[0]][slist.get(i)[1]].remove(0);
					shark[slist.get(i)[0]][slist.get(i)[1]].add(slist.get(i)); //index
					for(int k=0; k<slist.size(); k++) {
						if(slist.get(k)[0]==slist.get(i)[0] && slist.get(k)[1]==slist.get(i)[1]) {
							slist.remove(k);
							break;
						}
					}
					
				}
			}
		}
	}
	
	//상어이동
	public static void moveShark() {
		for(int i=0; i<slist.size(); i++) {
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
		
		//낚시시작
		for(int i=0; i<C; i++) {
			for(int j=0; j<R; j++) {
				if(shark[j][i].size()!=0) {
					res+=shark[j][i].get(0)[4];
					shark[j][i].remove(0);
					for(int k=0; k<slist.size(); k++) {
						if(slist.get(k)[0]==j && slist.get(k)[1]==i) {
							slist.remove(k);
							break;
						}
					}
					break;
				}
			}
			moveShark();
			eatShark();
			/*for(int k=0; k<slist.size(); k++) {
				System.out.println((slist.get(k)[0]+1) + " " + (slist.get(k)[1]+1));
			}
			System.out.println();*/
		}
		System.out.println(res);
	}
}
