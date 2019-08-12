import java.io.*;
import java.util.*;

public class Main_1717 {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder("<");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        Queue<Integer> josephus = new LinkedList<Integer>();

        //큐 채우기
        for(int i =1; i<=total; i++)
            josephus.add(i);

        
        int count = 0;

        while (!josephus.isEmpty()){
            int tmp = josephus.poll();
            count++;

            if (count == num) {
                sb.append(tmp + ", ");
                count = 0;
            } else {
                josephus.add(tmp);

            }
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}