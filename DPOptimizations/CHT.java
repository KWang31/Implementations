//Convex Hull Trick, verified on CF319C (319 is ID)
import java.io.*; import java.util.*;
public class CF0319C{
  static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        
    } 
    
    static ArrayList<Long> M=new ArrayList<>();
    static ArrayList<Long> B=new ArrayList<>();
    static int pointer=0;
    public static void main(String[] args){
        FastReader br=new FastReader();
        int N=br.nextInt(); 
        long[] a=new long[N]; for(int i=0;i<N;i++)a[i]=br.nextInt();
        long[] b=new long[N]; for(int i=0;i<N;i++)b[i]=br.nextInt();
        long[] dp=new long[N];
        dp[0]=(long) b[0]; add(b[0],0);
        
        for (int i =1; i < N; i++) {
            dp[i]=query(a[i]);
            
            add(b[i],dp[i]);
        }
        
        System.out.println(dp[N-1]);
    }
    public static boolean bad(int l1, int l2, int l3){//Using doubles to prevent overflow
        return (M.get(l1)-M.get(l3))*((double)B.get(l2)-B.get(l1))>(M.get(l1)-M.get(l2))*((double)B.get(l3)-B.get(l1));
        //Intersection of l1 and l3 must be ABOVE l2
        //For l2 to be added
        //l1.m>l2.m>l3.m, as sum is strictly increasing
    }
    public static void add(long m, long b){
        M.add(m); B.add(b);
        
        while(M.size()>=3 && bad(M.size()-3,M.size()-2,M.size()-1)){
            M.remove(M.size()-2); B.remove(B.size()-2);
        }
    }
    public static long query(long x){
        if(pointer>=M.size()){pointer=M.size()-1;}
        while(pointer<M.size()-1 && 
                M.get(pointer+1)*x+B.get(pointer+1) < M.get(pointer)*x+B.get(pointer)){
            pointer++;
        }
        return M.get(pointer)*x+B.get(pointer);
    }
    
    
}
//Debugging:
//Are you sure your algorithm is correct?
//Bounds: long
//Special cases: n=0,1?
//Make sure you remove your debugging code before you submit!
