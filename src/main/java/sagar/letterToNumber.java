class letterToNumber {
    public List<String> letterCombinations(String digits) {
        String[] numberToDigit = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans = new ArrayList<>();
        populateAllCombos(digits,numberToDigit,0,ans,"");
        return ans;
    }
    
    public void populateAllCombos(String digits,String[] numToD,int i,List<String> storage,String temp) {
        if(i>=digits.length()) {
            if(temp!="")
        storage.add(temp);
            return;
        }
        int index = digits.charAt(i)-'0';
        for(int k=0;k<numToD[index].length();k++) {
            populateAllCombos(digits,numToD,i+1,storage,temp+numToD[index].charAt(k));
        }
    }
}
