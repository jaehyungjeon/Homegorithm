package Array;

import java.util.*;
import java.io.*;

/*
	Question : 대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.

	input			 
	5
	5 50 50 70 80 100
	7 100 95 90 80 70 60 50
	3 70 90 80
	3 70 90 81
	9 100 99 98 97 96 95 94 93 91
	
	output
	40.000%
	57.143%
	33.333%
	66.667%
	55.556%
	
	Solution : 각각에 맞는 점수와 카운트를 가지고 평균을 구한다. 평균 이상인 것만 추출해서 upper변수에 담고 소수 3째자리까지 출력
*/

public class UpperAverage {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		for(int i=0; i<num; i++) {
			int sum = 0;
			float avg = 0;
			int upper = 0;
			StringTokenizer sc = new StringTokenizer(br.readLine());
			
			int count = Integer.parseInt(sc.nextToken());
			int[] arr = new int[count];
			for(int j=0; j<count; j++) {
				arr[j] = Integer.parseInt(sc.nextToken());
				sum += arr[j];
			}
			
			avg = (float)sum/count;
			for(int j=0; j<count; j++) {
				if((float)arr[j] > avg) {
					upper++;
				}
			}
			
			System.out.println(String.format("%.3f", (float)(upper * 100) / count) + "%");
		}
	}
}