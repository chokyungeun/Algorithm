package stack2;

import java.util.Stack;

public class In2Postfix {
	public static String msg = "(6+5*(2-8)/2)"; //6528-*2/+
	//public static String msg = "2  +3 * 4 / 5"; //6528-*2/+
	public static Stack<Character> stack = new Stack<Character>();
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<msg.length(); i++) {
			char c = msg.charAt(i);
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
		} //*************************************
		System.out.println(sb.toString());
	}
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
}
