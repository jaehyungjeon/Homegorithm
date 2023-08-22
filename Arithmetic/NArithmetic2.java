package Arithmetic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
	Question : 10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.

	10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
	
	A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

	input
	60466175 36

	output
    ZZZZZ
	
	Solution : 1. 나머지를 이용한 문자를 리스트에 담아준다.
			   2. value값을 진법으로 계속 나누는 과정을 반복한다.
	
*/

public class NArithmetic2 {
	
    public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int value = Integer.parseInt(st.nextToken());
        int arith = Integer.parseInt(st.nextToken());
        
        List<Character> list = new ArrayList<>();
        while (value > 0) {
            if (value % arith < 10) {
                list.add((char) (value % arith + '0'));
            } else {
                list.add((char) (value % arith - 10 + 'A'));
            }

            value /= arith;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i));
        }
    }
}
