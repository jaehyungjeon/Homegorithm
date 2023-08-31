package DynamicPlan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.

	예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만, {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.
	
	수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.
		
	input
	10
	1 5 2 1 4 3 4 5 2 1
	
	output
	7
	
	Solution : 1. 바이토닉 문제는 왼쪽과 오른쪽에서 오는 증가에서 카운트를 비교하는 과정을 거친다.
			   2. 동적으로 큰 수를 찾는 과정을 거치고 일치하는 지점끼리의 합을 도출한다.
			   3. 단, 일치하는 지점은 중복으로 처리되기 때문에 결과값에서 1을 차감해준다.

*/

public class BitonicLIS {

	public static int[] arr, ldp, rdp;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int Max = 0;
		arr = new int[N];
		ldp = new int[N+1];
		rdp = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 왼쪽에서 진행하는 바이토닉
		for(int i=0; i<N; i++) {
			ldp[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j] && ldp[i] <= ldp[j]) {
					ldp[i] = ldp[j] + 1;
				}
			}
		}

		// 오른쪽에서 진행하는 바이토닉
		for(int i=N-1; i>=0; i--) {
			rdp[i] = 1;
			for(int j=N-1; j>i; j--) {
				if(arr[i] > arr[j] && rdp[i] <= rdp[j]) {
					rdp[i] = rdp[j] + 1;
				}
			}
		}

		// Max는 왼쪽과 오른쪽에서 동시에 계산한 부분에서 -1을 해줌(만나는 점에서 중첩이 있기 때문)
		for(int i=0; i<N; i++) {
			Max = Math.max(ldp[i] + rdp[i] - 1, Max);
		}
		
		System.out.println(Max);
	}

}
