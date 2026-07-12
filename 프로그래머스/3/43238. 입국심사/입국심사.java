import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1; // 최소 1분은 걸리므로 1로 시작해도 좋습니다.
        
        // times 배열에서 가장 큰 값을 찾기 위해 정렬하거나 스트림을 사용합니다.
        // 여기서는 가장 직관적인 정렬(Arrays.sort)을 사용해 마지막 원소를 가져왔습니다.
        Arrays.sort(times);
        long right = (long) times[times.length - 1] * n; 
        
        long answer = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            long canTest = 0;
            for (int t : times) {
                canTest += mid / t;
            }
            
            // n명 이상을 심사할 수 있는 경우 (시간을 줄여봄)
            if (canTest >= n) {
                answer = mid;
                right = mid - 1;
            } 
            // n명 미만만 심사할 수 있는 경우 (시간이 더 필요함)
            else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}