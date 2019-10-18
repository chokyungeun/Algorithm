package stack2;

public class Test {
	public static int[][] maze = {
			{0,0,1,1,1,1,1,1},	
			{1,0,0,0,0,0,0,1},	
			{1,1,1,0,1,1,1,1},	
			{1,1,1,0,1,1,1,1},	
			{1,0,0,0,0,0,0,1},	
			{1,0,1,1,1,1,1,1},	
			{1,0,0,0,0,0,0,0},	
			{1,1,1,1,1,1,1,0}	
	};//19
	
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static boolean[][] v;
	public static int N=8;
	
	private static void dfsr(int i, int j) {

		v[i][j] = true;
		/*for(int x=0; x<N; x++) {
			for(int y=0; y<N; y++) {
				System.out.print(v[x][y] + " ");
			}
			System.out.println();
		}
		System.out.println();*/
		
		
		for(int d = 0; d < di.length; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj] && maze[ni][nj] == 0) {
				System.out.println(i + " " + j);
				dfsr(ni, nj);
			}
		}
	}
	public static void main(String[] args) {
		v = new boolean[N][N];
		dfsr(0,0);

	}

}
