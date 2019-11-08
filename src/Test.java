import java.io.*;
import java.util.*;

public class Test {
	public static int[][] temp={{1, 1, 1},{0,0,0},{1,2,3},{0,0,0},{0,0,0}};
	public static int W,H;
	public static void arrange() {
		for(int j=0; j<W; j++) {
			int index=0;
			for(int i=H-1; i>=0; i--) {
				if(temp[i][j]==0) {
					index++;
				}
				else if(temp[i][j]!=0 && index!=0){
					temp[i+index][j]=temp[i][j];
					temp[i][j]=0;
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		W = 3;
		H = 5;
		
		arrange();
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println(); 
		}
		System.out.println();
	}

}
