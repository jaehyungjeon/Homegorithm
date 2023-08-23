package Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
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
	
	Solution : 1. HashSet과 Compartor 재정의를 통하여 구하였다.
	 		   2. 런타임 에러가 계속 났었는데.. set 안에서 for문을 돌려 같은 String이 있는 경우에 제거하려는 로직을 반영해서 소요시간이 늘었다.
	 		   3. 어차피 remove를 했을때 없으면 지워지지 않을 것이기 때문에 과감하게 로직 삭제하였다.
	 		   4. 다음 프로젝트에 Map을 활용하여 구해보도록 하겠다.
	 		   5. Collection Util에 ReverseOrder도 있으니 그걸 활용하는게 편할 듯..?

*/

public class RemainToCompany {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> set = new HashSet<String>();
		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String condition = st.nextToken();
			
			if(condition.equals("enter")) {
				set.add(name);
			} else if(condition.equals("leave")) {
				set.remove(name);
			}
		}
		
		List<String> list = new ArrayList<>(set);
		Collections.sort(list, new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				if(o1.compareTo(o2) < 0) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		
		for(String str : list) {
			System.out.println(str);
		}
	}
}
