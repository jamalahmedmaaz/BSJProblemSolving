class ValidParanthesis {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        for(int i=0;i<s.length();i++) {
            if(isOpenBracket(s.charAt(i))) {
                stack[++top]=s.charAt(i);
            } else {
                if(top==-1 || !isCorrectCombo(stack[top],s.charAt(i))) return false;
                else top--;
            }
        }
        if(top==-1) return true;
        return false;
    }
    public boolean isOpenBracket(char c) {
        return (c=='(' || c=='[' || c=='{');
    }
    public boolean isCorrectCombo(char a,char b) {
        return (a=='(' && b==')') || (a=='{' && b=='}') || (a=='[' && b==']'); 
    }
}
