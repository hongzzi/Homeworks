package 수업;

import java.util.Scanner;

public class Solution_4796_의석이의우뚝선산_박지홍 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int[] mount = new int[N];
			for (int i = 0; i < mount.length; i++) {
				mount[i] = sc.nextInt();
			}
			int answer = 0;
			int i = 0;
			while ( i < mount.length-1 ) {
				int upcnt = 0;
				int dwcnt = 0;
				for (int j = i; j < mount.length - 1; j++) { // 올라가는 구간
					if (mount[j] > mount[j + 1]) {
						i = j;
						break;
					}
					upcnt++;
				}
				if (upcnt>0) {
					for (int j = i; j < mount.length - 1; j++) { // 내려가는 구간 찾기
						if(dwcnt > 0) {
							i = j-1;
						}
						if (mount[j + 1] > mount[j]) {
							break;
						}
						dwcnt++;
					}
				}
				i++;
				answer += upcnt * dwcnt;
			}
			System.out.println("#" + testCase + " " + answer);
		}
		sc.close();
	}
}
