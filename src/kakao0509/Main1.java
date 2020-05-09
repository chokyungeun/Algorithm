package kakao0509;
import java.io.*;
import java.util.*;

public class Main1 {
	public static int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
	public static String hand = "right";
	public static String[] res;
	public static int[][] phone = {{1,2,3},{4,5,6},{7,8,9},{10,0,11}};
	public static int[] r,l;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		res = new String[numbers.length];
		phone = new int[4][3];
		r = new int[2];
		l = new int[2];
		r[0] = 3;
		r[1] = 2;
		l[0] = 3;
		l[1] = 0;
		for(int i=0; i<numbers.length; i++) {
			switch(numbers[i]) {
			case 1:
				res[i] = "L";
				l[0] = 0; l[1] = 0;
				break;
			case 2:
				int right = Math.abs(r[0])+Math.abs(r[1]-1);
				int left = Math.abs(l[0])+Math.abs(l[1]-1);
				if(right<left) {
					res[i] = "R";
					r[0] = 0; r[1] = 1;
				}
				else if(left<right) {
					res[i] = "L";
					l[0] = 0; l[1] = 1;
				}
				else {
					if(hand.equals("right")) {
						res[i] = "R";
						r[0] = 0; r[1] = 1;
					}
					else {
						res[i] = "L";
						l[0] = 0; l[1] = 1;
					}
				}
				break;
			case 3:
				res[i] = "R";
				r[0] = 0; r[1] = 2;
				break;
			case 4:
				res[i] = "L";
				l[0] = 1; l[1] = 0;
				break;
			case 5:
				right = Math.abs(r[0]-1)+Math.abs(r[1]-1);
				left = Math.abs(l[0]-1)+Math.abs(l[1]-1);
				if(right<left) {
					res[i] = "R";
					r[0] = 1; r[1] = 1;
				}
				else if(left<right) {
					res[i] = "L";
					l[0] = 1; l[1] = 1;
				}
				else {
					if(hand.equals("right")) {
						res[i] = "R";
						r[0] = 1; r[1] = 1;
					}
					else {
						res[i] = "L";
						l[0] = 1; l[1] = 1;
					}
				}
				break;
			case 6:
				res[i] = "R";
				r[0] = 1; r[1] = 2;
				break;
			case 7:
				res[i] = "L";
				l[0] = 2; l[1] = 0;
				break;
			case 8:
				right = Math.abs(r[0]-2)+Math.abs(r[1]-1);
				left = Math.abs(l[0]-2)+Math.abs(l[1]-1);
				if(right<left) {
					res[i] = "R";
					r[0] = 2; r[1] = 1;
				}
				else if(left<right) {
					res[i] = "L";
					l[0] = 2; l[1] = 1;
				}
				else {
					if(hand.equals("right")) {
						res[i] = "R";
						r[0] = 2; r[1] = 1;
					}
					else {
						res[i] = "L";
						l[0] = 2; l[1] = 1;
					}
				}
				break;
			case 9:
				res[i] = "R";
				r[0] = 2; r[1] = 2;
				break;
			case 0:
				right = Math.abs(r[0]-3)+Math.abs(r[1]-1);
				left = Math.abs(l[0]-3)+Math.abs(l[1]-1);
				if(right<left) {
					res[i] = "R";
					r[0] = 3; r[1] = 1;
				}
				else if(left<right) {
					res[i] = "L";
					l[0] = 3; l[1] = 1;
				}
				else {
					if(hand.equals("right")) {
						res[i] = "R";
						r[0] = 3; r[1] = 1;
					}
					else {
						res[i] = "L";
						l[0] = 3; l[1] = 1;
					}
				}
				break;
			}
			
		}
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i]);
		}
	}

}
