package solution;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1224_계산기3_서울9반_조경은 {
	public static Stack<Character> stack;
	public static Stack<Integer> stack2;
	
	public static int getIcp(char c) {
		switch(c) {
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			case '(':
				return 3;
			default:
				return 0;
		}
	}
	public static int getIsp() {
		char c = stack.empty()? ' ':stack.peek();
		switch(c) {
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			case '(':
				return 0;
			default:
				return 0;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1224.txt"));
		Scanner sc = new Scanner(System.in);
		for(int T=1; T<11; T++) {
			 stack = new Stack<>();
			 stack2 = new Stack<>();
			int num = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			String str = sc.next();
			for(int i=0; i<num; i++) {
				char c = str.charAt(i);
				//if(Character.isDigit(c)) { //c가 숫자인지
				if('0'<=c && c<='9') { //위와 같은 문장
					sb.append(c);
				}
				else if(c == ' ') {
					
				}
				else if(c == ')') {
					
					char s = '\u0000'; //유니코드의 null문자(='')
					while((s=stack.pop()) != '(') {
						sb.append(s);
					}
				}
				else {//+,-,*,/
					while(getIcp(c)<=getIsp()) {
						sb.append(stack.pop());
					}
					stack.push(c);
				}
			}
			while(!stack.empty()) {
				sb.append(stack.pop());
			}
			//
			String str2 = sb.toString();
			
			
			for(int i=0; i<str2.length(); i++) {
				
				char c = str2.charAt(i);
				if('0'<=c && c<='9') { //위와 같은 문장
					stack2.push(c-'0');
				}
				else {
					int n2 = stack2.pop();
					int n1 = stack2.pop();
					int nn = 0;
					switch(c) {
					case '+':
						nn = n1 + n2;
						break;
					case '-':
						nn = n1 - n2;
						break;
					case '*':
						nn = n1 * n2;
						break;
					case '/':
						nn = n1 / n2;
						break;
						
					}
					stack2.push(nn);
				}
			}
			System.out.println("#" + T + " " + stack2.pop());
		}
	}

}
