import java.io.*;
import java.util.*;

public class Test {

	public static void main(String[] args) throws Exception {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(1);
		temp.add(2);
		temp.add(3);
		list.add(temp);
		temp = new ArrayList<>();
		temp.add(4);
		temp.add(5);
		temp.add(6);
		list.add(temp);
		
		list.get(0).set(0, 9);
		System.out.println(list.get(0).get(0));
		
	}

}
