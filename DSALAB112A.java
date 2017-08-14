import java.util.*;

public class SecondBest_MST {

    static class Edge {
        int v1;
        int v2;
        int weight;
        int id;
        public Edge(int v1, int v2, int weight, int id) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
            this.id = id;
        }
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return id == edge.id;
        }
    }

    static class unionFind {
        int[] parent;
        int[] rank;
        int count;
        public unionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            this.count = n;
            for(int i = 0 ; i < n ; i++)
                parent[i] = i;
        }
        boolean find(int v1, int v2){
            return root(v1) == root(v2);
        }
        void union(int v1, int v2){
            count--;
            int r1 = root(v1);
            int r2 = root(v2);
            if(rank[r1] == rank[r2]){
                parent[r2] = r1;
                rank[r1]++;
            } else if(rank[r1] > rank[r2]){
                parent[r2] = r1;
            } else {
                parent[r1] = r2;
            }
        }
        private int root(int id) {
            if(parent[id] == id){
                return id;
            }
            parent[id] = root(parent[id]);
            return parent[id];
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        List<Edge> edges=new ArrayList<>();
        int V=in.nextInt();
        int E=in.nextInt();
        int id=0;
        while(E-->0){
            edges.add(new Edge(in.nextInt(), in.nextInt(), in.nextInt(), id++));
        }
        //System.out.println(id);
        Collections.sort(edges, new Comparator<Edge>() {
        public int compare(Edge o1, Edge o2) {
            if(o1.weight > o2.weight) return 1;
            else if(o1.weight < o2.weight) return -1;
            return 0;
        }
        });
        //Other way to sort vertices ont the basis of their weights
        /*for(int i=1;i<=E;i++)
        for(int j=1;j<=E-1;j++){
        	if(edge[j]<edge[j+1]){
        		/*Edge t=new Edge();
            	t=edge[j];
            	edge[j]=edge[j+1];
                edge[j+1]=t;
            }
        }*/
        unionFind uf = new unionFind(V + 1);
        int best = 0;
        List<Edge> mstEdges = new ArrayList<>();
        for(Edge edge : edges){
            if(!uf.find(edge.v1, edge.v2)){
                best += edge.weight;
                mstEdges.add(edge);
                uf.union(edge.v1, edge.v2);
            }
        }

        int secondBest = Integer.MAX_VALUE;
        for(Edge skip : mstEdges){
        	int localBest = 0;
            unionFind localUF = new unionFind(V + 1);
            for(Edge edge : edges){
                if(edge.equals(skip)) continue;
                if(!localUF.find(edge.v1, edge.v2)){
                    localBest += edge.weight;
                    localUF.union(edge.v1, edge.v2);
                }
            }
            if(localUF.count == 2 && localBest < secondBest){
                secondBest = localBest;
            }
        }
        if (best<secondBest && secondBest!=Integer.MAX_VALUE)
        	System.out.println(secondBest);
        else System.out.println(-1);
        in.close();
    }
}
