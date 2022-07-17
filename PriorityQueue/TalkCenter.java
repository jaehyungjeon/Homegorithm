package PriorityQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

/*
	Question : �����̴� �������� "����� ���ؿ�" ������ �������ְ� �ִ�. �����̰� ������ �ϳ��� ��ĥ������ ������ ���ݱ��� �����̰� ���� �� �߿��� �߰����� ���ؾ� �Ѵ�.
	����, �׵��� �����̰� ��ģ ���� ������ ¦������� �߰��� �ִ� �� �� �߿��� ���� ���� ���ؾ� �Ѵ�.
	���� ��� �����̰� �������� 1, 5, 2, 10, -99, 7, 5�� ������� ���ƴٰ� �ϸ�, ������ 1, 1, 2, 2, 2, 2, 5�� ���ʴ�� ���ؾ� �Ѵ�.
	�����̰� ��ġ�� ���� �־����� ��, ������ ���ؾ� �ϴ� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	input			 
	7
	1
	5
	2
	10
	-99
	7
	5
	
	output
	1
	1
	2
	2
	2
	2
	5
*/

public class TalkCenter {

	public static int N;
	public static PriorityQueue<Integer> minQueue = new PriorityQueue<>(); 
	public static PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // BufferedWrite�� �ӵ� ���
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine()); // ������ ��
			
			if(minQueue.size() == maxQueue.size()) {
				maxQueue.offer(num);
			} else {
				minQueue.offer(num);
			}
			
			if(!minQueue.isEmpty() && !maxQueue.isEmpty()) {
				if(minQueue.peek() < maxQueue.peek()) {
					minQueue.offer(maxQueue.poll());
					maxQueue.offer(minQueue.poll());
				}
			}
			
			bw.write(maxQueue.peek() + "\n");
//			System.out.println(maxQueue.peek()); // �ð��ʰ�...
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
