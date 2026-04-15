import java.util.*;
import java.io.*;

public class Main{
	public static int N;
	public static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        //Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int max = Math.max(N, M);
        int[][] inMap = new int[max][max];
        
		
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++){
                inMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int tilt=0;
        int[][] outMap = new int[max][max];
        st = new StringTokenizer(br.readLine());
        while(K-- > 0){
        	int midN = N / 2;
            int midM = M / 2;
            int num = Integer.parseInt(st.nextToken());
            outMap = new int[max][max];
            switch(num) {
            	case 1:{
            		for (int i=0;i<N;i++){
                        for (int j=0;j<M;j++){
                            outMap[N-1-i][j]=inMap[i][j];
                        }
                    }
            		break;
            	}//case1 상하반전 end
            	
            	case 2:{
            		for (int i=0;i<N;i++){
                        for (int j=0;j<M;j++){
                            outMap[i][M-1-j]=inMap[i][j];
                        }
                    }
            		break;
            	}//case2 좌우반전 end
            	
            	case 3:{
            		for (int i=0;i<N;i++){
                        for (int j=0;j<M;j++){
                            outMap[j][N-1-i]=inMap[i][j];
                        }
                    }
            		int temp = N; N = M; M = temp; // 즉시 스왑
            		tilt++;//회전
            		break;
            	}//case3 왼쪽90회전 end
            	
            	case 4:{
            		for (int i=0;i<N;i++){
                        for (int j=0;j<M;j++){
                            outMap[M-1-j][i]=inMap[i][j];
                        }
                    }
            		int temp = N; N = M; M = temp; // 즉시 스왑
            		tilt++;//회전
            		break;
            	}//case4 오른쪽90회전 end
            	
            	case 5:{
            		for (int i=0;i<midN;i++){
                        for (int j=0;j<midM;j++){
                            outMap[i][j+midM]=inMap[i][j];
                            outMap[i+midN][j+midM]=inMap[i][j+midM];
                            outMap[i+midN][j]=inMap[i+midN][j+midM];
                            outMap[i][j]=inMap[i+midN][j];
                        }
                    }
            		break;
            	}//case5 블록 시계방향회전 end
            	
            	case 6:{
            		for (int i=0;i<midN;i++){
                        for (int j=0;j<midM;j++){
                            outMap[i+midN][j]=inMap[i][j];
                            outMap[i+midN][j+midM]=inMap[i+midN][j];
                            outMap[i][j+midM]=inMap[i+midN][j+midM];
                            outMap[i][j]=inMap[i][j+midM];
                        }
                    }
            		break;
            	}//case5 블록 시계방향회전 end
            	
            }//switch end
            inMap=outMap;
            
        }//while end
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                System.out.printf("%d ",outMap[i][j]);
            }
            System.out.println("");
        }
		
		
		
		br.close();
	}//main
	
}//배열돌리기3