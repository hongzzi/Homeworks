package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정올_2577_회전초밥 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] cArr = new int[N + k];
		int maxType = 0;
		int[] tArr = new int[d+1];
		int nowEat = 0;
		Queue<Integer> eQue = new LinkedList<Integer>();

		for (int i = 0; i < N; i++) {
			cArr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = N; i < N + k; i++) {
			cArr[i] = cArr[i - N];
		} // 초밥 레일

		for (int i = 0; i < N + k; i++) {
			if (eQue.size() == k) {
				if (maxType <= nowEat) {
					maxType = tArr[c]==0 ? nowEat+ 1 : nowEat;
					if (maxType == k + 1)
						break;
				}
				int temp = eQue.poll();
				tArr[temp]--;
				if (tArr[temp]==0) {
					nowEat--;
				}
			}
			eQue.add(cArr[i]);
			if(tArr[cArr[i]] == 0) {
				nowEat++;
			}
			tArr[cArr[i]]++;
		}
		System.out.println(maxType);
	}
}
