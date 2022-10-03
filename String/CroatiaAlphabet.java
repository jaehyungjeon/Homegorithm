package String;

import java.util.*;
import java.io.*;

/*
	Question : 예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.

	크로아티아 알파벳	변경
	č	c=
	ć	c-
	dž	dz=
	đ	d-
	lj	lj
	nj	nj
	š	s=
	ž	z=
	
	예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
	dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.

	input			 
	ljes=njak
	
	output
	6
	
	Solution : 케이스 별로 지정해주고 해당 케이스 조건에 일치하면 그만큼 str을 밀어서 판정한다. 그러면서 사이클이 끝날 때 마다 count++ 실시
*/

public class CroatiaAlphabet {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
				
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == 'c') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == '=') {
						i++;
					} else if(str.charAt(i + 1) == '-') {
						i++;
					}	
				}
			}
			
			else if(c == 'd') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == 'z') {
						if(i < str.length() - 2) {
							if(str.charAt(i + 2) == '=') {
								i += 2;
							}
						}
					} else if(str.charAt(i + 1) == '-') {
						i++;
					}
				}
			}
			
			else if(c == 'l' || c == 'n') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == 'j') {
						i++;
					}
				}
			}
			
			else if(c == 's' || c == 'z') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == '=') {
						i++;
					}
				}
			}
			
			count++;
		}
		
		System.out.println(count);
	}
}