package 파이팅;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 냉장고수쨩 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		ArrayList<int[]> chemicals = new ArrayList<>(); // 화학 물질
		for (int i = 0; i < N; i++) {
			chemicals.add(new int[] { sc.nextInt(), sc.nextInt() }); // 최저 보관 온도, 최고 보관 온도 순으로 입력
		}

		Collections.sort(chemicals, new Comparator<int[]>() {
			@Override
			public int compare(int[] c1, int[] c2) {
				if (c1[1] == c2[1])
					return Integer.compare(c1[0], c2[0]);
				return Integer.compare(c2[1], c1[1]); // 최고 보관 온도 내림차순으로 정렬
			}
		});

		ArrayList<int[]> refrigerator = new ArrayList<>(); // 냉장고
		refrigerator.add(chemicals.get(0)); // 최고 온도가 가장 높은 화학 물질을 add
		for (int i = 1; i < N; i++) { // 화학 물질 1부터 N까지 비교
			// 현재 냉장고의 최저 온도보다 화학 물질의 최고 온도가 더 크다면
			if (chemicals.get(i)[1] >= refrigerator.get(refrigerator.size() - 1)[0]) {
				// 화학 물질의 최저 온도와 냉장고의 최저 중 max 값
				int x = Math.max(chemicals.get(i)[0], refrigerator.get(refrigerator.size() - 1)[0]);
				refrigerator.set(refrigerator.size() - 1, new int[] { x, chemicals.get(i)[1] }); // (max, 화학 물질의 최고 온도)
			} else // 화학 물질이 냉장고에 들어갈 수 없는 경우
				refrigerator.add(new int[] { chemicals.get(i)[0], chemicals.get(i)[1] }); // 그 화학 물질의 최저와 최고를 냉장고에 넣어줌
		}

		System.out.println(refrigerator.size()); // 냉장고의 사이즈를 출력

		sc.close();
	}
}
