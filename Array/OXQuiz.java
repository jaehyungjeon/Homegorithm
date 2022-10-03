package Array;

import java.util.*;
import java.io.*;

/*
	Question : "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 
	문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
	"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
	OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.

	input			 
	5
	OOXXOXXOOO
	OOXXOOXXOO
	OXOXOXOXOXOXOX
	OOOOOOOOOO
	OOOOXOOOOXOOOOX
	
	output
	10
	9
	7
	55
	30
	
	Solution : 연속되면 count++, 아니면 count = 0으로 초기화 하되 지속적으로 sum에 합계 계산
*/

public class OXQuiz {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		String[] arr = new String[num];
		
		for(int i=0; i<num; i++) {
			arr[i] = br.readLine();
		}
		
		for(int i=0; i<num; i++) {
			int count = 0;
			int sum = 0;
			
			for(int j=0; j<arr[i].length(); j++) {
				if(arr[i].charAt(j) == 'O') {
					count++;
				} else {
					count = 0;
				}
				
				sum += count;
			}
			
			System.out.println(sum);
		}
	}
}