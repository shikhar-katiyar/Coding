class Solution {
    public String toLowerCase(String s) {
        if (s==null || s.isEmpty()) return s;
        char[] t=s.toCharArray();
        for (int i=0; i<s.length(); i++){
            if (t[i]> 64 && t[i]<91) t[i]+=32;
            else continue;
        }
        return new String(t);
    }
}