package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4366_정식이의은행업무_박지홍 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			String s1 = br.readLine();
			String s2 = br.readLine();
			long num1 = Long.parseLong(s1, 2);
			long num2 = Long.parseLong(s2, 3);
			long answer = 0;

			long b1 = 1;
			l2: for (int i = s1.length() - 1; i >= 0; i--) {
				long tmp = 0;
				if (s1.charAt(i) - '0' == 1) {
					tmp = num1 - b1;
				} else {
					tmp = num1 + b1;
				}
				for (int j = 0; j < s2.length(); j++) {
					int emp = s2.charAt(j) - '0';
					long tmp2 = 0;
					long b2 = (long) Math.pow(3, s2.length() - j - 1);
						if (emp == 1) {
							tmp2 = num2 + b2;
							if (tmp == tmp2) {
								answer = tmp;
								break l2;
							} else {
								tmp2 = num2 - b2;
								if (tmp == tmp2) {
									answer = tmp;
									break l2;
								}
							}
						} else if (emp == 2) {
							tmp2 = num2 - b2;
							if (tmp == tmp2) {
								answer = tmp;
								break l2;
							} else {
								tmp2 = tmp2 - b2;
								if (tmp == tmp2) {
									answer = tmp;
									break l2;
								}
							}
						} else {
							tmp2 = num2 + b2;
							if (tmp == tmp2) {
								answer = tmp;
								break l2;
							} else {
								tmp2 = tmp2 + b2;
								if (tmp == tmp2) {
									answer = tmp;
									break l2;
								}
							}
						}
						if (tmp == tmp2) {
							answer = tmp;
							break l2;
						}
					}
				b1 = b1 << 1;
			}
			System.out.println("#" + testCase + " " + answer);
		}
	}
}
