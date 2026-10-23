class Solution {
    public boolean isPalindrome(String s) {
        // Logic
        // 1. Convert to lower case
        // 2. Only keep a-z and 0-9 chars
        // 3. Then check palindrome using 2 pointers

        StringBuilder newStr = new StringBuilder();
        for(int i=0; i<=s.length()-1; i++){
            char ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                newStr.append((char)(ch + 32));
            }else if(ch >= 'a' && ch <= 'z') {
                newStr.append(ch);
            }else if(ch >= '0' && ch <= '9'){
                newStr.append(ch);
            }
        }

        int start=0;
        int end = newStr.length()-1;
        
        while(start < end){
            if(newStr.charAt(start) != newStr.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
