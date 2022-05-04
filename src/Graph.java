import java.util.*;

class MyGraph {
    Map<Integer,HashSet<Integer>> mp;
    public MyGraph(){
        mp = new HashMap<>();
    }
    public void addEdge(int v1,int v2,boolean isBiDir){
        HashSet<Integer> v1Neighbor = mp.getOrDefault(v1,new HashSet<>());
        v1Neighbor.add(v2);
        mp.put(v1,v1Neighbor);
        if(isBiDir) addEdge(v2,v1,false);
    }
    public void display(){
        for(Map.Entry<Integer,HashSet<Integer>> res : mp.entrySet()){
            System.out.println(res.getKey() + " -> "+ res.getValue());
        }
    }
    public void bfs(int src){
        Queue<Integer> BFS = new LinkedList<>();
        BFS.add(src);
        System.out.print(src);
        HashSet<Integer> vis = new HashSet<>();
        vis.add(src);
        while(!BFS.isEmpty()){
            int temp = BFS.poll();
            HashSet<Integer> Neighbours = mp.get(temp);
            for (int tem : Neighbours) {
                if (!vis.contains(tem)) {
                    System.out.print("->" + tem);
                    BFS.add(tem);
                    vis.add(tem);
                }
            }
        }
        System.out.println();
    }
    public void dfs(int src){
        Stack<Integer> DFS = new Stack<>();
        DFS.push(src);
        HashSet<Integer> vis = new HashSet<>();
        vis.add(src);
        while (!DFS.isEmpty()){
            int temp = DFS.pop();
            System.out.print(temp+" ");
            HashSet<Integer> child = mp.get(temp);
            for(int tem : child){
                if(!vis.contains(tem)){
                    vis.add(tem);
                    DFS.push(tem);
                }
            }
        }
        System.out.println();
    }
    public void dfs_recursive(int src,Set<Integer> vis){
        System.out.print(src+" ");
        vis.add(src);
        HashSet<Integer> neighbour = mp.get(src);
        for(int N : neighbour){
            if(!vis.contains(N))
                dfs_recursive(N,vis);
        }
    }
    public void shortestPath(int src){
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(src);
        Map<Integer,Integer> dis = new HashMap<>();
        for(int res : mp.keySet())
            dis.put(res,Integer.MAX_VALUE);
        dis.put(src,0);
        while(!bfs.isEmpty()){
            int front = bfs.poll();
            HashSet<Integer> neighbourList = mp.get(front);
            for(int neigbh : neighbourList){
                if(dis.get(neigbh) == Integer.MAX_VALUE) {
                    dis.put(neigbh, dis.get(front) + 1);
                    bfs.add(neigbh);
                }
            }
        }
        for(Map.Entry<Integer,Integer> res : dis.entrySet()){
            System.out.print(res.getKey()+"->"+res.getValue());
        }
    }

}

public class Graph {
    public static void main(String[] args) {
        MyGraph g = new MyGraph();

        g.addEdge(0,1,true);
        g.addEdge(0, 3,true);
        g.addEdge(0, 8,true);
        g.addEdge(1, 7,true);
        g.addEdge(2, 3,true);
        g.addEdge(2, 5,true);
        g.addEdge(2, 7,true);
        g.addEdge(3, 4,true);
        g.addEdge(4, 8,true);
        g.addEdge(5, 6,true);
        g.bfs(0);
        g.dfs(0);
        g.dfs_recursive(0,new HashSet<>());
        g.shortestPath(0);
    }
}