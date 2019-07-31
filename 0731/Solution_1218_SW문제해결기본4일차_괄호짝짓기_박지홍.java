import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1218_SW문제해결기본4일차_괄호짝짓기_박지홍 {

	static String[] f = { "{", "[", "(", "<" };
	static String[] d = { "}", "]", ")", ">" };
	static int T = 10; // 테스트 케이스

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str; // 받아올 문자열
		int len; // 문자열 길이

		for (int i = 1; i <= T; i++) {

			len = Integer.parseInt(br.readLine());
			int[] stack = new int[len + 1]; // 널널하게 len만큼
			int top = -1;
			boolean flag = true;
			str = br.readLine().replace("{", "1").replace("[", "2").replace("(", "3").replace("<", "4");
			str = str.replace("}", "5").replace("]", "6").replace(")", "7").replace(">", "8");

			for (int j = 0; j < len; j++) { // 문자열 길이만큼 for문
				int tmp = str.charAt(j)-'0';

				if (tmp <= 4) { 			// 4이하면 여는 괄호. 스택에 넣어줌
					stack[++top] = tmp;
				} else {					// 이상이면 닫는 괄호

					if (top > -1) { 		// if 스택이 여는 괄호를 갖고 있다면,
						int pop = stack[top--];
						if (tmp != pop + 4) { // 닫는 괄호가 나왔을 때 스택의 맨 위의 숫자와 대조
							flag = false;
							break; // 테스트 빠져나오기
						}
					} else { // if. 닫는 괄호가 더 많은 경우
						flag = false;
						break; // 테스트 빠져나오기

					}
				}
			}
			if (flag) {
				System.out.printf("#%d 1\n", i);
			} else {
				System.out.printf("#%d 0\n", i);
			}

		}
	}
}
