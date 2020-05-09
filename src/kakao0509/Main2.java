package kakao0509;
import java.io.*;
import java.util.*;

public class Main2 {
	public static String expression = "999+999";
	public static ArrayList<Long> number;
	public static ArrayList<Character> op;
	public static char[] oper = {'+','-','*'};
	public static boolean[] v;
	public static char[] d;
	public static long answer;
	
	public static void calc() {
		ArrayList<Long> tn = new ArrayList<>();
		ArrayList<Character> top = new ArrayList<>();
		for(int i=0; i<number.size(); i++) {
			tn.add(number.get(i));
		}
		for(int i=0; i<op.size(); i++) {
			top.add(op.get(i));
		}
		
		for(int j=0; j<d.length; j++) {
			for(int i=0; i<top.size();) {
				if(top.get(i)==d[j]) {
					if(d[j]=='+') {
						long num = tn.get(i)+tn.get(i+1);
						tn.set(i,num);
						tn.remove(i+1);
						top.remove(i);
					}
					else if(d[j]=='-') {
						long num = tn.get(i)-tn.get(i+1);
						tn.set(i,num);
						tn.remove(i+1);
						top.remove(i);
					}
					else {
						long num = tn.get(i)*tn.get(i+1);
						tn.set(i,num);
						tn.remove(i+1);
						top.remove(i);
					}
				}
				else {
					i++;
				}
			}
		}
		answer = Math.max(answer, Math.abs(tn.get(0)));
	}
	
	public static void permComb(int start, int count) {
		if(count == 3) {
			calc();
			return;
		}
		for(int i=0; i<3; i++) { 
			if(!v[i]) { 
				v[i] = true; 
				d[count] = oper[i];
				permComb(i,count+1);
				v[i] = false; 
			} 
		}
	}
	public static void main(String[] args) throws Exception {
		number = new ArrayList<>();
		op = new ArrayList<>();
		String s = "";
		for(int i=0; i<expression.length(); i++) {
			if(expression.charAt(i)=='-' || expression.charAt(i)=='*' || expression.charAt(i)=='+') {
				number.add(Long.parseLong(s));
				op.add(expression.charAt(i));
				s = "";
			}
			else {
				s += expression.charAt(i);
			}
		}
		number.add(Long.parseLong(s));
		
		v = new boolean[3];
		d = new char[3];
		answer = 0;
		if(number.size()==1) {
			answer = Math.abs(number.get(0));
		}
		else {
			permComb(0,0);
		}
		
		
		System.out.println(answer);
	}

}
