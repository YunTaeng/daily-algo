import java.util.*;
import java.io.*;

class Solution {
	class Node{
    	int index,x,y;
        Node left, right;
        
        public Node(int index,int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
            left = right = null;
        }
    }
	
	Node insert(Node root, Node newNode) {
		if (root == null) return newNode;
	    if (newNode.x < root.x) {
	        root.left = insert(root.left, newNode);
	    } else {
	        root.right = insert(root.right, newNode);
	    }
	    return root;
    }
	
    public int[][] solution(int[][] nodeinfo) {
        
        
        int N=nodeinfo.length;
        
        Node[] NodeArr = new Node[N];
        
        for(int i=0;i<N;i++) {
        	NodeArr[i]=new Node(i,nodeinfo[i][0],nodeinfo[i][1]);
        }
        
        Arrays.sort(NodeArr, (a, b) -> {//노드 정렬
            if (a.y != b.y) {
                return b.y - a.y;
            }
            return a.x - b.x;  
        });
        Node root = NodeArr[0];
        for(int i=1;i<N;i++) {
        	insert(root, NodeArr[i]);
        }
        
        preOrder(root);
        postOrder(root);
        
        int[][] answer = new int[2][N];
        for (int i = 0; i < N; i++) {
            answer[0][i] = preList.get(i);
            answer[1][i] = postList.get(i);
        }
        return answer;
    
    }
    
    static List<Integer> preList = new ArrayList<>();
    static List<Integer> postList = new ArrayList<>();
    private void preOrder(Node root) {
        preList.add(root.index + 1);
        if (root.left != null) preOrder(root.left);
        if (root.right != null) preOrder(root.right);
    }
    
    private void postOrder(Node root) {
        if (root.left != null) postOrder(root.left);
        if (root.right != null) postOrder(root.right);
        postList.add(root.index + 1);
    }
    
    
    
    
    
}//sol