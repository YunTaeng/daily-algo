import java.io.*;
import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        int cnt=0;
        List<Integer> arr = new ArrayList<>();
        arr.add(k);
        while (k > 1) {
            if (k % 2 == 0) k /= 2;
            else k = k * 3 + 1;
            arr.add(k);
        }
        
        int N = arr.size()-1;
        double [] area = new double[N];
        
        
        
        for (int i = 0; i < N; i++) {
            area[i] = (arr.get(i) + arr.get(i + 1)) / 2.0;
        }

        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = N + ranges[i][1];
            
            if (start > end) {
                answer[i] = -1.0;
            } else {
                double total = 0;
                for (int j = start; j < end; j++) {
                    total += area[j];
                }
                answer[i] = total;
            }
        }
        
        
        return answer;
    }
}