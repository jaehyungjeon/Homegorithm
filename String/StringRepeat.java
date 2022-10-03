package String;

import java.util.*;
import java.io.*;

/*
	Question : 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
	즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.
	QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.

	input			 
	2
	3 ABC
	5 /HTP
	
	output
	AAABBBCCC
	/////HHHHHTTTTTPPPPP
	
	Solution : 스트링으로 받아서 split 후 배열 값들을 정수로 변환한 뒤 + 실시
*/

public class StringRepeat {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0; i<num; i++) {
			StringTokenizer sc = new StringTokenizer(br.readLine());
			
			int count = Integer.parseInt(sc.nextToken());
			String str = sc.nextToken();
			
			String[] arr = str.split("");
			for(int j=0; j<arr.length; j++) {
				for(int k=0; k<count; k++) {
					sb.append(arr[j]);
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}