package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
	Question : �θ� �� �˷��� �ڷᱸ�� �� �ִ� ���� �ִ�. �ִ� ���� �̿��Ͽ� ������ ���� ������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	�迭�� �ڿ��� x�� �ִ´�.
	�迭���� ���� ū ���� ����ϰ�, �� ���� �迭���� �����Ѵ�.
	���α׷��� ó���� ����ִ� �迭���� �����ϰ� �ȴ�.

	input			 
	13
	0
	1
	2
	0
	0
	3
	2
	1
	0
	0
	0
	0
	0
	
	output
	0
	2
	1
	3
	2
	1
	0
	0
*/

public class MaxHeap {

	public static PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder()); // ������ �켱���� ť(�� ���� �������� ����)
	public static int N; // ���� ��� ������ �������� ���� ����
	public static int[] arr; // ���� ���� ��� �迭
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // ��� ���
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N]; // �迭 ����
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			if(arr[i] == 0) {
				sb.append(q.size() == 0 ? 0 : q.poll()).append("\n"); // �������� ���� ��, 0�� ��� ť���� ���� �̾Ƴ�
			} else {
				q.add(arr[i]);
			}
		}
		
		System.out.println(sb.toString());
	}

}
