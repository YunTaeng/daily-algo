class Solution {
    static int cnt0=0;
	static int cnt1=0;
    public int[] solution(int[][] arr) {
        int N = arr.length;
        divcon(0,0,N,arr);
        return new int[] {cnt0,cnt1};
    }
    private static void divcon(int x, int y,int N,int[][] arr) {
		// 1. 더 이상 나눌 수 없을 만큼 작아지면 정복 (Base Case)
		if(N==1) {
			if(arr[x][y]==0) cnt0++;
			if(arr[x][y]==1) cnt1++;
			return;
		}
		
		int tmpsum=0;
		for (int i=x;i<x+N;i++) {
			for (int j=y;j<y+N;j++) {
				tmpsum+=arr[i][j];
			}
		}
		if(tmpsum==0) {
			cnt0+=1;
			return;
		}
		if(tmpsum==N*N) {
			cnt1+=1;
			return;
		}
		
	    // 2. 분할 (Divide)
		
		
	    // 3. 재귀적으로 해결 및 합치기 (Conquer & Combine)
		divcon(x,y,N/2,arr);
		divcon(x,y+N/2,N/2,arr);
		divcon(x+N/2,y,N/2,arr);
		divcon(x+N/2,y+N/2,N/2,arr);
	}
}