class Solution {
    public int solution(int[][] sizes) {
        int maxLong = 0;
        int maxShort = 0;

        for (int[] card : sizes) {
            int currentMax = Math.max(card[0], card[1]);
            int currentMin = Math.min(card[0], card[1]);

            if (currentMax > maxLong) maxLong = currentMax;
            if (currentMin > maxShort) maxShort = currentMin;
        }

        return maxLong * maxShort;
    }
}