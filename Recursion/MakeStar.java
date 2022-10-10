package Recursion;

import java.util.*;
import java.io.*;

/*
	Question :	재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.

	크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
	
	***
	* *
	***
	N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.

	input			 
	27
	
	output
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************
	***   ******   ******   ***
	* *   * ** *   * ** *   * *
	***   ******   ******   ***
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************
	*********         *********
	* ** ** *         * ** ** *
	*********         *********
	***   ***         ***   ***
	* *   * *         * *   * *
	***   ***         ***   ***
	*********         *********
	* ** ** *         * ** ** *
	*********         *********
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************
	***   ******   ******   ***
	* *   * ** *   * ** *   * *
	***   ******   ******   ***
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************
	
	Solution : 1. 인터넷 참조.. 규칙은 거듭제곱 사이에 공백이 위치하게끔 하는 것..!
			   2. 5번째에는 무조건 공백이 발생함으로 count == 5 -> blank = true로 공백 생성
*/

public class MakeStar {
	
	public static char arr[][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		
		arr = new char[num][num];
		
		star(0, 0, num, false);
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void star(int x, int y, int n, boolean blank) {
		if(blank) {
			for(int i=x; i<x+n; i++) {
				for(int j=y; j<y+n; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		
		if(n == 1) {
			arr[x][y] = '*';
			return;
		}
		
		int size = n/3;
		int count = 0;
		for(int i=x; i<x+n; i+=size) { // 0, 27, (0..3..6..9..12..15..18..21..24..27)
			for(int j=y;j<y+n; j+=size) { // 0, 27, (0..3..6..9..12..15..18..21..24..27)
				count++;
				if(count == 5) star(i, j, size, true); // 5번째 순서에는 무조건 공백을 만든다.
				else star(i, j, size, false);
			}
		}
	}
}