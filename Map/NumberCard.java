package Map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	Question : ���� ī��� ���� �ϳ��� ������ �ִ� ī���̴�.
	����̴� ���� ī�� N���� ������ �ִ�. ���� M���� �־����� ��, �� ���� �����ִ� ���� ī�带 ����̰� ������ �ִ��� �ƴ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	input			 
	5
	6 3 2 10 -10
	8
	10 9 -5 2 3 4 5 -10
	
	output
	1 0 0 1 1 0 0 1
	
	Solution : ���� ������ �迭�� �� ��ŭ �����͸� �޾� ���ϴ� �������� �����Ϸ� ������, �����͸� �����Ҽ��� �ð��� �޸� �ҿ䰡 Ŀ��
			   ����� �Ŀ� �޴� ����ŭ ���� �Ǿ�� �ϹǷ� 8���� ����ŭ for�� ����
			   ���� ��ġ�� ���, writer�� 1�� �߰� �ƴҰ�� 0�� �߰�
			   �񱳸� ��� �� ���ΰ��� ���� �ǹ�... -> ������������ ������ �� ����Ž������ ������ �ٿ������鼭 ã�� ���� ���� ����
			   ���� Ž���� ���� ��ġ �� ��� true, ��ġ���� ���� ��� false ��ȯ
			   t/f�� ���߾� writer�� �� write
*/

public class NumberCard {

	public static int N, M;
	public static int[] cardArr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		cardArr = new int[N];
		
		StringTokenizer sc = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cardArr[i] = Integer.parseInt(sc.nextToken());
		}
		
		Arrays.sort(cardArr); // �������� ����
		M = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(BinarySearch(num)) bw.write("1 ");
			else bw.write("0 ");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		System.out.println(bw);
	}
	
	public static boolean BinarySearch(int num) {
		int start = 0;
		int end = N - 1;
		
		while(start <= end) {
			int center = (start + end) / 2;
			int centerValue = cardArr[center];
			
			if(num < centerValue) {
				end = center - 1;
			} else if(num > centerValue) {
				start = center + 1;
			} else {
				return true;
			}
		}
		
		return false; 
	}
}
