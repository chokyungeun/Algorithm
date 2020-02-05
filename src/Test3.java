import java.io.*;
import java.util.*;

public class Test3 {
	public static int[] p;
	public static class tongtree{
		int x1;
		int y1;
		
		public tongtree(int x1, int y1) {
			this.x1 = x1;
			this.y1 = y1;
		
		}

	}
	
	public static class shark{
		int x1;
		int y1;
		
		public shark(int x1, int y1) {
			this.x1 = x1;
			this.y1 = y1;
		
		}

	}

	public static void main(String[] args) throws Exception {
		tongtree a = new tongtree(1,2);
		tongtree b = new tongtree(12,23);
		
		System.out.println(a.getClass().isInstance(b));
	}

}
