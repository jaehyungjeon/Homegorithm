package AccumulatorSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다. 
	어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 K×K 크기의 체스판으로 만들려고 한다.

	체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 
	구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 
	따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
	
	보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 K×K 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 
	당연히 K×K 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

	input
	4 4 3
	BBBB
	BBBB
	BBBW
	BBWB
	
	output
	2
	
	Solution : 1. 최소가 되는 규칙은 2차원 배열에 흑/백을 섞어서 넣고 포인트를 부과한다.
			   2. 행의 누적합과 열의 누적합을 각각 구한 뒤 [row][col]에 위치한 행열의 총합에서 행의 최소 + 열의 최소 + 행렬의 최소값을 더한것을 빼준다.
			   3. 개념적으로는.. 이해가 어려워서 참고하였다.
		
*/

public class ChessRedrawTwo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Min = Integer.MAX_VALUE;
		int Max = Integer.MIN_VALUE;
		int[][] board = new int[row+1][col+1];
		
		boolean check = false;
		for(int i=1; i<=row; i++) {
			String str = br.readLine();
			for(int j=1; j<=col; j++) {
				char c = str.charAt(j-1);
				if(!check && c == 'W') {
					board[i][j] = 1;
				} else if(check && c == 'B'){
					board[i][j] = 1;
				}
				check = !check; // 흑/백으로 Reverse 시킴
			}

			if(col%2 == 0) { // 짝수 일 경우, Reverse 시킴
				check = !check;
			}
		}
		
		// 누적합으로 행 더하기
		for(int i=1; i<=row; i++) {
			int temp = board[i][1];
			for(int j=2; j<=col; j++){
				temp += board[i][j];
				board[i][j] = temp;
			}
		}
		
		// 누적합으로 열 더하기
		for(int i=1; i<=col; i++) {
			int temp = board[1][i];
			for(int j=2; j<=row; j++) {
				temp += board[j][i];
				board[j][i] = temp;
			}
		}
		
		for(int i=M; i<=row; i++) {
			for(int j=M; j<=col; j++) {
				int temp = board[i][j] - (board[i-M][j] + board[i][j-M] - board[i-M][j-M]);
				Min = Math.min(Min, temp);
				Max = Math.max(Max, temp);
			}
		}
		
		System.out.println(Math.min(Min, M*M - Max));
	}
}
