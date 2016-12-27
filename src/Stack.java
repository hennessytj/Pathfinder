/**
 * Description: Generic stack (LIFO) abstract data
 * type.  Supports basic push, pop, isEmpty, and
 * size operations.
 * Implemented with a linked list as such no explicit
 * maximum size limits, i.e., no overflow concerns.
 * Attempted to keep interface as narrow as possible
 * and did not implement several other common stack
 * operations.
 *
 * Dependencies: None
 *
 * API                            Description
 * -----------------------------------------------------
 *     Stack()                    Basic constructor
 *                                initializes empty
 *                                stack
 *
 * boolean isEmpty()              Is stack empty?
 * 
 * int size()                     How many elements
 *                                on stack
 *
 * void push(Item item)           LIFO insert
 *
 * Item pop()                     LIFO remove
 */
import edu.princeton.cs.algs4.StdOut;

public class Stack<Item>
{
    private Node top;
    private int size;
    
    private class Node
    {
        private Item item;
        private Node next;
        
        public Node(Item item, Node oldFirst)
        {
            this.item = item;
            next = oldFirst;
        }
    }            
    
    public Stack()
    {   // Init empty stack
        top = null;
        size = 0;
    }
    
    public boolean isEmpty()
    { return top == null; }
    
    public int size()
    { return size; }
    
    // isFull
    
    // top
    
    public void push(Item item)
    { 
        top = new Node(item, top);
        size++;
    }
    
    public Item pop()
    {   // check for underflow
        if (isEmpty()) throw new RuntimeException("Error: Underflow. Attempt to" 
                                                      + " pop empty stack.");
        Item topItem = top.item;
        top = top.next;
        size--;
        return topItem;
    }
    
    public static void main(String[] args)
    {
        Stack<Integer> s = new Stack<Integer>();
        StdOut.println(s.isEmpty());
        StdOut.println(s.size());
        for (int i = 0; i < 1000000; i++)
            s.push(i);
        StdOut.println(s.isEmpty());
        StdOut.println(s.size());
        StdOut.println("pop = " + s.pop());
        StdOut.println(s.size());
        while(!s.isEmpty()) s.pop();
        StdOut.println(s.size());
        StdOut.println(s.top);
    }
}