class Solution {
    public int solution(int[] money) {
        int N = money.length;
        if (N == 1) return money[0];
        
        // 1. 첫 번째 집을 터는 경우 (마지막 집 제외: 0 ~ N-2)
        int case1 = getMax(money, 0, N - 2);
        
        // 2. 첫 번째 집을 안 터는 경우 (마지막 집 포함: 1 ~ N-1)
        int case2 = getMax(money, 1, N - 1);
        
        return Math.max(case1, case2);
    }
    
    private int getMax(int[] money, int start, int end) {
        int prevPrev = 0; // i-2
        int prev = 0;     // i-1
        int current = 0;  // i
        
        for (int i = start; i <= end; i++) {
            // 현재 집을 털 것인가, 말 것인가!
            current = Math.max(prev, prevPrev + money[i]);
            
            // 다음 칸으로 이동하기 위해 값 밀어주기
            prevPrev = prev;
            prev = current;
        }
        
        return current;
    }
}