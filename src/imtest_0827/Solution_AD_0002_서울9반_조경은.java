package imtest_0827;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_AD_0002_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		//5648
		System.setIn(new FileInputStream("res/input_ad_0002.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<int[]> list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				String[] s = br.readLine().split(" ");
				list.add(new int[] {Integer.parseInt(s[0])*10, Integer.parseInt(s[1])*10, Integer.parseInt(s[2]), Integer.parseInt(s[3])});
			}
			int[] di = {0,0,-1,1};
			int[] dj = {1,-1,0,0};
			
			int sum=0;
			int num = 0;
			
			while(num < 3600) {
				num++;
				if(list.size() == 0 || list.size() == 1)
					break;
				
				//이동
				for(int i=0; i<list.size(); i++) {
					list.get(i)[0] = list.get(i)[0] + 5*di[list.get(i)[2]];
					list.get(i)[1] = list.get(i)[1] + 5*dj[list.get(i)[2]];
				}
				ArrayList<int[]> nlist = new ArrayList<>(); 
				//겹치면 삭제
				for(int i=0; i<list.size(); i++) {
					int number=0;
					for(int j=0; j<list.size(); j++) {
						if(list.get(i)[0] == list.get(j)[0] && list.get(i)[1] == list.get(j)[1]) {
							number++;
							if(number > 1) {
								sum += list.get(j)[3];
								list.get(j)[3] = 0;
							}
						}
					}
					if(number > 1) {
						sum += list.get(i)[3];
						list.get(i)[3] = 0;
					}
					if(number == 1) {
						nlist.add(list.get(i));
					}
					
				}
				list = new ArrayList<>();
				for(int i=0; i<nlist.size(); i++) {
					list.add(nlist.get(i));
				}
			}
			
			sb.append("#" + t + " " + sum + "\n");
		}
		System.out.println(sb);
	}

}
