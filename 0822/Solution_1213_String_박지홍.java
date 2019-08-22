import java.util.Scanner;

public class Solution_1213_String_박지홍 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			int t = Integer.parseInt(sc.nextLine());
			String find = sc.nextLine();
			String str = sc.nextLine();

			str = str.replaceAll(find, " !");
			String[] srr = str.split(" ");
			System.out.println("#"+i+" "+(srr.length-1));
		}
	}
}

