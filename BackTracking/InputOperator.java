package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : N개의 수로 이루어진 수열 A1, A2, ..., AN이 주어진다. 또, 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다. 연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)으로만 이루어져 있다.

	우리는 수와 수 사이에 연산자를 하나씩 넣어서, 수식을 하나 만들 수 있다. 이때, 주어진 수의 순서를 바꾸면 안 된다.
	
	예를 들어, 6개의 수로 이루어진 수열이 1, 2, 3, 4, 5, 6이고, 
	주어진 연산자가 덧셈(+) 2개, 뺄셈(-) 1개, 곱셈(×) 1개, 나눗셈(÷) 1개인 경우에는 총 60가지의 식을 만들 수 있다. 
	예를 들어, 아래와 같은 식을 만들 수 있다.
	
	1+2+3-4×5÷6
	1÷2+3+4-5×6
	1+2÷3×4-5+6
	1÷2×3-4+5+6
	식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 한다. 또, 나눗셈은 정수 나눗셈으로 몫만 취한다. 음수를 양수로 나눌 때는 C++14의 기준을 따른다. 즉, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다. 이에 따라서, 위의 식 4개의 결과를 계산해보면 아래와 같다.
	
	1+2+3-4×5÷6 = 1
	1÷2+3+4-5×6 = 12
	1+2÷3×4-5+6 = 5
	1÷2×3-4+5+6 = 7
	N개의 수와 N-1개의 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성하시오.
		
	input
	2
	5 6
	0 0 1 0
	
	output
	30
	30
	
	Solution : 1. Operator를 Backtracking하는 문제
			   2. case 별로 재귀를 진행해준다.
			   3. 숫자의 인덱스와 재귀반복 횟수가 같아지면 return
	
*/

public class InputOperator {

	public static int N;
	public static int[] arr, oper;
	public static int Max = Integer.MIN_VALUE;
	public static int Min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		oper = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		// arr[0] 부터 시작
		dfs(arr[0], 1);
		
		System.out.print(Max + "\n" + Min);
	}
	
	private static void dfs(int M, int idx) {
		if(idx == N) {
			Max = Math.max(Max, M);
			Min = Math.min(Min, M);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(oper[i] > 0) { // 0보다 클 경우만 진행한다.
				oper[i]--;
				
				switch (i) {
					case 0: // 덧셈
						dfs(M + arr[idx], idx+1);
						break;
					case 1: // 뺄셈
						dfs(M - arr[idx], idx+1);
						break;
					case 2: // 곱셈
						dfs(M * arr[idx], idx+1);
						break;
					case 3: // 나눗셈
						dfs(M / arr[idx], idx+1);
						break;
					default:
						break;
				}
				
				// 재귀가 종료되면 다시 복구
				oper[i]++;
			}
		}
	}
}