package programmers.Level1.FishCount;

/*
	Question : 잡은 물고기 중 길이가 10cm 이하인 물고기의 수를 출력하는 SQL 문을 작성해주세요.
	물고기의 수를 나타내는 컬럼 명은 FISH_COUNT로 해주세요.
	
	Solution : 1. NULL 조건만 탐색
*/

public class Solution {
	SELECT COUNT(*) AS FISH_COUNT FROM FISH_INFO
	WHERE LENGTH IS NULL
}
