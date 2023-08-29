package DynamicPlan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 오늘도 서준이는 동적 프로그래밍 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.

	오늘은 n의 피보나치 수를 재귀호출과 동적 프로그래밍으로 구하는 알고리즘을 배웠다. 
	재귀호출에 비해 동적 프로그래밍이 얼마나 빠른지 확인해 보자. 아래 의사 코드를 이용하여 n의 피보나치 수를 구할 경우 코드1 코드2 실행 횟수를 출력하자.
	
	피보나치 수 재귀호출 의사 코드는 다음과 같다.
	
	fib(n) {
	    if (n = 1 or n = 2)
	    then return 1;  # 코드1
	    else return (fib(n - 1) + fib(n - 2));
	}
	피보나치 수 동적 프로그래밍 의사 코드는 다음과 같다.
	
	fibonacci(n) {
	    f[1] <- f[2] <- 1;
	    for i <- 3 to n
	        f[i] <- f[i - 1] + f[i - 2];  # 코드2
	    return f[n];
	}
		
	input
	5
	
	output
	5 3
	
	Solution : 1. dp를 이용한 피보나치 수열과 재귀를 이용한 피보나치 수열의 호출횟수를 알아보기 위함.

*/

public class Fibonacci1 {

	public static int N;
	public static int[] dp;
	public static int count1 = 0;
	public static int count2 = 0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N];
		
		fibo1(N);
		fibo2(N);
		System.out.println(count1 + " " + count2);
	}
	
	private static int fibo1(int N) {
		if(N == 1 || N == 2) {
			count1++;
			return 1;
		}
		
		return fibo1(N-1) + fibo1(N-2);
	}
	
	private static int fibo2(int N) {
		dp[0] = 1;
		dp[1] = 2;
		
		for(int i=2; i<N; i++) {
			count2++;
			dp[i] = dp[i-2] + dp[i-1];
		}
		
		return dp[N-1];
	}

}
