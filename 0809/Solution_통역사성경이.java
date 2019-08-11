package com.ssafy.swexpert.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_통역사성경이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {

			int N = Integer.parseInt(br.readLine());
			String tmp = br.readLine();

			System.out.print("#" + i);
			int count;
			count = 0;
			String[] strTmp = tmp.split(" ");
			for (int k = 0; k < strTmp.length; k++) {

				if (strTmp[k].matches("^[0-9a-zA-Z]*[\\.|\\?|!]+$")) {
					if (strTmp[k].matches("^[A-Z]{1}[a-z]*[\\.|\\?|!]+$")) {
						count++;
					}
					System.out.print(" " + count);
					count = 0;
				} else if (strTmp[k].matches("[A-Z]{1}[a-z]*$")) {
					count++;
				}
			}

			System.out.println();

		}
	}
}

