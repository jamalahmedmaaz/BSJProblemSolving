class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int l=s.length();
        if(l<1) return "";
        int[][] dp = new int[l][l];
        
        int maxLength=1,start=0;
        for(int i=0;i<l;i++) {
            dp[i][i]=1;
        }
        for(int i=0;i<l-1;i++) {
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=1;
                start=i;
                maxLength=2;
            }
        }
        for(int i=3;i<=l;i++) {
            for(int j=0;j<l-i+1;j++) {
                int index = j+i-1;
                if(index<l && dp[j+1][index-1]==1 && s.charAt(j)==s.charAt(index)) {
                    dp[j][index]=1;
                    if(i>maxLength) {
                    maxLength=i;
                    start=j;
                    }
                }
            }
        }
       return s.substring(start,start+maxLength);
    }
}
