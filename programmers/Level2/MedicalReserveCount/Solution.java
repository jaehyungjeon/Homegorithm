package programmers.Level2.MedicalReserveCount;

/*
	Question : APPOINTMENT 테이블에서 2022년 5월에 예약한 환자 수를 진료과코드 별로 조회하는 SQL문을 작성해주세요. 
	이때, 컬럼명은 '진료과 코드', '5월예약건수'로 지정해주시고 결과는 진료과별 예약한 환자 수를 기준으로 오름차순 정렬하고, 예약한 환자 수가 같다면 진료과 코드를 기준으로 오름차순 정렬해주세요.
	
	Solution : 1. alias 사용할 때 큰따옴표 사용 유의할 것. 
*/

public class Solution {
	SELECT MCDP_CD AS "진료과코드",
    	   COUNT(MCDP_CD) AS "5월예약건수"
	FROM APPOINTMENT
	WHERE TO_CHAR(APNT_YMD, 'YYYYMM') = '202205'
	GROUP BY MCDP_CD
	ORDER BY COUNT(MCDP_CD), MCDP_CD
}
