package Array;

import java.util.*;
import java.io.*;

/*
	Question : 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
	예를 들어, 서로 다른 9개의 자연수
	3, 29, 38, 12, 57, 74, 40, 85, 61
	이 주어지면, 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.

	input			 
	3
	29
	38
	12
	57
	74
	40
	85
	61
	
	output
	85
	8
	
	Solution : for문을 한번만 써도 결과는 나올 수 있으나, 담고 비교하는게 더 안정성 있기에 해당 방식으로 진행하였음.
*/

public class Maximum {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int[] arr = new int[9];
		int count = 0;
		
		for(int i=0; i<9; i++) {
			arr[i] = in.nextInt();
		}
		
		int max = arr[0];
		for(int i=0; i<9; i++) {
			if(arr[i] >= max) {
				max = arr[i];
				count = (i+1);
			}
		}
		
		System.out.println(max + "\n" + count);
	}
}