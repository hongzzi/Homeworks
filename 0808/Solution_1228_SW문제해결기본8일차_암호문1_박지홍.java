import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1228_SW문제해결기본8일차_암호문1_박지홍 {

	static int T = 10; // 테스트 케이스 횟수 ~

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int testCase = 1; testCase <= T; testCase++) {
			int initSize = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < initSize; j++) { // 원래 있는 암호문 넣기
				list.add(Integer.parseInt(st.nextToken()));
			}

			int commandSize = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < commandSize; i++) {
				String tmp = st.nextToken();
				int index = Integer.parseInt(st.nextToken());
				int iSize = Integer.parseInt(st.nextToken());
				int[] arr = new int[iSize];
				for (int j = 0; j < iSize; j++) {
					arr[j] = Integer.parseInt(st.nextToken());
				}
				for (int j = iSize - 1; j >= 0; j--) {
					list.add(index, arr[j]);
				}
			}
			List<Integer> answer = list.subList(0, 10);
			System.out.print("#" + testCase);
			for (Integer integer : answer) {
				System.out.print(" " + integer);
			}

			System.out.println();
		}

	}
}
