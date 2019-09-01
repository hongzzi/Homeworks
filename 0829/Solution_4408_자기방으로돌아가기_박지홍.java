package algo_지홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_4408_자기방으로돌아가기_박지홍 {

	static class Student {
		int s;
		int e;
		int sec;
		public Student(int s, int e) {
			s = (s+1)/2;
			e = (e+1)/2;
			if (s < e) {
				this.s = s;
				this.e = e;
			} else {
				this.s = e;
				this.e = s;
			}
			this.sec = 1;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		

		for (int testCase = 1; testCase <= T; testCase++) {

			int N = Integer.parseInt(br.readLine().trim());
			Queue<Student> que = new LinkedList<Student>();
			List<Student> list = new ArrayList<Student>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.add(new Student(a,b));
			}
			
			list.sort(new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					return o1.s-o2.s;
				}
			});
			
			for (int i = 0; i < list.size(); i++) {
				que.add(list.get(i));
			}
			
			int sec = 0;
			while(que.size() > 0) {
				Student tmp = que.poll();
				sec = tmp.sec;
				int size = que.size();
				for (int i = 0; i < size; i++) {
					Student tmp2 = que.poll();
					if(tmp2.e < tmp.s || tmp2.s > tmp.e) {
						tmp = tmp2;
					} else {
						tmp2.sec = tmp2.sec+1;
						que.add(tmp2);
					}
				}
			}
			
			System.out.println("#"+testCase+" "+sec);
		}
	}
}
