package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5550_나는개구리로소이다_박지홍 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			String s = br.readLine();
			int result = 0;
			int[] cnt = new int[5];
			ex: for (int i = 0; i < s.length(); i++) {
				switch (s.charAt(i)) {
				case 'c': // 0
					if (cnt[4] >= 1) {
						cnt[4]--;
						cnt[0]++;
					} else { // 울던 개구리가 없으면, 한마리 추가
						cnt[0]++;
					}
					break;
				case 'r': // 1
					if (cnt[0] >= 1) {
						cnt[0]--;
						cnt[1]++;
					} else { // 울던 개구리가 없으면, 한마리 추가
						result = -1;
						break ex;
					}
				case 'o': // 2
					if (cnt[1] >= 1) {
						cnt[1]--;
						cnt[2]++;
					} else { // 울던 개구리가 없으면, 한마리 추가
						result = -1;
						break ex;
					}
				case 'a': // 3
					if (cnt[2] >= 1) {
						cnt[2]--;
						cnt[3]++;
					} else { // 울던 개구리가 없으면, 한마리 추가
						result = -1;
						break ex;
					}
				case 'k': // 4
					if (cnt[3] >= 1) {
						cnt[3]--;
						cnt[4]++;
					} else {	// 울던 개구리가 없으면, 한마리 추가
						result = -1;
						break ex;
					}
				}
			}
			// cnt 0, 1, 2, 3, 의 갯수는 0 이고 [4]에만 값이 있어야함. [4] = 개구리 숫자를 의미
			if(result != -1) {
				if(cnt[0] != 0 || cnt[1] != 0 || cnt[2] != 0 || cnt[3] != 0) {	// 울다 말음.
					result = -1;
				} else {
					result = cnt[4];
				}
			}
			System.out.println("#" + testCase +" " +result);
		}// end of tc
	}// end of main
}// end of class
