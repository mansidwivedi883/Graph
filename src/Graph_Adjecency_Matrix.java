public class Graph_Adjecency_Matrix {
    int[][] graph;
    public Graph_Adjecency_Matrix(int v,int e){
        graph = new int[v][e];
    }
    public void addEdge(int v1,int v2,boolean isBiDir){
        graph[v1][v2]=1;
        if(isBiDir) graph[v2][v1]=1;
    }
    public void display(){
        for(int i=1;i< graph.length;i++){
            System.out.print(i + "->" + "[ ");
            for (int j = 0; j < graph[i].length; j++) {
                if(graph[i][j]==1)
                    System.out.print(j+" ");
            }
            System.out.print("]");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Graph_Adjecency_Matrix obj = new Graph_Adjecency_Matrix(7,7);
        obj.addEdge(1,2,true);
        obj.addEdge(1,3,true);
        obj.addEdge(2,4,true);
        obj.addEdge(3,4,true);
        obj.addEdge(3,5,true);
        obj.addEdge(5,6,true);
        obj.display();
    }
}