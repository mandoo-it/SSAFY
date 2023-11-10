import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_백준_1157_단어공부_서울8반_윤규희_hashmapComparator {
	@SuppressWarnings("unchecked")
	// hashmap을 value값으로 정렬
	static List sort(TreeMap<Character, Integer> map) {
		List<Character> list = new ArrayList<>();
		list.addAll(map.keySet());
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);
				return ((Comparable) v2).compareTo(v1);
			}
		});
		return list;
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		TreeMap<Character, Integer> map = new TreeMap<>();
		//sort(map);
		String word = br.readLine().toUpperCase();
		for(int i=0;i<word.length();i++) {
			if(map.containsKey(word.charAt(i))) {
				int a = map.get(word.charAt(i));
				//map.re(word.charAt(i), map.get(word.charAt(i))+ 1);
				map.replace(word.charAt(i), a + 1);
			} else {
				map.put(word.charAt(i), 1);
			}
		}
		//sort(map);
		int count = 1;
		Iterator i = sort(map).iterator();
		
		if(map.size() > 1) {
			char c1 = (char) i.next();
			char c2 = (char) i.next();
			if(map.get(c1) == map.get(c2)) {
				System.out.println("?");
			} else if(map.get(c1) != map.get(c2)){
				System.out.println(c1);
			}
		} else if(map.size() == 1){
			System.out.println(i.next());
		}
		
		
//		while(i.hasNext()) {
////			char c = (char) i.next();
////			System.out.println(c + " " + map.get(c));
////			if(map.)
//			if(map.get)
//		}
		
	}

	
}
