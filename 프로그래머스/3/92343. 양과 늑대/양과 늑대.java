import java.util.*;

class Solution {
    static ArrayList<Integer>[] adjList;
    static int[] infoArray;
    static int maxSheep = 0; // 정답을 기록할 변수

    public int solution(int[] info, int[][] edges) {
        int N = info.length;
        infoArray = info; // dfs에서 편하게 쓰려고 static으로 카피
        
        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
        }
        
        // 다음에 갈 수 있는 후보들을 담을 리스트
        List<Integer> nextNodes = new ArrayList<>();
        // 루트 노드의 자식들을 첫 후보로 등록
        for (int child : adjList[0]) {
            nextNodes.add(child);
        }
        
        // 루트(0번)는 무조건 양(0)이니까 양 1마리, 늑대 0마리로 시작
        dfs(0, 1, 0, nextNodes);
        
        return maxSheep;
    }

    private static void dfs(int node, int sheep, int wolf, List<Integer> nextNodes) {
        // 1. 현재 상태의 양의 최댓값 갱신
        maxSheep = Math.max(maxSheep, sheep);
        
        // 2. 현재 갈 수 있는 후보 노드들을 하나씩 탐색
        for (int i = 0; i < nextNodes.size(); i++) {
            int next = nextNodes.get(i);
            
            // 다음 노드가 양인지 늑대인지 판별
            int nextSheep = sheep + (infoArray[next] == 0 ? 1 : 0);
            int nextWolf = wolf + (infoArray[next] == 1 ? 1 : 0);
            
            // 늑대가 양과 같아지거나 많아지면 잡아먹히므로 스킵 (가지치기)
            if (nextWolf >= nextSheep) continue;
            
            List<Integer> makeNext = new ArrayList<>(nextNodes);
            makeNext.remove(i); // 방문할 예정인 자기 자신은 후보에서 제외
            
            for (int child : adjList[next]) {
                makeNext.add(child);
            }
            
            dfs(next, nextSheep, nextWolf, makeNext);
        }
    }
}