import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_백준_1157_단어공부_서울8반_윤규희 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		TreeMap<Character, Integer> map = new TreeMap<>();
		String word = br.readLine().toUpperCase();
		
		for(int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			//for(int m=0;m<map.size();m++) {
				if(map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
			//}
		}
		
		Iterator it = map.keySet().iterator();
		int max = 0;
		char max_char = 'a';
		while(it.hasNext()) {
			char c = (char) it.next();
			if(max < map.get(c)) {
				max = map.get(c);
				max_char = c;
			}
		}
		
		Iterator it2 = map.keySet().iterator();
		int count = 0;
		while(it2.hasNext()) {
			char c = (char) it2.next();
			if(max == map.get(c)) {
				count++;
			}
		}
		
		if(count > 1)
			System.out.println("?");
		else if(count == 1)
			System.out.println(max_char);
		
	}

	
}
