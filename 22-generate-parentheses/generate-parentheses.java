import java.util.*;
class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans= new ArrayList<>();
        return p(ans,"" , 0, 0, n);
    }
    private List<String> p(List<String> ans, String c, int a, int b, int n) {
        if(c.length()==2*n){
            ans.add(c);
            return ans;
        }
        if (a<n){
            p(ans, c + "(", a+1, b, n);
        }
        if (b<a){
            p(ans, c + ")", a, b+1, n);
        }
        return ans;
    }
}