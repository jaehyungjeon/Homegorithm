package Arithmetic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.

	10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
	
	A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

	input
	60466175 36

	output
    ZZZZZ
	
	Solution : 1. NArithmetic2를 다양한 방법으로 풀수도 있다.
			   2. 해당 예시는 다른 방법으로 접근한 방식. 속도 이슈로 반려처리 되었다.
	
*/

public class NArithmetic2_1 {
	
    public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int value = Integer.parseInt(st.nextToken());
        int arith = Integer.parseInt(st.nextToken());
        
        int tmp = 0;
        String str = "";
        while(true) {
        	int digitValue = (int)Math.pow(arith, tmp) * ('Z' - 55);
        	value -= digitValue;
        	digitValue /= (int)Math.pow(arith, tmp);
        	str += String.valueOf(Character.forDigit(digitValue, arith)).toUpperCase(); // 대문자 변환

        	if(value == 0) break;
        	tmp++;
        }
        
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
        
        br.close();
    }
}
