class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int remainder = storey % 10; // 현재 일의 자리 숫자
            int next = (storey / 10) % 10; // 다음 십의 자리 숫자
            
            if (remainder > 5) {
                answer += (10 - remainder);
                storey += 10;
            } 
            else if (remainder < 5) {
                answer += remainder;
            } 
            else {// 5일 때
                if (next >= 5) {
                    answer += (10 - remainder);
                    storey += 10; // 다음 자리가 5 이상이면 같이 올림
                } else {
                    answer += remainder; // 다음 자리가 4 이하면 내림
                }
            }
            
            // 다음 자리수로 이동
            storey /= 10;
        }
        
        return answer;
    }
}