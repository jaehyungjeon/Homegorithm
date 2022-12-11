package BruteForce;

import java.util.*;
import java.io.*;

/*
	Question : 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다. 
	어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
	체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 
	따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
	보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 
	당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

	input			 
	8 8
	WBWBWBWB
	BWBWBWBW
	WBWBWBWB
	BWBBBWBW
	WBWBWBWB
	BWBWBWBW
	WBWBWBWB
	BWBWBWBW
	
	output
	1
	
	Solution : 1. 전체 나올 수 있는 최대 경우의 수 -> 8X8 = 16
			   2. row가 변경될떄마다 앞에 위치하는 체스의 색이 W -> B / B -> W 인 것을 확인
			   3. char을 변경해주면서 일치하지 않는 것의 갯수를 찾는다.
			   4. 8*8 초과 이후의 갯수를 판단하여 최솟값을 Math Util을 이용하여 리턴처리.
	
*/

public class ChessRedraw {
	
	public static char[][] arr;
	public static int min = 64; // return 할 최솟값 -> 모두 false일 때 64가 8*8의 MAX 경우의 수
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		arr = new char[row][col];
		
		for(int i=0; i<row; i++) {
			String str = br.readLine();
			for(int j=0; j<col; j++) {
				char chess  = str.charAt(j);
				
				arr[i][j] = chess;
			}
		}
		
		int prow = row - 7;
		int pcol = col - 7;
		
		for(int i=0; i<prow; i++) {
			for(int j=0; j<pcol; j++) {
				find(i, j);
			}
		}
		
		System.out.println(min);
	}
	
	/* 홀, 짝수 여부에 따른 T/F 판정 체크(8X8 초과 범위 Search) */
	public static void find(int x, int y) {
		int endX = x + 8;
		int endY = y + 8;
		int count = 0;
		
		char check = arr[x][y];
		
		for(int i=x; i<endX; i++) {
			for(int j=y; j<endY; j++) {
				if(arr[i][j] != check) {
					count++;
				}
				
				check = modifyChar(check);
			}
			
			check = modifyChar(check);
		}
		
		count = Math.min(count, 64- count);
		
		min = Math.min(min, count);
	}
	
	/* Character Type Modify */
	public static char modifyChar(char modi) {
		return (modi == 'W') ? 'B' : 'W';
	}
}