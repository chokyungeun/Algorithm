package solution;

import java.util.*;
import java.io.*;

public class Main_백준_14888_연산자끼워넣기_서울9반_조경은 {
	public static int tot, res, min, max;
	public static int[] num;
	public static char[] b;
	public static boolean[] v;
	public static ArrayList<Character> a; 
	
	public static void permcomb(int start, int count) {
		if(count == tot) {
			cal();
			return;
		}
		for(int i=0; i<tot; i++) {
			if(!v[i]) {
				v[i] = true;
				b[count] = a.get(i);
				permcomb(i, count+1);
				v[i]=false;
			}
		}
	}
	
	public static void cal() {
		int n = -1;
		res = num[0];
		for(int i=1; i<tot+1; i++) {
			n++;
			if(b[n] == '+') {
				res += num[i];
			}
			else if(b[n] == '-') {
				res -= num[i];
			}
			else if(b[n] == '*') {
				res *= num[i];
			}
			else if(b[n] == '/') {
				if(res < 0) {
					res = ((res*(-1))/num[i])*-1;
				}
				else {
					res /= num[i];
				}
			}
		}
		
		if(res > max) {
			max = res;
		}
		if(res < min) {
			min = res;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		num = new int[N];
		v = new boolean[N];
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		int plus = sc.nextInt();
		int minus = sc.nextInt();
		int mul = sc.nextInt();
		int div = sc.nextInt();
		tot = N-1;
		a = new ArrayList<>();
		for(int i=0; i<plus; i++) {
			a.add('+');
		}
		for(int i=0; i<minus; i++) {
			a.add('-');
		}
		for(int i=0; i<mul; i++) {
			a.add('*');
		}
		for(int i=0; i<div; i++) {
			a.add('/');
		}
		b = new char[tot];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		permcomb(0, 0);
		System.out.println(max);
		System.out.println(min);
	}

}
