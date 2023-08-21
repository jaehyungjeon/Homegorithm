package InputOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 순서대로 적혀져 있다. 
	바구니는 일렬로 놓여져 있고, 가장 왼쪽 바구니를 1번째 바구니, 그 다음 바구니를 2번째 바구니, ..., 가장 오른쪽 바구니를 N번째 바구니라고 부른다. 
	
	도현이는 앞으로 M번 바구니의 순서를 역순으로 만들려고 한다. 도현이는 한 번 순서를 역순으로 바꿀 때, 순서를 역순으로 만들 범위를 정하고, 그 범위에 들어있는 바구니의 순서를 역순으로 만든다.
	
	바구니의 순서를 어떻게 바꿀지 주어졌을 때, M번 바구니의 순서를 역순으로 만든 다음, 바구니에 적혀있는 번호를 가장 왼쪽 바구니부터 출력하는 프로그램을 작성하시오.
	
	input			 
	5 4
	1 2
	3 4
	1 4
	2 2
	
	output
	3 4 1 2 5
	
	Solution : 1. 범위안에서 순서를 역순으로 치환하는건 end지점과 start지점의 차를 2로 나눈 몫으로 서로 교환하는 것으로 접근하였다.
	 		   2. 같은 위치일 경우에도 스위칭한다고 하였을때를 기준으로 몫은 무조건 + 1을 해주었다.
	 		   3. 시작배열은 점차 증가하고 end배열은 점차 감소한 것끼리의 스위칭이므로 for문 안에서 후위연산자 처리를 해주었다.

*/


public class BucketExchange {

	public static int[] arr;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		// 최초 배열 초기화
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arrMethod(start, end);
		}

		for(int i=0; i<N; i++) {
			sb.append(arr[i]);
			if(i != N-1) {
				sb.append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	// 역순으로 계산하는 Method
	private static void arrMethod(int start, int end) {
		int medi = (end-start) / 2 + 1;
		for(int i=0; i<medi; i++) {
			int temp = arr[start-1];
			arr[start-1] = arr[end-1];
			arr[end-1] = temp;
			end--;
			start++;
		}
	}
}
