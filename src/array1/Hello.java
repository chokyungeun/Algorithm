package array1;

import java.util.Arrays;

public class Hello {
	
	public static void main(String[] args) {
		
		/*String s1 = "홍길동";
		String s2 = "홍길동";
		StringBuilder sb1 = new StringBuilder(s1);
		StringBuilder sb2 = new StringBuilder(s1);
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		System.out.println(sb1==sb2); //new를 해서 다르다??
		System.out.println(sb1.equals(sb2)); //StringBuilder는 내부적으로 Buffer사용.이렇게 하면 안됨
		System.out.println(sb1.toString().equals(sb2.toString())); //이렇게 해야함.
*/		
		
		
		/*String s = "ABCDEFGHIJ";
		String t = "";
		for(int i=s.length()-1; i>=0; i--) {
			t = t+s.charAt(i);
			System.out.println(t);
		}
		System.out.println();
		StringBuilder sb = new StringBuilder(s);
		sb.append("ABC").replace(0, 3, "XYZ");
		System.out.println(sb.reverse());
		String st = sb.toString(); //s를 직접적으로 조작하지 않고 StringBuilder로 조작한 후 마지막에 넣어줌
*/		
		
		/*String s = "ABCDEFGHIJ";
		String t = "";
		for(int i=s.length()-1; i>=0; i--) {
			System.out.print(s.charAt(i));
		}
		System.out.println();
		StringBuilder sb = new StringBuilder(s);
		System.out.println(sb.reverse());*/
		
		
		/*String s = "ABCDEFGHIJ";
		System.out.println(s.length());
		int[] i = {1,2,3};
		System.out.println(i.length);
		//i.length=7; ->불가능
		//()가 있으면 메소드, 없으면 변수'
		*/
		
		String s = "ABCDEFGHIJ";
		System.out.println(s.substring(3));
		System.out.println(s.substring(0, 3));
		System.out.println(s.substring(3, 6));
		
		/*String s = "He llo ll";
		System.out.println(s.contains("llo"));*/
		
		
		/*String s = "He llo";
		String[] sa = s.split(" ");
		System.out.println(Arrays.toString(sa));
		*/
		
		/*String s = "Hello";
		s = s.replace('H', 'h');
		//s.replace('H', 'h'); -> 이렇게 하면 안됨
		s = s.replace("ll", "LL");
		
		System.out.println(s.replace('H', 'h'));*/
		
	
	}
}
