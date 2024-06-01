package programmers.Level1.CarRentalDivide;

/*
	Question : CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 대여 시작일이 2022년 9월에 속하는 대여 기록에 대해서 대여 기간이 30일 이상이면 '장기 대여' 
	그렇지 않으면 '단기 대여' 로 표시하는 컬럼(컬럼명: RENT_TYPE)을 추가하여 대여기록을 출력하는 SQL문을 작성해주세요. 결과는 대여 기록 ID를 기준으로 내림차순 정렬해주세요.
	
	Solution : 1. 빌린 날짜도 일자로 포함되므로 29이상으로 측정해주어야 한다..!
*/

public class Solution {
	SELECT HISTORY_ID, 
    CAR_ID,
    TO_CHAR(START_DATE, 'YYYY-MM-DD') AS START_DATE,
    TO_CHAR(END_DATE, 'YYYY-MM-DD') AS END_DATE,
     CASE WHEN END_DATE - START_DATE >= 29 THEN '장기 대여'
          ELSE '단기 대여' END AS RENT_TYPE
	FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
	WHERE TO_CHAR(START_DATE, 'YYYYMM') = '202209'
	ORDER BY HISTORY_ID DESC
}
