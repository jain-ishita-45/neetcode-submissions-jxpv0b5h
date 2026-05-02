class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[]=new int [26];
        for(int i=0;i<tasks.length;i++)
        freq[tasks[i]-'A']++;
        Arrays.sort(freq);
        for(int i:freq)
           System.out.print(i);
        int ideal=(freq[freq.length-1]-1)*n;
        System.out.println("###"+ideal);
        for(int i=0;i<freq.length-1;i++)
        {
            ideal-=Math.min(freq[freq.length-1]-1,freq[i]);
        }
        return tasks.length+Math.max(0,ideal);
    }
}
