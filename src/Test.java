import java.io.*;
import java.util.*;

public class Test {

	public static void main(String[] args) throws Exception {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.set(0, list.get(0)+1);
		
		System.out.println(list);
		
		
	}

}
