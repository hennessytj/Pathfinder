/**
 * Description: Takes an undirected graph and a source 
 * vertex and computes all paths in the graph from that
 * source vertex.  Provides simple methods to determine
 * if there is a path between the source and some given
 * vertex, and if so the path can be returned.
 * 
 * Dependencies: Bag.java, Graph.java, Queue.java,
 * Stack.java
 * 
 * API                                Description
 * ------------------------------------------------------
 *     Pathfinder(Graph undirectedG, int source)
 * 
 * boolean doesPathExist(int vertex)
 * 
 * Stack<Integer> path(int destinationVertex)
 */
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class Pathfinder
{
    private boolean[] visited;
    private int[] edge;
    private int source;
    
    public Pathfinder(Graph undirectedG, int s)
    {
        this.source = s;
        visited = new boolean[undirectedG.numOfVertices()];
        edge = new int[undirectedG.numOfVertices()];
        depthFirstSearch(undirectedG, source);
    }
    
    public void depthFirstSearch(Graph g, int v)
    {
        visited[v] = true;
        // NOTE: Despite a using a queue this is 
        // not a breadth first search, the function-call
        // stack is used to facilitate the dfs
        Queue<Integer> q = g.adjacentVertices(v);
        while (!q.isEmpty())
        {
            int w = q.dequeue();
            if (!visited[w])
            {
                depthFirstSearch(g, w);
                edge[w] = v;
            }
        }
    }
    
    public boolean doesPathExist(int vertex)
    { return visited[vertex]; }
    
    public Stack<Integer> path(int destinationVertex)
    {
        int bounds = edge.length, count = 0;
        if (destinationVertex < 0 || 
            destinationVertex > bounds)
            throw new RuntimeException("Invalid vertex.");   
        if (!doesPathExist(destinationVertex)) return null; 
        Stack<Integer> s = new Stack<Integer>();
        s.push(destinationVertex);
        while (destinationVertex != edge[destinationVertex])
        {
            if (count++ > bounds) throw new RuntimeException("Error: path");
            s.push(edge[destinationVertex]);
            destinationVertex = edge[destinationVertex];
        }
        return s;
    } 
        
    
    public static void main(String[] args)
    {
        Graph g = new Graph(new In("/Users/Hennessy/Graph Algorithms/Graph Data Types/Undirected/data/tinyG.txt"));
        Pathfinder p = new Pathfinder(g, 0);
        //g.printGraph();
        //p.printVisitedArray();
        //p.printEdgeArray();
        StdOut.println(p.doesPathExist(3));
        Stack<Integer> s = p.path(3);
        while (!s.isEmpty())
            StdOut.print(s.pop() + " ");
        StdOut.println();
    }
    
    /* Methods for testing/debugging */
    public void printEdgeArray()
    {
        for (int i = 0; i < edge.length; i++)
            StdOut.println(i + " : " + edge[i]);
    }
    
    public void printVisitedArray()
    {
        for (int i = 0; i < visited.length; i++)
            StdOut.println(visited[i]);
    }
}