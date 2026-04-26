class LRUCache {

    void addnode(Node nn)
    {
        Node oldnext=head.next;
        head.next=nn;
        oldnext.prev=nn;
        nn.next=oldnext;
        nn.prev=head;
    }

    void deletenode(Node oldnode)
    {
        Node oldprev=oldnode.prev;
        Node oldnext=oldnode.next;
        oldprev.next=oldnext;
        oldnext.prev=oldprev;

    }
    class Node
    {
        int key, value;
        Node prev,next;
        Node(int key, int value)
        {
            this.key=key;
            this.value=value;
        }
    }
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);
    HashMap<Integer, Node> map;
    int limit;
    public LRUCache(int capacity) {
        limit=capacity;
        head.next=tail;
        tail.prev=head;
        map=new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        return -1;
      
        Node ansnode=map.get(key);
        map.remove(key);
        deletenode(ansnode);
        addnode(ansnode);
        map.put(key,ansnode);
        return ansnode.value;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node oldnode=map.get(key);
            deletenode(oldnode);
            map.remove(key);
        }

        if(map.size()==limit)
        {
            map.remove(tail.prev.key);
            deletenode(tail.prev);
        }

        Node nn=new Node(key,value);
        addnode(nn);
        map.put(key,nn);
    }
}
