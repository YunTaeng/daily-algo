import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int N = citations.length;
        Integer[] arr = new Integer[N];
        for(int i=0;i<N;i++){
            arr[i]=citations[i];
        }
        Arrays.sort(arr, Collections.reverseOrder());
        
        for (int i =0; i<N;i++) {
        	if (arr[i] < i + 1)
                return i;
        	
        }
        return N;
    }
}