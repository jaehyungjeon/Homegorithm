package programmers.Level1.AverageRentalFee;

/*
	Question : 다음은 어느 자동차 대여 회사에서 대여중인 자동차들의 정보를 담은 CAR_RENTAL_COMPANY_CAR 테이블입니다. 
	CAR_RENTAL_COMPANY_CAR 테이블은 아래와 같은 구조로 되어있으며, CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS 는 각각 자동차 ID, 자동차 종류, 일일 대여 요금(원), 자동차 옵션 리스트를 나타냅니다.

	Column name	Type	Nullable
	CAR_ID	INTEGER	FALSE
	CAR_TYPE	VARCHAR(255)	FALSE
	DAILY_FEE	INTEGER	FALSE
	OPTIONS	VARCHAR(255)	FALSE
	자동차 종류는 '세단', 'SUV', '승합차', '트럭', '리무진' 이 있습니다. 
	자동차 옵션 리스트는 콤마(',')로 구분된 키워드 리스트(예: '열선시트', '스마트키', '주차감지센서')로 되어있으며, 
	키워드 종류는 '주차감지센서', '스마트키', '네비게이션', '통풍시트', '열선시트', '후방카메라', '가죽시트' 가 있습니다.
	
	Solution : 1. ROUND 함수와 AVG를 이용한 구현 
*/

public class Solution {
	SELECT ROUND(AVG(DAILY_FEE), 0) AS AVERAGE_FEE
	FROM CAR_RENTAL_COMPANY_CAR
	WHERE CAR_TYPE = 'SUV'
}
