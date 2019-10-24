package a1024;

import java.io.*;

public class Solution_D1_2056_연월일달력_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int T=1; T<t+1; T++) {
			int num = Integer.parseInt(br.readLine());
			int year = num/10000;
			num = num%10000;
			int month = num/100;
			int date = num%100;
			String res = "0";
			
			if(month<1 || month>12 || date<1 || date>31) {
				res = "-1";
			}
			else {
				switch(month) {
				case 2:
					if(date>28) {
						res = "-1";
					}
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					if(date>30) {
						res = "-1";
					}
				}
			}
			if(res != "-1") {
				System.out.printf("#%d %04d/%02d/%02d\n", T, year, month, date);
			}
			else {
				System.out.println("#" + T + " " + res);
			}
			
		}
	}
}