package midasIT0523;
import java.io.*;
import java.util.*;

public class Main2 {

	public static void main(String[] args) throws Exception {
		int x = -1;
		int y = 2;
		int r = 5;
		int d = 60;
		int[][] target = {{0,1},{-1,1},{1,0},{-2,2}};
		int answer=0;
		double ang = Math.atan2(y, x) * (180 / Math.PI);
		double small = ang-d;
		double big = ang+d;
		
		
		for(int i=0; i<target.length; i++) {
			if(Math.atan2(target[i][1], target[i][0])*(180/Math.PI) >= small && Math.atan2(target[i][1], target[i][0])*(180/Math.PI)<=big && Math.sqrt(target[i][0]*target[i][0] + target[i][1]*target[i][1]) < r) {
				answer++;
			}
		}
		System.out.println(answer);
		
	}

}
