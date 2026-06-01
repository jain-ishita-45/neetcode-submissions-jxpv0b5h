class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        while(!set.contains(n))
        {
             System.out.print(n);
            set.add(n);
            int sum=0;
            while(n!=0)
            {
                int digit=n%10;
                sum+=(digit*digit);
                n=n/10;
            }
            System.out.print(sum);
            if(sum==1) return true;
            n=sum;
        }
        return false;
    }
}
