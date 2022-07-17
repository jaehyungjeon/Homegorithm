package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
	Question : ���� ���� ������ ���� ������ �����ϴ� �ڷᱸ���̴�.
	�迭�� ���� x (x �� 0)�� �ִ´�.
	�迭���� ������ ���� ���� ���� ����ϰ�, �� ���� �迭���� �����Ѵ�. ������ ���� ���� ���� �������� ����, ���� ���� ���� ����ϰ�, �� ���� �迭���� �����Ѵ�.
	���α׷��� ó���� ����ִ� �迭���� �����ϰ� �ȴ�.

	input			 
	18
	1
	-1
	0
	0
	0
	1
	1
	-1
	-1
	2
	-2
	0
	0
	0
	0
	0
	0
	0

	output
	-1
	1
	0
	-1
	-1
	1
	1
	-2
	2
*/

class Abs implements Comparable<Abs> {
	int num; // �Ϲ� ����
	int abs; // ���� ��
	
	Abs(int num){
		this.num = num;
		this.abs = Math.abs(num);
	}
	
	@Override
	public int compareTo(Abs a) {
		if(this.abs == a.abs) { // ������ ���� ������ ������
			return this.num - a.num; // �Ϲ� ���� ��������
		}
		
		return this.abs - a.abs; // �⺻������ ���밪 �켱������ ��������
	}
}

public class AbsHeap {

	public static PriorityQueue<Abs> q = new PriorityQueue<Abs>();
	public static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int value = Integer.parseInt(br.readLine());
			
			if(value == 0) {
				if(q.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(q.poll().num);
				}
			} else {
				q.add(new Abs(value));
			}
		}
	}

}
