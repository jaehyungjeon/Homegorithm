package programmers.Level2.AdoptTime;

/*
	Question : ANIMAL_OUTS 테이블은 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블입니다. 
	ANIMAL_OUTS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME는 각각 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부를 나타냅니다.

	NAME	TYPE	NULLABLE
	ANIMAL_ID	VARCHAR(N)	FALSE
	ANIMAL_TYPE	VARCHAR(N)	FALSE
	DATETIME	DATETIME	FALSE
	NAME	VARCHAR(N)	TRUE
	SEX_UPON_OUTCOME	VARCHAR(N)	FALSE
	보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다. 09:00부터 19:59까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문을 작성해주세요. 
	이때 결과는 시간대 순으로 정렬해야 합니다.

	Solution : 1. BETWEEN 함수 및 GROUP BY 적용
			   2. LTRIM을 이용하여 왼쪽 0은 제거해준다 -> Key Point
*/

public class Solution {
	SELECT LTRIM(TO_CHAR(DATETIME, 'HH24'), 0) AS HOUR,
    	   COUNT(*) AS COUNT
	FROM ANIMAL_OUTS
	WHERE TO_CHAR(DATETIME, 'HH24MI') BETWEEN '0900' AND '1959'
	GROUP BY TO_CHAR(DATETIME, 'HH24')
	ORDER BY TO_CHAR(DATETIME, 'HH24')
}
