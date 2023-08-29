package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 스도쿠는 18세기 스위스 수학자가 만든 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 현재 많은 인기를 누리고 있다. 
	이 게임은 아래 그림과 같이 가로, 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판 위에서 이뤄지는데, 게임 시작 전 일부 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다.

	나머지 빈 칸을 채우는 방식은 다음과 같다.
	
	각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
	굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
	위의 예의 경우, 첫째 줄에는 1을 제외한 나머지 2부터 9까지의 숫자들이 이미 나타나 있으므로 첫째 줄 빈칸에는 1이 들어가야 한다.
	
	또한 위쪽 가운데 위치한 3x3 정사각형의 경우에는 3을 제외한 나머지 숫자들이 이미 쓰여있으므로 가운데 빈 칸에는 3이 들어가야 한다.
	이와 같이 빈 칸을 차례로 채워 가면 다음과 같은 최종 결과를 얻을 수 있다.
	
	게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오.
		
	input
	0 3 5 4 6 9 2 7 8
	7 8 2 1 0 5 6 0 9
	0 6 0 2 7 8 1 3 5
	3 2 1 0 4 6 8 9 7
	8 0 4 9 1 3 5 0 6
	5 9 6 8 2 0 4 1 3
	9 1 7 6 5 2 0 8 0
	6 0 3 7 0 1 9 5 2
	2 5 8 3 9 4 7 6 0
	
	output
	1 3 5 4 6 9 2 7 8
	7 8 2 1 3 5 6 4 9
	4 6 9 2 7 8 1 3 5
	3 2 1 5 4 6 8 9 7
	8 7 4 9 1 3 5 2 6
	5 9 6 8 2 7 4 1 3
	9 1 7 6 5 2 3 8 4
	6 4 3 7 8 1 9 5 2
	2 5 8 3 9 4 7 6 1
	
	Solution : 1. 스도쿠의 기본 원리 - 가로/세로에 같은 숫자가 있으면 안된다. 3*3 배열 안에 같은 숫자가 있으면 안된다.
			   2. 유효성 파악은 가로 / 세로 / 3*3 테두리 안에서 같은 숫자가 있을 경우 false 처리 하였다.
			   3. 열이 다 채워지면 다음 행으로 넘어간다.
			   4. 적합하지 않을 경우 다시 값을 0으로 반환하여 다음 dfs에서 탐색하도록 한다.
			   5. row가 9 즉, 범위를 벗어나서 모두 다 입력이 되었을 경우 System.exit를 활용해 프로그램 자체를 종료한다.
	
*/

public class Sudoku {

	public static int[][] arr = new int[9][9];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		br.close();
		dfs(0, 0);
	}
	
	private static void dfs(int row, int col) {
		if(col == 9) { // 열이 다 채워질 경우 다음 행으로 이동
			dfs(row+1, 0);
			return;
		}
		
		if(row == 9) { // 행이 다 채워질 경우, 결과값을 리턴(0~8)
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			
			System.exit(0);
		}
		
		// 해당 배열의 값이 0일 경우에만 탐색 실시
		if(arr[row][col] == 0) { 
			for(int i=1; i<=9; i++) {
				if(property(row, col, i)) {
					arr[row][col] = i;
					dfs(row, col+1);
				}
			}
			arr[row][col] = 0;
			return;
		}
		
		dfs(row, col+1);
	}
	
	private static boolean property(int row, int col, int value) {
		// 행과 열에 같은 원소가 있는지 검사
		for(int i=0; i<9; i++) {
			if(arr[row][i] == value) {
				return false;
			}
		}
		
		for(int i=0; i<9; i++) {
			if(arr[i][col] == value) {
				return false;
			}
		}
		
		// 3*3 안에 같은 원소가 있는지 검사
		int rangeRow = (row / 3) * 3;
		int rangeCol = (col / 3) * 3;
		for(int i=rangeRow; i<rangeRow+3; i++) {
			for(int j=rangeCol; j<rangeCol+3; j++) {
				if(arr[i][j] == value) return false;
			}
		}
		
		return true;
	}

}
