package DoubleArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 아직 글을 모르는 영석이가 벽에 걸린 칠판에 자석이 붙어있는 글자들을 붙이는 장난감을 가지고 놀고 있다. 

	이 장난감에 있는 글자들은 영어 대문자 ‘A’부터 ‘Z’, 영어 소문자 ‘a’부터 ‘z’, 숫자 ‘0’부터 ‘9’이다. 영석이는 칠판에 글자들을 수평으로 일렬로 붙여서 단어를 만든다. 
	다시 그 아래쪽에 글자들을 붙여서 또 다른 단어를 만든다. 이런 식으로 다섯 개의 단어를 만든다. 아래 그림 1은 영석이가 칠판에 붙여 만든 단어들의 예이다. 
	
	A A B C D D
	a f z z 
	0 9 1 2 1
	a 8 E W g 6
	P 5 h 3 k x
	<그림 1>
	
	한 줄의 단어는 글자들을 빈칸 없이 연속으로 나열해서 최대 15개의 글자들로 이루어진다. 또한 만들어진 다섯 개의 단어들의 글자 개수는 서로 다를 수 있다. 
	
	심심해진 영석이는 칠판에 만들어진 다섯 개의 단어를 세로로 읽으려 한다. 세로로 읽을 때, 각 단어의 첫 번째 글자들을 위에서 아래로 세로로 읽는다. 다음에 두 번째 글자들을 세로로 읽는다. 이런 식으로 왼쪽에서 오른쪽으로 한 자리씩 이동 하면서 동일한 자리의 글자들을 세로로 읽어 나간다. 위의 그림 1의 다섯 번째 자리를 보면 두 번째 줄의 다섯 번째 자리의 글자는 없다. 이런 경우처럼 세로로 읽을 때 해당 자리의 글자가 없으면, 읽지 않고 그 다음 글자를 계속 읽는다. 그림 1의 다섯 번째 자리를 세로로 읽으면 D1gk로 읽는다. 
	
	그림 1에서 영석이가 세로로 읽은 순서대로 글자들을 공백 없이 출력하면 다음과 같다:
	
	Aa0aPAf985Bz1EhCz2W3D1gkD6x
	
	칠판에 붙여진 단어들이 주어질 때, 영석이가 세로로 읽은 순서대로 글자들을 출력하는 프로그램을 작성하시오.

	input
	ABCDE
	abcde
	01234
	FGHIJ
	fghij
	-------------------------
	AABCDD
	afzz
	09121
	a8EWg6
	P5h3kx
	
	output
    Aa0FfBb1GgCc2HhDd3IiEe4Jj
    -------------------------
    Aa0aPAf985Bz1EhCz2W3D1gkD6x
	
	Solution : 1. 효율적이지 않은 방법으로 해결하긴 했다..
			   2. 단순한 생각으로 maxLength만큼 2차원 배열에 공백값을 넣어주고, 들어오는 read값에 문자열을 쪼개서 넣는 방법을 채택했다.
			   3. 공백이 아닐경우 단어를 append시켜 하나의 문자로 형성하였다.
*/

public class ReadLength {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] arr = new String[5];
		char[][] verbArr;
		int maxLength = Integer.MIN_VALUE;
		
		for(int i=0; i<5; i++) {
			arr[i] = br.readLine();
			maxLength = Math.max(maxLength, arr[i].length());
		}
		
		verbArr = new char[5][maxLength];
		
		for(int i=0; i<5; i++) { // row
			for(int j=0; j<maxLength; j++) {
				verbArr[i][j] = ' ';
			}
		}
		
		for(int i=0; i<5; i++) { // row
			for(int j=0; j<arr[i].length(); j++) {
				verbArr[i][j] = arr[i].charAt(j);
			}
		}
		
		for(int i=0; i<maxLength; i++) { // col
			for(int j=0; j<5; j++) {
				if(verbArr[j][i] != ' ') {
					sb.append(String.valueOf(verbArr[j][i]));
				}
			}
		}

		System.out.println(sb.toString());
	}

}
