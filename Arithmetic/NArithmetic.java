package Arithmetic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.

	10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
	
	A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

	input
	ZZZZZ 36

	output
    60466175
	
	Solution : 1. 자릿수마다 값 * 제곱값을 해주어야 하므로 charAt으로 나눈 문자의 값을 추출한다.
			   2. 실제 값에 대한 계산은 아스키코드 값인 55를 빼줌으로서 평준화한다.
			   3. 전체 결괏값은 자릿수의 제곱승 * 값을 기존에 계속 더해준다.
*/

public class NArithmetic {
	
    public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        int arith = Integer.parseInt(st.nextToken());
        int answer = 0;
        int len = str.length();
        for(int i=0; i<len; i++) {
            int val = str.charAt(len-i-1)-55;
            if(val < 10) {
                val = val + 7;
            }
            answer += val * Math.pow(arith, i);
        }
        
        System.out.println(answer);
    }
}
