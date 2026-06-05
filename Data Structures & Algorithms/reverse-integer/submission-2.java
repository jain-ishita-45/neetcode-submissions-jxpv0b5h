class Solution {
    public int reverse(int x) {
        final int min=-2147483648,max=2147483647;
        int z=0;
        while(x!=0)
        {
            int digit=x%10;
           
            x=x/10;
            if(z>max/10 || (z==max/10 && digit>max%10))
            return 0;
            if(z<min /10 ||(z==min/10 && digit<min%10))
            return 0;
             z=z*10+digit;
        }
        return z;
    }
}
