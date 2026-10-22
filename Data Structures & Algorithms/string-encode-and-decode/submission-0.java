class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0){
            return "";
        }

        StringBuilder strBuilder = new StringBuilder();

        // Append size of strs
        for(String str : strs){
            strBuilder.append(str.length());
            strBuilder.append(",");
        }
        strBuilder.append("#");
        
        // Append str from strs
        for(String str : strs){
            strBuilder.append(str);
        }

        return strBuilder.toString();
    }

    public List<String> decode(String str) {
        if(str == ""){
            return new ArrayList<>();
        }

        List<Integer> sizes = new ArrayList<>();
        String charString = new String();
        int startIndex = 0;
        for(int i=0; i<=str.length()-1; i++){
            char ch = str.charAt(i);
            if(ch == '#'){
                charString = str.substring(i+1);
                break;
            }

            if(ch == ','){
                String extractNum = str.substring(startIndex, i);
                startIndex = i+1;
                sizes.add(Integer.parseInt(extractNum));
            }
        }

        int start = 0;
        List<String> resultant = new ArrayList<>();
        for(int size : sizes){
            if(size == 0){
                resultant.add("");
            }else{        
                // * Calculate end = start + size.
                // * Extract charString.substring(start, end).
                // * Add the extracted string to your result.
                // * Update start = end.
                int end = start+size;
                String tempStr = charString.substring(start, end);
                resultant.add(tempStr);
                start = end;
            }
        }

        return resultant;
    }
}
