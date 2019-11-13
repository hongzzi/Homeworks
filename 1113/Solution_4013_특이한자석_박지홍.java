package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석_박지홍 {

	private static boolean[] already;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int K = Integer.parseInt(br.readLine());

			String[] wStr = new String[4];
			int[] wInt = new int[4];
			int answer = 0;

			for (int i = 0; i < 4; i++) {
				wStr[i] = br.readLine().replaceAll(" ", "");
				for (int j = 0; j < wStr[i].length(); j++) {
					if (wStr[i].charAt(j) == '1') {
						wInt[i] += Math.pow(2, wStr[i].length() - j - 1);
					}
				}
			}
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				already = new boolean[4];
				rotation(num - 1, dir, wInt, wStr);
			}
			for (int i = 0; i < 4; i++) {
				if (wInt[i] >= 128) {
					answer += Math.pow(2, i);
				}
			}
			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void rotation(int num, int dir, int[] wheels, String[] binary) {
		already[num] = true;
		if (num + 1 < 4 && !already[num + 1] && (binary[num].charAt(2) != binary[num + 1].charAt(6))) {
			rotation(num + 1, dir == 1 ? -1 : 1, wheels, binary);
		}
		if (num - 1 >= 0 && !already[num - 1] && (binary[num].charAt(6) != binary[num - 1].charAt(2))) {
			rotation(num - 1, dir == 1 ? -1 : 1, wheels, binary);
		}
		if (dir == 1) {
			if (wheels[num] % 2 == 1) {
				wheels[num] = wheels[num] >> 1;
				wheels[num] += 128;
			} else {
				wheels[num] = wheels[num] >> 1;
			}
		} else if (dir == -1) {
			if (wheels[num] >= 128) {
				wheels[num] = wheels[num] - 128 << 1;
				wheels[num] += 1;
			} else {
				wheels[num] = wheels[num] << 1;
			}
		}
		String temp = Integer.toBinaryString(wheels[num]);
		StringBuilder sb = new StringBuilder();
		if (temp.length() < 8) {
			for (int i = 0; i < 8 - temp.length(); i++) {
				sb.append('0');
			}
		}
		binary[num] = sb.append(temp).toString();
	}
}
