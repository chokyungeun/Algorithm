package a0904;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
//permcomb
public class Solution_D4_1494_사랑의카운슬러_서울9반_조경은 {
	public static int n,r,cnt,a[];
	
	public static void combination(int start, int count) {
		if(count == r) {
			for(int i=0; i<r; i++) {
				for(int j=i+1; j<r; j++) {
					if(a[i] == a[j]) return;
				}
			}
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		
		for(int i=start; i<=n; i++) {
			a[count] = i;
			combination(i, count+1);
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1494.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
        	int N = Integer.parseInt(br.readLine());
        	ArrayList<int[]> list = new ArrayList<>();
        	for(int i=0; i<N; i++) {
        		String[] s = br.readLine().split(" ");
        		list.add(new int[] {Integer.parseInt(s[0]), Integer.parseInt(s[1])});
        	}
        	
        }

	}

}
