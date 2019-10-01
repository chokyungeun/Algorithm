package line0922;

import java.io.*;
import java.util.*;

public class Test1 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[m];
        for(int i=0; i<m; i++) {
        	arr[i] = sc.nextInt();
        }
        int[] cs = new int[c];
       
        for(int i=0; i<m; i++) {
        	int min = cs[0];
        	int mi = 0;
        	for(int j=1; j<cs.length; j++) {
        		if(min > cs[j]){
        			min = cs[j];
        			mi = j;
        		}
        	}
        	cs[mi] += arr[i];
        }
        int res = cs[0];
        for(int i=1; i<cs.length; i++) {
        	if(res < cs[i])
        		res = cs[i];
        }
        System.out.println(res);
        
		

	}

}
