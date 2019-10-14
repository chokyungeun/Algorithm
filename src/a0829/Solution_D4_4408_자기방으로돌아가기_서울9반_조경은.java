package a0829;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class Solution_D4_4408_자기방으로돌아가기_서울9반_조경은 {
    
    public static void main(String[] args) throws Exception{
    	System.setIn(new FileInputStream("res/input_d4_4408.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            int res = 0;
            ArrayList<int[]> list = new ArrayList<>();
            for(int i=0; i<N; i++) {
            	StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                if(start%2 == 0) 
                	start--;
                if(end%2 == 0) 
                	end--;
                list.add(new int[] {start,end});
            }
            for(int i=0; i<list.size(); i++) {
            	if(list.get(i)[0] > list.get(i)[1]) {
            		int te = list.get(i)[0];
            		list.get(i)[0] = list.get(i)[1];
            		list.get(i)[1] = te;
            	}
            }
            Collections.sort(list, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}
			});
             
            while(!list.isEmpty()) {
            	res++;
                int[] temp = list.get(0);
                list.remove(temp);
                for(int i=0; i<list.size(); i++) {
                    int[] temp2 = list.get(i);
                    if(temp2[0] > temp[1]) {
                    	if(temp[1] < temp2[1])
                        	temp = temp2;
                        list.remove(temp2);
                        i--;
                    }
                }
            }
            System.out.println("#"+t+" "+ res);
        }
    }
}