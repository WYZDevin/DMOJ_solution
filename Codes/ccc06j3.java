import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

		char [] a = new char [26];
		Hashtable<Character,String> h = new Hashtable<Character,String>();
		h.put('a',"2");
		h.put('b',"22");
		h.put('c', "222");
		h.put('d',"3");
		h.put('e',"33");
		h.put('f', "333");
		h.put('g',"4");
		h.put('h',"44");
		h.put('i', "444");
		h.put('j',"5");
		h.put('k',"55");
		h.put('l', "555");
		h.put('m',"6");
		h.put('n',"66");
		h.put('o', "666");
		h.put('p',"7");
		h.put('q',"77");
		h.put('r', "777");
		h.put('s',"7777");
		h.put('t',"8");
		h.put('u', "88");
		h.put('v',"888");
		h.put('w',"9");
		h.put('x',"99");
		h.put('y',"999");
		h.put('z', "9999");
		String s = "";
		Scanner sc = new Scanner(System.in);
		while (true) {
			s = sc.next(); 
			if (s.equals("halt")) {
				break;
			}
			int count = 0;
			char pre = ' '; 
			for (int i=0; i<s.length(); i++){
				char c = s.charAt(i); 
				String S = h.get(c); 
				if (S.charAt(0)==pre) { 
					count = count + 2;
				}
				count = count + h.get(s.charAt(i)).length();
				pre = S.charAt(0);
			}
			System.out.println(count);
		}
    }
}