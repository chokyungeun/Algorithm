package line0405;
import java.io.*;
import java.util.*;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String answer_sheet = "4132315142";
		String[] sheets = {"3241523133","4121314445","3243523133","4433325251","2412313253"};
		
		long res = 0;
		
		
		for(int i=0; i<sheets.length-1; i++) {
			for(int j=i+1; j<sheets.length; j++) {
				int len = 1;
				int max_len = 0;
				int num=0;
				boolean flag = false;
				for(int k=0; k<sheets[i].length(); k++) {
					if(sheets[i].charAt(k)==sheets[j].charAt(k)&&sheets[i].charAt(k)!=answer_sheet.charAt(k)) {
						num++;
						if(flag) len++;
						flag = true;
					}
					else {
						flag = false;
						max_len = Math.max(max_len, len);
						len = 1;
					}
				}
				res = Math.max(res, num+(max_len*max_len));
				
			}
		}
		
		if(res == 1) res = 0;
		System.out.println(res);
	}

}
