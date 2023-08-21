package Intensification;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

	output
	    *
	   ***
	  *****
	 *******
	*********
	 *******
	  *****
	   ***
	    *
	
	Solution : 1. 중앙을 기점으로 선을 나눈다.
			   2. 출력 형식때문에 몇번 틀렸다.. 마지막 별표시 뒤에는 공백이 없으므로 띄어쓰기가 들어가면 안된다.
*/

public class Star7 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int M = (N*2) - 1; 
		
		String[][] arr = new String[M][M];
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = "*";
			}
		}
		
		int startHalf = N;
		for(int i=0; i<M; i++) {
			if(i < N) {
				for(int j=0; j<startHalf-1; j++) {
					arr[i][j] = " ";
				}
				
				for(int k=M-1; k>M-startHalf; k--) {
					arr[i][k] = "";
				}
				
				startHalf--;
			} else { // 역순으로 지우기
				for(int j=0; j<startHalf+1; j++) {
					arr[i][j] = " ";
				}
				
				for(int k=M-1; k>M-startHalf-2; k--) {
					arr[i][k] = "";
				}
				
				startHalf++;
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j]);
			}
			if(i < M-1) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
