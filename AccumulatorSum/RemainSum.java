package AccumulatorSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.

	즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.

	input
	5 3
	1 2 3 1 2
	
	output
	7
	
	Solution : 1. m으로 나눈 나머지가 0일 경우를 계산하는데, 수를 조합하여 나타낼 수 있는 수의 합계에서 나누면 된다.
	 		   2. 예를들어, 현재 주어진 input에서는 3과 1+2/1+2 로 2가지 숫자를 조합한 3이 예시로 들 수 있다.
	 		   3. dp를 이용한 계산을 사용하면 시간에 대한 이슈없이 빠르게 계산할 수 있는데, 누적합인 sum+=cur를 계산한 나머지 값을 배열에 넣고 해당 지점의 카운트를 더해주면 된다.
	
*/

public class RemainSum {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int sum = 0;
        int[] cnt = new int[1000];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int cur = Integer.parseInt(st.nextToken());
            sum += cur;
            sum %= m;
            answer += cnt[sum];
            cnt[sum]++;
            if (sum==0) answer++;
        }
        
        System.out.println(answer);
	}

}
