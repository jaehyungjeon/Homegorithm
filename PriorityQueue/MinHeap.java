package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


/*
	Question : �θ� �� �˷��� �ڷᱸ�� �� �ּ� ���� �ִ�. �ּ� ���� �̿��Ͽ� ������ ���� ������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	�迭�� �ڿ��� x�� �ִ´�.
	�迭���� ���� ���� ���� ����ϰ�, �� ���� �迭���� �����Ѵ�.
	���α׷��� ó���� ����ִ� �迭���� �����ϰ� �ȴ�.
	
	input			 
	9
	0
	12345678
	1
	2
	0
	0
	0
	0
	32
	
	output
	0
	1
	2
	12345678
	0
*/

public class MinHeap { // MAX Heap�� Reverse ����
	//�������� �迭�� ���� ���� ������� input�Ǵ� ���� ������ ������ �ٷ� �����Ͽ� ���ϴ� ���� �޸� �̽��� ������ ������ �Ǵ�. 

	public static PriorityQueue<Integer> q = new PriorityQueue<>(); // �켱ť�� default ��������
	public static int N; // ���� ��� ������ �������� ���� ���� 
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input == 0) {
//				sb.append(q.isEmpty() ? 0 : q.poll()).append("\n");
				if(q.isEmpty()) {
					System.out.println("0");
				} else {
					System.out.println(q.poll());
				}
			} else {
				q.add(input);
			}
		}
		
//		System.out.println(sb.toString());
	}
}
