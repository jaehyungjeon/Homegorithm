package Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : �� N���� ���ڿ��� �̷���� ���� S�� �־�����.
	�Է����� �־����� M���� ���ڿ� �߿��� ���� S�� ���ԵǾ� �ִ� ���� �� �� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	input			 
	5 11
	baekjoononlinejudge
	startlink
	codeplus
	sundaycoding
	codingsh
	baekjoon
	codeplus
	codeminus
	startlink
	starlink
	sundaycoding
	codingsh
	codinghs
	sondaycoding
	startrink
	icerink
	
	output
	4
		
	Solution : 
		1. ���ڿ� �񱳸� ������ �迭 �� �ϳ��� �����Ѵ�.
		2. ���ڿ��� �޾Ƽ� �Լ��� ���� count ����
		3. count ���
		-- �� ���� ����� ���� �� ������....
*/

public class StringSet {

	public static String[] compare;
	public static int N, M; // ���� ���� ���� set
	public static int count = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(sc.nextToken());
		M = Integer.parseInt(sc.nextToken());
		
		compare = new String[N];
		
		for(int i=0; i<N; i++) {
			compare[i] = br.readLine();
		}
		
		for(int i=0; i<M; i++) {
			String a = br.readLine();
			stCount(a);
		}
		
		System.out.println(count);
		
		br.close();
	}

	public static int stCount(String val) {
		for(int i=0; i<N; i++) {
			if(val.equals(compare[i])) {
				count++;
			}
		}
		return count;
	}
}
