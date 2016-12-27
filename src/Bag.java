public class Bag
{
    private Node first;
    
    private class Node
    {
        private int val;
        private Node next;
        public Node(int val, Node next)
        {
            this.val = val;
            this.next = next;
        }
    }
    
    public void insert(int vertexNumber)
    { first = new Node(vertexNumber, first); }
    
    public boolean contains(int val)
    {
        for (Node x = first; x != null; x = x.next)
            if (val == x.val) return true;
        return false;
    }
    
    public Queue<Integer> getSet()
    {
        Queue<Integer> q = new Queue<Integer>();
        for (Node x = first; x != null; x = x.next)
            q.enqueue(x.val);
        return q;
    }

    public static void main(String[] args)
    {
        Bag ll = new Bag();
        for (int i = 0; i < 100; i++)
            ll.insert(i);
        ll.print();
        System.out.println(ll.contains(99));
        System.out.println(ll.contains(-1));
    }
    
    /* Methods for testing */       
    public void print()
    {
        for (Node curr = first; curr != null; curr = curr.next)
            System.out.print(curr.val + " ");
        System.out.println();
    }
    
}