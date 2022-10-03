package Function;

import java.util.*;
import java.io.*;

/*
	Question : 대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.

	input			 
	
	output
	
	Solution : 합계 리턴 함수
*/

public class IntegerSum {
	
	public long sum(int[] a) {
		int sum = 0;
		for(int val : a) {
			sum += val;
		}
		
		return (long)sum;
	}
}