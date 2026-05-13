import java.util.*;

class Solution{
    public int solution(String s){
        Stack <Character> st = new Stack<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(st.size()==0) st.push(ch);
            else if(st.size()>0){
                char tmpChar = st.pop();
                if(tmpChar!=ch){
                    st.push(tmpChar);
                    st.push(ch);
                }
            }
        }

        if (st.size()==0) return 1;
        return 0;
    }//main
}//class