import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Graph
{
    // state
    private final int V;
    private int E;
    Bag[] adjList;
    
    public Graph(int v)
    {
        V = v;
        E = 0;
        adjList = new Bag[V];
        for (int i = 0; i < V; i++)
            adjList[i] = new Bag();
    }
    
    public Graph(In in)
    { 
        V = in.readInt();
        E = in.readInt();
        
        adjList = new Bag[V];
        
        for (int i = 0; i < V; i++)
            adjList[i] = new Bag();
        int  n = E;
        for (int i = 0; i < n; i++)
        {
            int vertex1 = in.readInt();
            int vertex2 = in.readInt();
            addEdge(vertex1, vertex2);
        }
    }
    
    public int numOfVertices()
    { return V; }
    
    public int numOfEdges()
    { return E; }
    
    public void addEdge(int v, int w)
    {
        adjList[v].insert(w);
        adjList[w].insert(v);
        E++; 
    }
    
    public Queue<Integer> adjacentVertices(int v)
    { return adjList[v].getSet(); }            
    
    public static void main(String[] args)
    {
        Graph g = new Graph(new In("/Users/Hennessy/Graph Algorithms/Graph Data Types/Undirected/data/largeG.txt"));
        StdOut.println(g.numOfVertices());
        StdOut.println(g.numOfEdges());
        //g.printGraph();
        Queue<Integer> adjVQ = g.adjacentVertices(0);
        StdOut.print("Adjacent Vertices incident to 0: ");
        while (!adjVQ.isEmpty())
        {
            int adjVertex = adjVQ.dequeue();
            StdOut.print(adjVertex + " ");
        }
        StdOut.println();  
    }
    
    /* Methods for testing */
    public void printAdjacentVertices(int v)
    {
        System.out.print(v + ": ");
        adjList[v].print();
    }
    
    public void printGraph()
    {
        for (int v = 0; v < V; v++)
            printAdjacentVertices(v);
    }
}