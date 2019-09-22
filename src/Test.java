import java.util.Arrays;

public class Test {
<<<<<<< HEAD
	public static int n,r,cnt,a[],v[],d[]={1,2,3,4,5};
	public static void permComb(int start, int count) {
		if(count == r) {
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		for(int i=start; i<n; i++) {
			if(v[i]==0) {
				v[i]=1;
				a[count]=d[i];
				permComb(i,count+1);
				v[i]=0;
			}
		}
	}
	public static void main(String[] args) {
		n = 5;//sc.nextInt();
		r = 3;//sc.nextInt();
		v = new int[n]; //사용 여부 체크
		a = new int[r];
		permComb(0,0);
		System.out.println(cnt);
=======

	public static void main(String[] args) {
		int N = 6;
		int[] Y = new int[N+1];
		Y[0] = 1;
		Y[1] = 2;
		for(int i=2; i<=N; i++) {
			Y[i] = 2*Y[i-1] + Y[i-2];
		}
		System.out.println(Y[N]);
		System.out.println("Y" + Arrays.toString(Y));

>>>>>>> branch 'master' of https://lab.ssafy.com/chokyungeun/algo.git
	}

}
