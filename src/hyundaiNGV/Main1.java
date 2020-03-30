package hyundaiNGV;
import java.io.*;

public class Main1 {
	public static int N,K;
	public static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		K = Integer.parseInt(sarr[1]);
		arr = new int[N];
		
		String s = br.readLine();
		for(int i=0; i<N; i++) {
			arr[i] = (s.charAt(i)-'0');
		}
		int first = arr[0];
		int num = 0;
		for(int i=1; i<=N-K; i++) {
			if(arr[i]>first) {
				first = arr[i];
				num = i;
			}
			else if(arr[i]==first) {
				for(int j=i+1; j<i+K; j++) {
					if(arr[num+j-i]<arr[j]) {
						num = i;
						break;
					}
					else if(arr[num+j-i]>arr[j]) {
						break;
					}
				}
			}
		}
		long res = 0;
		for(int i=0; i<K; i++) {
			long x = 1;
			for(int j=0; j<K-i-1; j++) {
				x*=10;
			}
			res += arr[num+i]*x;
		}
		
		System.out.println(res);
	}

}
