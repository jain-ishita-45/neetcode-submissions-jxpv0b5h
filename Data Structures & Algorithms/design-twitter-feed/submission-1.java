class Tweet implements Comparable<Tweet>
{
    int time, tweetid;
    Tweet(int t, int id)
    {
        time=t;
        tweetid=id;
    }
    public int compareTo(Tweet that)
    {
        return that.time-this.time;
    }
}

class User
{
    int userid;
    HashSet<Integer> followers;
    List<Tweet> tweets;

    User(int userid)
    {
        this.userid=userid;
        followers=new HashSet<>();
        tweets=new LinkedList<>();
    }

    public void addtweet(Tweet t)
    {
        tweets.add(0,t);
    }

    public void addfollower(int followerid)
    {
        followers.add(followerid);
    }

     public void removefollower(int followeeid)
    {
        followers.remove(followeeid);
    }


}


class Twitter {
    int tc;
    HashMap<Integer,User>usermap;

    public Twitter() {
        tc=0;
        usermap=new HashMap<>();
        
    }
    
    public void postTweet(int userid, int tweetid) {
        tc++;
        if(!usermap.containsKey(userid))
        usermap.put(userid, new User(userid));
        User user=usermap.get(userid);
        user.addtweet(new Tweet(tc,tweetid));
        
    }
    
    public List<Integer> getNewsFeed(int userid) {
         if(!usermap.containsKey(userid))
         return new ArrayList<>();
         PriorityQueue<Tweet> pq=new PriorityQueue<>();
         User user=usermap.get(userid);
         int c=0;
         for(int followerid:user.followers)
         {
            for(Tweet tweet: usermap.get(followerid).tweets)
            {
                pq.offer(tweet);
                c++;
                if(c>10) break;
            }
         }

         for(Tweet tweet: usermap.get(userid).tweets)
            {
                pq.offer(tweet);
                c++;
                if(c>10) break;
            }
        List<Integer> res=new ArrayList<>();
        int i=0;
        while(!pq.isEmpty() && i<10)
        {
            Tweet t=pq.poll();
            res.add(t.tweetid);
            i++;
        }
        return res;

        
    }
    
    public void follow(int followerid, int followeeid) {

        if (followerid == followeeid) return;
         if(!usermap.containsKey(followerid))
        usermap.put(followerid, new User(followerid));

         if(!usermap.containsKey(followeeid))
        usermap.put(followeeid, new User(followeeid));

         User user=usermap.get(followerid);
         user.addfollower(followeeid);
        
    }
    
    public void unfollow(int followerid, int followeeid) {
            if(!usermap.containsKey(followerid))
        return;

         if(!usermap.containsKey(followeeid))
        return;

         User user=usermap.get(followerid);
         user.removefollower(followeeid);
    }
}
