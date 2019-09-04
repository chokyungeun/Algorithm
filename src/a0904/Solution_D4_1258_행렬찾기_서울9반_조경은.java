package a0904;

import java.io.*;
import java.util.*;

public class Solution_D4_1258_행렬찾기_서울9반_조경은 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1258.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
        	int n = Integer.parseInt(br.readLine());
        	int[][] arr = new int[n][n];
        	for(int i=0; i<n; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0; j<n; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	ArrayList<int[]> list = new ArrayList<>();
        	for(int i=0; i<n; i++) {
        		for(int j=0; j<n; j++) {
        			int row=0;
                	int col=0;
        			if(arr[i][j] != 0) {
        				for(int k=i; k<n; k++) {
        					if(arr[k][j] != 0) {
        						row++;
        					}
        					else {
        						break;
        					}
        				}
        				for(int k=j; k<n; k++) {
        					if(arr[i][k] != 0) {
        						col++;
        					}
        					else {
        						break;
        					}
        				}
        				list.add(new int[] {row, col, row*col});
        				for(int r=i; r<i+row; r++) {
        					for(int c=j; c<j+col; c++) {
        						arr[r][c] = 0;
        					}
        				}
        			}
        		}
        	}
        	
        	Collections.sort(list, new Comparator<int[]>() {
    			@Override
    			public int compare(int[] o1, int[] o2) {
    				if(o1[2] == o2[2])
    					return o1[0]-o2[0];
    				return o1[2]-o2[2];
    			}
    		});
        	
        	
        	System.out.print("#" + t + " " + list.size() + " ");
        	for(int i=0; i<list.size(); i++) {
        		System.out.print(list.get(i)[0] + " " + list.get(i)[1] + " ");
        	}
        	System.out.println();
        }

	}

}
