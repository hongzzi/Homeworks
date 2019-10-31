package com.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_6782_현주가좋아하는제곱근놀이_박지홍 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());

			int result = 0;
			long num = N;
			while (num != 2) {
				int x = (int) Math.sqrt(num);
				if (Math.pow(x, 2) == num) {
					num = x;
					result++;
				} else {
					long temp = (x+1) * (x+1);
					result += temp-num;
					num = temp;
				}
			}
			System.out.println("#" + testCase + " " + result);
		}
	}
}
