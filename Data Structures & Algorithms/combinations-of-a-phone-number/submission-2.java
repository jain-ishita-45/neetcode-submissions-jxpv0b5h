class Solution {
    List<String> res=new ArrayList<>();
    String [] digittochar={"","","abc","def","ghi","jkl","mno","qprs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        comb(0,digits,"");
        return res;
    }

    public void comb(int i, String digits,String cur)
    {
        if(cur.length()==digits.length())
        {
            res.add(cur);
            return;
        }
        String chars=digittochar[digits.charAt(i)-'0'];
        for(char c:chars.toCharArray())
        comb(i+1,digits,cur+c);
    }
}
