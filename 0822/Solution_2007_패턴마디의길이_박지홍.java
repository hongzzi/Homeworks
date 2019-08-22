import java.util.Scanner;

public class Solution_2007_패턴마디의길이_박지홍 {

	public static void main(String[] args) throws NumberFormatException{
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= t; i++) {
			int maxIndex = 0 ;
			String str = sc.nextLine();
			for (int j = 0; j < 10; j++) {
				char c1 = str.charAt(j);
				if( c1 >= '0' && c1 <= '9' ) {
					continue;
				}
				str = str.replaceAll( String.valueOf(c1), String.valueOf(j));
				maxIndex = j;
			}
			System.out.println("#"+i+" "+(maxIndex+1));
		}
	}

}
