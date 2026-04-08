class Solution {
    public String solution(String str1, String str2) {
        char[] ansArr = new char[str1.length() + str2.length()];
        
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        
        for (int i = 0; i < str1.length(); i++) {
            ansArr[i * 2] = charArr1[i];
            ansArr[i * 2 + 1] = charArr2[i];
        }
        
        return new String(ansArr);
    }
}