class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesis(ans,n,"",0,0);
        return ans;
    }
    
    public void generateParenthesis(List<String> ans,int n , String buffer,int open,int close) {
        if(open+close==2*n) {
           // System.out.println (buffer);
            if(buffer!="" && open==close) ans.add(buffer);
            return;
        }
        if(open<n) {
            generateParenthesis(ans,n,buffer + "(",open+1,close);
        }
        if(close<open) {
        generateParenthesis(ans,n,buffer + ")",open,close+1);
        }
        
        //System.out.println (open + " " + close);
       
    }
}
