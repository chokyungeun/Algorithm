import java.util.Arrays;

public class Test {
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
	}

}
