package imtest_0827;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[] {1, 2,3});
		list.add(new int[] {4, 5,6});
		list.get(0)[2] = 9;
		
		
		System.out.println(list.get(0)[2]);
		
	}

}
