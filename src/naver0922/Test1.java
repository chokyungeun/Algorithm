package naver0922;
import java.io.*;
import java.util.*;
public class Test1 {
	
	public static void main(String[] args) {
		String[] record = {"RECEIVE abcd@naver.com", "RECEIVE zzkn@naver.com", "DELETE", "RECEIVE qwerty@naver.com", "SAVE", "SAVE", "DELETE", "RECEIVE QwerTY@naver.com", "SAVE"};
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> ans = new ArrayList<>();
		
		for(int i=0; i<record.length; i++) {
			String[] s = record[i].split(" ");
			if(s[0].equals("RECEIVE")){
				ans.add(s[1]);
			}
			else if(s[0].equals("DELETE")) {
				if(ans.size()!=0)
					ans.remove(ans.size()-1);
			}
			else if(s[0].equals("SAVE")) {
				for(int j=0; j<ans.size(); j++) {
					list.add(ans.get(j));
				}
				ans = new ArrayList<>();
			}
		}
		String[] answer = new String[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		System.out.println(Arrays.toString(answer));
	}

}
