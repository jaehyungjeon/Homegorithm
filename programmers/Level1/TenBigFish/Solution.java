package programmers.Level1.TenBigFish;

/*
	Question : FISH_INFO 테이블에서 가장 큰 물고기 10마리의 ID와 길이를 출력하는 SQL 문을 작성해주세요.
	결과는 길이를 기준으로 내림차순 정렬하고, 길이가 같다면 물고기의 ID에 대해 오름차순 정렬해주세요. 단, 가장 큰 물고기 10마리 중 길이가 10cm 이하인 경우는 없습니다.

	ID 컬럼명은 ID, 길이 컬럼명은 LENGTH로 해주세요.
	
	Solution : 1. MY_SQL 전용 문제
			   2. DENSE_RANK로 RANKING을 구하고 바깥에서 개수만큼 추출하도록 구현함.
*/

public class Solution {
	SELECT T.ID, T.LENGTH
	FROM (SELECT DENSE_RANK() OVER(ORDER BY LENGTH DESC, ID ASC) AS RANKING,
	        ID,
	        LENGTH
	FROM FISH_INFO
	) T
	WHERE T.RANKING <= 10
}
