package programmers.Level2.FindMarchBirthWoman;

/*
	Question : MEMBER_PROFILE 테이블에서 생일이 3월인 여성 회원의 ID, 이름, 성별, 생년월일을 조회하는 SQL문을 작성해주세요. 
	이때 전화번호가 NULL인 경우는 출력대상에서 제외시켜 주시고, 결과는 회원ID를 기준으로 오름차순 정렬해주세요.

	Solution : 1. 단순 조건문제
*/

public class Solution {
	SELECT MEMBER_ID, MEMBER_NAME, GENDER, TO_CHAR(DATE_OF_BIRTH, 'YYYY-MM-DD') AS DATE_OF_BIRTH
	FROM MEMBER_PROFILE
	WHERE GENDER = 'W'
	AND TO_CHAR(DATE_OF_BIRTH, 'MM') = '03'
	AND TLNO IS NOT NULL
	ORDER BY MEMBER_ID
}
