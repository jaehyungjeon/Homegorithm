package programmers.Level1.SpecialCar;

/*
	Question : CAR_RENTAL_COMPANY_CAR 테이블에서 '네비게이션' 옵션이 포함된 자동차 리스트를 출력하는 SQL문을 작성해주세요. 결과는 자동차 ID를 기준으로 내림차순 정렬해주세요.
	
	Solution : 1. 조건을 잘 맞춰주면 되는 문제
*/

public class Solution {
	SELECT *
	FROM CAR_RENTAL_COMPANY_CAR
	WHERE OPTIONS LIKE '%네비게이션%'
	ORDER BY CAR_ID DESC
}
