import java.util.Arrays;
import java.util.Scanner;

class Edge implements  Comparable<Edge>
{
    int v1;
    int v2;
    int weight; // Members of the edge class containing the vertices it is connecting and the weight it contains

    public Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    } // Constructor to initialize an edge

    @Override
    public int compareTo(Edge o) {
        return this.weight-o.weight;
    } // Overriding compareTo method of Arrays to sort the edges in increasing order of weights
}
public class Kruskals {
    public static Edge[] kruskal(Edge[] edges, int v)
    {
        Arrays.sort(edges); // Sorting edges
        Edge[] mst = new Edge[v-1]; //Creating empty minimum spanning tree in form of an array.
        int count=0; // to keep track of the vertices in tree.
        int i=0;
        int[] parent = new int[v]; //
        for (int j = 0; j <v ; j++) {
            parent[j] = j; // initializing parents for each vertex with random values.
        }
        while(count != v-1) // till count doesn't reach to all vertices.
        {

            Edge current_edge = edges[i++]; // Taking smallest edge weight first
            int v1parent = findParent(current_edge.v1,parent); // looking for parent of current edge's first vertex
            int v2parent = findParent(current_edge.v2, parent); // looking for parent of current edge's second vertex
            if(v1parent != v2parent) // if both parents are different that means we have an edge to add to MST
            {
                // including current edge
                mst[count]= current_edge;
                count++;
                parent[v1parent]= v2parent; // updating parent array i.e., v2 is parent of v1
            }
        }
        return mst;
    }

    private static int findParent(int v1, int[] parent) { // recursive function to find parent of a vertex
        if(v1 == parent[v1])
        {
            return v1;
        }
        return findParent(parent[v1],parent);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // how many vertex
        int v = sc.nextInt();
        // how many edges
        int e = sc.nextInt();
        Edge[] edge_array = new Edge[e];
        for (int i = 0; i <e ; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            Edge obj = new Edge(v1,v2,weight);
            edge_array[i]= obj;
        }
        Edge[] mst = kruskal(edge_array,v);
        for (Edge edge : mst) {
            if (edge.v1 < edge.v2) {
                System.out.println(edge.v1 + " connected to " + edge.v2 + " with weight " + edge.weight);
            } else {
                System.out.println(edge.v2 + " connected to " + edge.v1 + " with weight " + edge.weight);
            }
        }
    }
}