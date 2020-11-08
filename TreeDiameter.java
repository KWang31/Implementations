import java.io.*; import java.util.*;
public class TreeDiameter {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        if(N==1){
            System.out.println("0");return;
        }
        ArrayList<Integer> arl[]=new ArrayList[N];
        for (int j = 0; j < N; j++) {
            arl[j]=new ArrayList<>();
        }
        int c,d;
        for (int j = 0; j < N-1; j++) {
             StringTokenizer st=new StringTokenizer(br.readLine());
             c=Integer.parseInt(st.nextToken())-1;
             d=Integer.parseInt(st.nextToken())-1;
             arl[c].add(d); arl[d].add(c);
        }
        int[] dep=new int[N]; int max=0; int vtx=-1;
        Queue<Integer> qu=new LinkedList<>();
        qu.add(0); 
        while(!qu.isEmpty()){
                
                int p=qu.poll();
                
                for (int j : arl[p]) {
                    
                    if(j>0 && dep[j]==0){
                        qu.add(j); 
                        dep[j]=dep[p]+1;
                    }
                    if(dep[j]>max){
                        max=dep[j]; vtx=j;
                    }
                }
        }
        dep=new int[N];
        qu.add(vtx);
        while(!qu.isEmpty()){
                
                int p=qu.poll();
                
                for (int j : arl[p]) {
                    
                    if(j!=vtx && dep[j]==0){
                        qu.add(j); 
                        dep[j]=dep[p]+1;
                    }
                    if(dep[j]>max){
                        max=dep[j]; 
                    }
                }
       }
        System.out.println(max);     
    }
    
}
