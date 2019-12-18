import java.io.*;
import java.util.*;

public class Test {
	public static int[] p;
	
	public static void main(String[] args) throws Exception {
		HashMap<Integer, String> map = new HashMap<>();
		int index=0;
		map.put(++index,"A");
		map.put(++index,"B");
		map.put(++index,"C");
		map.put(++index,"A");
		map.put(++index,"A");
		map.put(++index,"D");
		Set keyset = map.keySet();
		System.out.println(keyset + " " + keyset.size());
		
		for(int i=0; i<keyset.size(); i++) {
			System.out.println(map.get(keyset));
		}
	}

}
