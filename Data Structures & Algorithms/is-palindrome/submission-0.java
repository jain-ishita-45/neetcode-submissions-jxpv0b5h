class Solution {
    public boolean isPalindrome(String s) {
        String str="";
        for(int i=0;i<s.length();i++)
        {
            if(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i)))
            str+=Character.toLowerCase(s.charAt(i));
        }
        int i=0, l=str.length()-1;
        System.out.println(str);
        while(i<=l)
        {
            if(str.charAt(i)!=str.charAt(l))
            {
                System.out.println(i+" "+str.charAt(i)+" "+l+" "+str.charAt(l));
                return false;
            }
         
            else
            {
                i++;
                l--;
            }
        }
        return true;
        
    }
}
