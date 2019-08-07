import java.util.Arrays;
import java.util.Scanner;

public class Solution_1225_SW문제해결기본7일차_암호생성기_박지홍 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] code;
		
		for (int testCase = 1; testCase <= 10; testCase++) {

			int a = sc.nextInt();
			code = new int[8];
			int first = 7;
			int rear = 7;

			for (int i = 0; i < code.length; i++) {
				code[((++rear) % code.length)] = sc.nextInt();
			}

			int newIndex = 0;
			while (code[first % code.length] > 0) {
				int temp = code[((++first) % code.length)];
				int setNum = (newIndex++) % 5 + 1;
				if ((temp - setNum) <= 0) {
					code[((++rear) % code.length)] = 0;
					break;
				} else {
					code[((++rear) % code.length)] = temp - setNum;
				}
			}

			System.out.print("#" + testCase + " ");
			for (int i = 0; i < code.length; i++) {
				System.out.print(code[(++first) % code.length] + " ");
			}
			System.out.println();
		}

	}
}
