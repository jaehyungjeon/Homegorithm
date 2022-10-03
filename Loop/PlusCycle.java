package Loop;

import java.util.*;
import java.io.*;

/*
	Question : 0보다 크거나 같고, 99보다 작거나 같은 정수가 주어질 때 다음과 같은 연산을 할 수 있다. 
	먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고, 각 자리의 숫자를 더한다. 
	그 다음, 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다. 다음 예를 보자.
	26부터 시작한다. 2+6 = 8이다. 새로운 수는 68이다. 6+8 = 14이다. 새로운 수는 84이다. 8+4 = 12이다. 새로운 수는 42이다. 4+2 = 6이다. 새로운 수는 26이다.
	위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.
	N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오.

	input			 
	26
	
	output
	4
	
	Solution : input은 딱 한번만 받을 것 -> Scanner
			   처음 들어온 숫자를 복사해놓는다.
			   논리에 맞추어 숫자를 구성하면서 반복했을 때, 첫번째와 같으면 while문 break 실시
*/

public class PlusCycle {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		in.close();
		
		int tmpNum = num;
		int count = 0;
		
		while(true) {
			num = ((num%10)*10) + (((num/10) + (num%10)) % 10);
			count++;
			
			if(tmpNum == num) {
				break;
			}
		}
		
		System.out.println(count);
	}
}