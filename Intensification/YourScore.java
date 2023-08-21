package Intensification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 인하대학교 컴퓨터공학과를 졸업하기 위해서는, 전공평점이 3.3 이상이거나 졸업고사를 통과해야 한다. 그런데 아뿔싸, 치훈이는 깜빡하고 졸업고사를 응시하지 않았다는 사실을 깨달았다!

	치훈이의 전공평점을 계산해주는 프로그램을 작성해보자.
	
	전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.
	
	인하대학교 컴퓨터공학과의 등급에 따른 과목평점은 다음 표와 같다.
	
	A+	4.5
	A0	4.0
	B+	3.5
	B0	3.0
	C+	2.5
	C0	2.0
	D+	1.5
	D0	1.0
	F	0.0
	P/F 과목의 경우 등급이 P또는 F로 표시되는데, 등급이 P인 과목은 계산에서 제외해야 한다.
	
	과연 치훈이는 무사히 졸업할 수 있을까?
	
	input			 
	ObjectOrientedProgramming1 3.0 A+
	IntroductiontoComputerEngineering 3.0 A+
	ObjectOrientedProgramming2 3.0 A0
	CreativeComputerEngineeringDesign 3.0 A+
	AssemblyLanguage 3.0 A+
	InternetProgramming 3.0 B0
	ApplicationProgramminginJava 3.0 A0
	SystemProgramming 3.0 B0
	OperatingSystem 3.0 B0
	WirelessCommunicationsandNetworking 3.0 C+
	LogicCircuits 3.0 B0
	DataStructure 4.0 A+
	MicroprocessorApplication 3.0 B+
	EmbeddedSoftware 3.0 C0
	ComputerSecurity 3.0 D+
	Database 3.0 C+
	Algorithm 3.0 B0
	CapstoneDesigninCSE 3.0 B+
	CompilerDesign 3.0 D0
	ProblemSolving 4.0 P
	
	output
	3.284483
	
	Solution : 1. 수학으로 계산해주면 됨.
			   2. 과목명은 필요없고, (학점 * 평점) / 전체학점으로 계산
			   3. 마지막 소숫점 6자리까지 뽑기 위해서 String.format 사용
*/


public class YourScore {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double answer = 0.0;
		double sum = 0.0;
		for(int i=0; i<20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			double score = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			
			switch(grade) {
				case "A+" :
					answer += (score * 4.5);
					sum += score;
					break;
				case "A0" :
					answer += (score * 4.0);
					sum += score;
					break;
				case "B+" : 
					answer += (score * 3.5);
					sum += score;
					break;
				case "B0" :
					answer += (score * 3.0);
					sum += score;
					break;
				case "C+" :
					answer += (score * 2.5);
					sum += score;
					break;
				case "C0" :
					answer += (score * 2.0);
					sum += score;
					break;
				case "D+" :
					answer += (score * 1.5);
					sum += score;
					break;
				case "D0" :
					answer += (score * 1.0);
					sum += score;
					break;
				case "F" :
					answer += (score * 0.0);
					sum += score;
					break;
				case "P" :
					break;
					
			}
		}
		
		br.close();
		System.out.println(String.format("%.6f", answer/sum));
	}

}
