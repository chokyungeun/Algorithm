package algoad;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3234_준환이의양팔저울_perm_조경은 {
	
	 	private static int T, N; 
	    private static int[] w;
	    private static int cnt;
	      
	    public static void main(String[] args) throws Exception{
	    	System.setIn(new FileInputStream("res/input_d4_3234.txt"));
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder sb = new StringBuilder();
	        T = Integer.parseInt(br.readLine());
	        for (int tc = 1; tc <= T; tc++) {
	            N = Integer.parseInt(br.readLine()); 
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            w = new int[N];
	            for (int i = 0; i < w.length; i++) {
	                w[i] = Integer.parseInt(st.nextToken());
	            }
	            cnt = 0; 
	            perm(0, 0, 0);
	            sb.append("#" + tc + " " + cnt + "\n");
	        }
	        br.close();
	        System.out.println(sb);
	    }
	  
	    private static void perm(int step, int l, int r) {
	        if(step == w.length) {
	        	cnt++;
	        }
	        else {
	        	for(int i=step; i<w.length; i++) {
	        		int temp = w[i];
	        		w[i] = w[step];
	        		w[step] = temp;
	        		perm(step+1, l+w[step], r);
	        		if(r+w[step] <= l) {
	        			perm(step+1, l, r+w[step]);
	        		}
	        		temp = w[i];
	        		w[i] = w[step];
	        		w[step] = temp;
	        	}
	        }
	    }
	}