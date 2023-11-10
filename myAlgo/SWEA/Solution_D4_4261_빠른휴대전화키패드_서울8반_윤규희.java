package 푸는중;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D4_4261_빠른휴대전화키패드_서울8반_윤규희 {
	static String[] keyboards = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	static ArrayList<String> words;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			String keyboard = st.nextToken();
			int word_cnt = Integer.parseInt(st.nextToken());
			words = new ArrayList<String>();
			int result = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < word_cnt; i++) {
				String s = st.nextToken();
				if (s.length() == keyboard.length())
					words.add(s);
			}
	
			for (int w = 0; w < words.size(); w++) {
				String wd = words.get(w); // tomo
				int count = 0;
				
				for (int k = 0; k < keyboard.length(); k++) {
					String comp = keyboards[keyboard.charAt(k) - '0']; // mno
					if (comp.contains("" + wd.charAt(k))) {
							count++;
					}
				}
				if(count == wd.length()) {
					result++;
				}
			}
			System.out.println("#" + tc + " "  + result);
		}

	}

}
