package imtest_0827;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_AD_0002_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		//5648
		System.setIn(new FileInputStream("res/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			ArrayList<int[]> list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				list.add(new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()});
			}
			int[] di = {0,0,-1,1};
			int[] dj = {-1,1,0,0};
			int[][] arr = new int[2000][2000];
			for(int i=0; i<N; i++) {
				arr[list.get(i)[0]+1000][list.get(i)[1]+1000] = list.get(i)[3];
			}
			int sum=0;
			while(true) {
				int num=0;
				for(int i=0; i<2000; i++) {
					for(int j=0; j<2000; j++) {
						if(arr[i][j] != 0) {
							num++;
						}
					}
				}
				if(num==0) {
					break;
				}
				for(int i=0; i<list.size(); i++) {
					int ni = list.get(i)[0] + di[list.get(i)[2]];
					int nj = list.get(i)[1] + dj[list.get(i)[2]];
					if(ni>=0 && ni<2000 && nj>=0 && nj<2000) {
						if(arr[ni][nj] == 0) {
							arr[list.get(i)[0]][list.get(i)[1]] = 0;
							list.get(i)[0] = ni;
							list.get(i)[1] = nj;
							arr[ni][nj] = list.get(i)[3];
						}
						else {
							sum += list.get(i)[3];
							list.remove(i);
							//충돌한것도제거!
							for(int j=0; j<list.size(); j++) {
								if(list.get(j)[0] == ni && list.get(j)[1] == nj) {
									sum += list.get(j)[3];
									list.remove(j--);
								}
							}
						}
					}
				}
			}
			System.out.println("#" + t + " " + sum);
		}

	}

}
