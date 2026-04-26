def solution(s):
    st = list()
    i=0
    for c in s:
        if(c=='('):
            st.append(c)
        if(c==')'):
            try:
                st.pop()
            except IndexError:
                return False
    return len(st)==0