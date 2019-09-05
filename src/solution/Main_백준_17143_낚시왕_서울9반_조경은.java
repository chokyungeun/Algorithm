package solution;

import java.util.*;
import java.io.*;

public class Main_백준_17143_낚시왕_서울9반_조경은 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,1,-1};
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[R][C];
		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())});
		}
		for(int i=0; i<list.size(); i++) {
			arr[list.get(i)[0]][list.get(i)[1]] = list.get(i)[4];
		}
		
		int res = 0;
		for(int t=0; t<C; t++) {
			
			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1] == o2[1])
						return o1[0]-o2[0];
					return o1[1]-o2[1];
				}
			});
			
			for(int i=0; i<list.size()-1;) {
				
				if(list.get(i)[1] == list.get(i+1)[1] && list.get(i)[0] == list.get(i+1)[0]) {
					if(list.get(i)[4] > list.get(i+1)[4]) {
						list.remove(i+1);
					}
					else {
						list.remove(i);
						if(i-1 >=0)
							i--;
					}
				}
				else {
					i++;
				}
			}

			//낚시왕 낚시 시작!
			for(int i=0; i<list.size(); i++) {
				if(list.get(i)[1] == t) {
					res += list.get(i)[4];
					list.remove(i);
					break;
				}
			}
			
			//상어이동
			
			for(int i=0; i<list.size(); i++) {
				int ni = list.get(i)[0];
				int nj = list.get(i)[1];
				for(int j=0; j<list.get(i)[2]; j++) {
					ni += di[list.get(i)[3]];
					nj += dj[list.get(i)[3]];
					if(list.get(i)[3] == 0 || list.get(i)[3] == 1) {
						if(ni == 0) {
							list.get(i)[3] = 1;
						}
						else if(ni == R-1) {
							list.get(i)[3] = 0;
						}
					}
					else {
						if(nj == 0) {
							list.get(i)[3] = 2;
						}
						else if(nj == C-1) {
							list.get(i)[3] = 3;
						}
					}
					
				}
				list.get(i)[0] = ni;
				list.get(i)[1] = nj;
			}
			
		}
		System.out.println(res);

	}

}
