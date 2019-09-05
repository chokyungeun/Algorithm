package algoad;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17136_색종이붙이기_조경은 {
	    public static int[] paper = {0, 5, 5, 5, 5, 5};
	    public static int[][] arr = new int[10][10];
	    public static boolean[][] v = new boolean[10][10];
	    public static int res = Integer.MAX_VALUE, num = 0;
	 
	    public static void func(int r, int cnt, int total) {
	        if (res <= cnt) return;      //현재 값보다 색종이를 많이쓰면 가지치기
	        if (total == num) {      //1을 다 채운 경우
	            res = Math.min(res, cnt);
	            return;
	        }
	        for (int i = r; i < 10; i++) {     //r부터 시작
	            for (int j = 0; j < 10; j++) {
	                if (arr[i][j] == 1) {
	                    boolean flag = false;  //큰 색종이로 덮을 수 있으면 이후 색종이는 확인해 보지 않아도 된다
	                    for (int k = 5; k >= 1; k--) {
	                        if ((i + k) <= 10 && (j + k) <= 10 && paper[k] > 0) {
	                            if (!flag) {
	                                flag = check(i, j, k); //k*k 색종이를 덮을 수 있으면 check = true
	                            }
	                            if (flag) {
	                                setVisited(i, j, k);
	                                paper[k]--;
	                                func(i, cnt + 1, total + k * k);
	                                paper[k]++;
	                                setVisited(i, j, k);
	                            }
	                        }
	                    }
	                    if (!flag) return;          //색종이를 못덮는 경우
	                }
	                if (arr[i][j] == 1) return;     //덮고나서도 해당좌표를 못지우는경우
	            }
	        }
	    }
	 
	    //length만큼의 색종이를 사용할 수 있는지 확인
	    public static boolean check(int r, int c, int length) {
	        for (int i = r; i < r + length; i++) {
	            for (int j = c; j < c + length; j++) {
	                if (arr[i][j] == 0) return false;
	            }
	        }
	        return true;
	    }
	 
	    public static void setVisited(int r, int c, int size) {
	        for (int i = r; i < r + size; i++) {
	            for (int j = c; j < c + size; j++) {
	            	if(arr[i][j] == 1) {
	            		arr[i][j] = 0;
	            	}
	            	else {
	            		arr[i][j] = 1;
	            	}
	            }
	        }
	    }
	    
	    
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        for (int i = 0; i < 10; i++) {
	            st = new StringTokenizer(br.readLine());
	            for (int j = 0; j < 10; j++) {
	                arr[i][j] = Integer.parseInt(st.nextToken());
	                num += arr[i][j];       //1의 개수 세기
	            }
	        }
	        //r = 해당 row, cnt = 사용한 색종이수, total = 제거한 1의 개수
	        func(0, 0, 0);
	        if(res == Integer.MAX_VALUE)
	        	res = -1;
	        System.out.println(res);
	    }
	 
	   
	}
