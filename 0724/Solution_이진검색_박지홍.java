
public class Solution_이진검색_박지홍 {

	static int [] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	static int key = 8;
	static String answer = "존재하지 않습니다.";
	static int start, end, pibot;
	public static void main(String[] args) {

		
		// for문 이진탐색
		start = 0;
		end = arr.length;
		pibot = (start+end)/2;
		
		for (int i = 0; i < (start+end)/2; i++) {
			if (arr[pibot] == key) {
				answer = "존재합니다.";
			} else if(arr[pibot] < key) {
				start = pibot;
				pibot = (start+end)/2;
			} else {
				end = pibot;
				pibot = (start+end)/2;
			}
		}
		
		// 재귀 이진탐색
		// 변수값 init
		start = 0;
		end = arr.length;
		pibot = (start+end)/2;
		answer = "존재하지않습니다.";
		
		rec(pibot, start, end);
		
		System.out.println(answer);
		
	}
	
	public static void rec(int pibot, int start, int end) {
		
		if (arr[pibot] == key) {	// 종료 조건
			answer = "존재합니다.";
		} else if(start == pibot) {	// 종료 조건
			answer = "존재하지 않습니다.";
		} else if(arr[pibot] > key){
			end = pibot;
			pibot = (start+end)/2;
			rec(pibot, start, end);
		} else {
			start = pibot;
			pibot = (start+end)/2;
			rec(pibot, start, end);
		}
	}

}
