package imtest_0827;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) ==1) {
				list.remove(i);
			}
		}
		System.out.println(list);

	}

}
