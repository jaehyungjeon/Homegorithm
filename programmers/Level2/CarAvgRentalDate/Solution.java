package programmers.Level2.CarAvgRentalDate;

/*
	Question : CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 평균 대여 기간이 7일 이상인 자동차들의 자동차 ID와 
	평균 대여 기간(컬럼명: AVERAGE_DURATION) 리스트를 출력하는 SQL문을 작성해주세요. 
	평균 대여 기간은 소수점 두번째 자리에서 반올림하고, 결과는 평균 대여 기간을 기준으로 내림차순 정렬해주시고, 평균 대여 기간이 같으면 자동차 ID를 기준으로 내림차순 정렬해주세요.

	Solution : 1. CASE문 사용
*/

public class Solution {
	SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, 
    (CASE WHEN STATUS = 'SALE' THEN '판매중'
          WHEN STATUS = 'RESERVED' THEN '예약중'
          ELSE '거래완료' END) AS STATUS
	FROM USED_GOODS_BOARD
	WHERE TO_CHAR(CREATED_DATE, 'YYYYMMDD') = '20221005'
	ORDER BY BOARD_ID DESC
}
