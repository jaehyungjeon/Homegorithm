package Drainage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
	Question : 골드바흐의 추측: 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.
	
	짝수 N을 두 소수의 합으로 나타내는 표현을 골드바흐 파티션이라고 한다. 짝수 N이 주어졌을 때, 골드바흐 파티션의 개수를 구해보자. 두 소수의 순서만 다른 것은 같은 파티션이다.
	
	input
	5
	6
	8
	10
	12
	100
	
	output
	1
	1
	2
	1
	6
	
	Solution : 1. 로직 헷갈려서 답안 참고.
			   2. 소수를 boolean 배열에 넣는 로직은 결국 sqrt를 이용하여 구하는 것과 동일한 로직이다.(반복문의 횟수를 줄여줌)
			   3. 중앙 인덱스를 기준으로 끝과 끝의 값을 더했을 때, 값이 일치하면 되는 것이므로 사이즈 값을 구해준다.
			   4. 사이즈 값 자체를 리턴시켜준다.

*/


public class GoldBachPartition {

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] prime = getPrimeMethod();

		int N = Integer.parseInt(br.readLine());
		
        for (int idx1 = 0; idx1 < N; idx1++) {
            int size = 0;
            int n = Integer.parseInt(br.readLine());
            int midN = n / 2;
            for (int idx2 = midN; idx2 > 1; idx2--) {
                if (prime[idx2] && prime[n - idx2]) {
                    size++;
                }
            }
            sb.append((size)).append("\n");
        }

        sb.setLength(sb.length() - 1);
        System.out.print(sb.toString());
        
        br.close();
	}
	
	private static boolean[] getPrimeMethod() {
        int sqrtPrimeLimitNum = 1000;
        int PrimeLimitNum = sqrtPrimeLimitNum * sqrtPrimeLimitNum;
        final boolean[] isPrime = new boolean[PrimeLimitNum];
        Arrays.fill(isPrime, Boolean.TRUE);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i <= sqrtPrimeLimitNum; i++) {
            if (isPrime[i]) {
                for (int j = i; j < PrimeLimitNum; j += i) {
                    if (isPrime[j] && i != j) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        return isPrime;
	}
}
