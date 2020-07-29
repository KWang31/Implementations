package NewPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Kruskal_Implementation {
    public static class Edge implements Comparable<Edge>{
        int v1; int v2; int cost;
        public Edge(int a, int b, int c){
            this.v1=a; this.v2=b; this.cost=c;
        }
        public int compareTo(Edge other){
            if(this.cost<other.cost)return -1;
            if(this.cost>other.cost)return 1;
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int V=Integer.parseInt(br.readLine());
        int E=Integer.parseInt(br.readLine());
        Edge[] arr=new Edge[E];
        int[] rank=new int[V];
        int[] parent=new int[V];
        for (int i = 0; i < V; i++) {
            parent[i]=i;
        }
        StringTokenizer st; int x; int y; int c;
        for (int i = 0; i < E; i++) {
            st=new StringTokenizer(br.readLine());
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());
            arr[i]=new Edge(x,y,c);
        }
        Arrays.sort(arr);
        int done=0; int i=0; int tot=0; Edge cur;
        while(done<V-1 && i<E){
            cur=arr[i];
            x=arr[i].v1; y=arr[i].v2; c=arr[i].cost;
            int parx=find(x,parent); int pary=find(y,parent);
            if(parx!=pary){//Not connected
                tot+=c; done++;
                if(rank[parx]>rank[pary]){
                    parent[pary]=parx;
                }else if(rank[parx]==rank[pary]){
                    parent[pary]=parx; rank[parx]++;
                }else{
                    parent[parx]=pary;
                }
            }
            i++;
        }
        if(done<V-1){
            System.out.println(-1);
        }else{
            System.out.println(tot);
        }
    }
    public static int find(int i, int[] parent){
        if(i==parent[i])return i;
        int x= find(parent[i],parent);
        parent[i]=x; return x;//Path decompression
    }
}
