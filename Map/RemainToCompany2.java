package Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/*
	Question : 상근이는 세계적인 소프트웨어 회사 기글에서 일한다. 이 회사의 가장 큰 특징은 자유로운 출퇴근 시간이다. 따라서, 직원들은 반드시 9시부터 6시까지 회사에 있지 않아도 된다.

	각 직원은 자기가 원할 때 출근할 수 있고, 아무때나 퇴근할 수 있다.
	
	상근이는 모든 사람의 출입카드 시스템의 로그를 가지고 있다. 이 로그는 어떤 사람이 회사에 들어왔는지, 나갔는지가 기록되어져 있다. 로그가 주어졌을 때, 현재 회사에 있는 모든 사람을 구하는 프로그램을 작성하시오.
	
	input			 
	4
	Baha enter
	Askar enter
	Baha leave
	Artem enter
	
	output
	Askar
	Artem
	
	Solution : 1. Map과 ReverseOrder를 활용하였다.
	 		   2. 이것도 정답으로 처리되었다.

*/

public class RemainToCompany2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, String> map = new HashMap<String, String>();
		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String condition = st.nextToken();
			
			if(condition.equals("enter")) {
				map.put(name, condition);
			} else if(condition.equals("leave")) {
				map.remove(name);
			}
		}
		
		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list, Comparator.reverseOrder());
		
		list.stream().forEach(o -> {
			System.out.println(o);
		});
	}
}
