package algoad;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17136_색종이붙이기_조경은 {
	    public static int[] paper = {0, 5, 5, 5, 5, 5};
	    public static int[][] arr = new int[10][10];
	    public static boolean[][] v = new boolean[10][10];
	    public static int res = 25, num = 0;
	 
	    public static void func(int i, int j, int p) {
	    	if(p == 0) {
	    		int n=0;
	    		for(int row=0; row<10; row++) {
	    			for(int col=0; col<10; col++) {
	    				if(arr[row][col]!=0) {
	    					n++;
	    				}
	    			}
	    		}
	    		if(n!=0) {
	    			for(int x=0; x<paper.length; x++) {
	    				if(paper[x] != 0) {
	    					start();
	    				}
	    			}
	    		}
	    		return;
	    	}
	    	for(int row=i; row<i+p; row++) {
	    		if(row < 10) {
	    			if(arr[row][j] != 1) {
		    			func(i, j, p-1);
		    			return;
		    		}
	    		}
	    		else {
	    			func(i, j, p-1);
	    			return;
	    		}
	    		
	    	}
	    	for(int col=j; col<j+p; col++) {
	    		if(col<10) {
	    			if(arr[i][col] != 1) {
		    			func(i, j, p-1);
		    			return;
		    		}
	    		}
	    		else {
	    			func(i, j, p-1);
	    			return;
	    		}
	    	}
	    	if(paper[p] != 0) {
	    		for(int row=i; row<i+p; row++) {
		    		for(int col=j; col<j+p; col++) {
		    			arr[row][col] = 0;
		    		}
		    	}
		    	paper[p]--;
	    	}
	    	else {
	    		func(i,j,p-1);
	    	}
	    }
	    
	    public static void start() {
	    	 for(int i=0; i<10; i++) {
		        	for(int j=0; j<10; j++) {
		        		if(arr[i][j] == 1) {
		        			func(i, j, 5);
		        		}
		        	}
		        }
	    }
	    
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        for (int i = 0; i < 10; i++) {
	            st = new StringTokenizer(br.readLine());
	            for (int j = 0; j < 10; j++) {
	                arr[i][j] = Integer.parseInt(st.nextToken());
	                num += arr[i][j];       //1의 개수 세기
	            }
	        }
	       start();
	        
	        for(int i=1; i<paper.length; i++) {
	        	res -= paper[i];
	        }
	        
	        Loop : for(int i=0; i<10; i++) {
	        	for(int j=0; j<10; j++) {
	        		if(arr[i][j] == 1) {
	        			res = -1;
	        			break Loop;
	        		}
	        	}
	        }
	       
	        for(int k=0; k<paper.length; k++) {
	        	if(paper[k] != 0) {
	        		 for(int i=0; i<10; i++) {
	     	        	for(int j=0; j<10; j++) {
	     	        		if(arr[i][j] == 1) {
	     	        			func(i, j, 5);
	     	        		}
	     	        	}
	     	        }
	        	}
	        }
	       
	        System.out.println(res);
	    }
	 
	   
	}
