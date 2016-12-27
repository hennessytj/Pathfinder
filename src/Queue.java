import edu.princeton.cs.algs4.StdOut;

public class Queue<Item>
{
    private Node first;
    private Node last;
    private int size;
    
    private class Node
    {
        Item item;
        Node next;
        
        public Node(Item item)
        {
            this.item = item;
            next = null;
        }
    }    
    
    public Queue()
    {
        first = null;
        last = null;
        size = 0;
    }
        
    public boolean isEmpty()
    { return first == null; }
    
    public void enqueue(Item item)
    {
        // Linked list representation -> no overflow conditions
        if (first == null)
        {   // Empty list
            first = new Node(item);
            last = first;
        }
        else
        {   // Not empty, add to tail
            Node oldLast = last;
            oldLast.next = new Node(item);
            last = oldLast.next;            
        }
        size++;
    }
    
    public Item dequeue()
    {   // check for underflow
        if (isEmpty()) throw new RuntimeException("Error: Underflow. Attempt to" 
                                                      + " dequeue from empty "
                                                      + " queue.");
        Item item = first.item;
        first = first.next;
        return item;        
    }
    
    public static void main(String[] args)
    {
        Queue<Integer> q = new Queue<Integer>();
        StdOut.println("Enqueue test: ");
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        StdOut.println(q.first.item);
        StdOut.println(q.first.next.item);
        StdOut.println(q.first.next.next.item);
        StdOut.println(q.first.next.next.next.item);
        StdOut.println("isEmpty and size test: ");
        if (!q.isEmpty()) StdOut.println(q.size);
        StdOut.println("Dequeue test: ");
        while(!q.isEmpty())
            StdOut.println(q.dequeue());
    }
}