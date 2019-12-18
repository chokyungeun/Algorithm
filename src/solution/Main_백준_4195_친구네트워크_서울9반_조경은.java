package solution;
import java.io.*;
import java.util.*;

public class Main_백준_4195_친구네트워크_서울9반_조경은 {
	public static int F;
	public static int[] num;
	public static HashMap<String,Integer> name;
	public static ArrayList<String[]> list;
	
	public static int getParent(int[] p, int x) {
		if(p[x]==x)
			return x;
		else {
			return p[x] = getParent(p,p[x]);
		}
	}
	
	public static void unionParent(int[] p, int a, int b) {
		a = getParent(p, a);
		b = getParent(p, b);
		if(a==b) {
			System.out.println(num[a]);
		}
		else  {
			p[a] = b;
			num[b]+=num[a];
			System.out.println(num[b]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			F = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			name = new HashMap<>();
			int index=0;
			
			for(int i=0; i<F; i++) {
				String[] s = br.readLine().split(" ");
				list.add(new String[] {s[0],s[1]});
				if(!name.containsKey(s[0])) name.put(s[0],++index);
				if(!name.containsKey(s[1])) name.put(s[1],++index);
			}
			num = new int[name.size()+1];
			Arrays.fill(num, 1);
			int[] p = new int[name.size()+1];
			for(int i=1; i<=name.size(); i++)
				p[i] = i;
			for(int i=0; i<list.size(); i++) {
				unionParent(p, name.get(list.get(i)[0]), name.get(list.get(i)[1]));
			}
		}
	}
}
