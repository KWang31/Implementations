import java.io.*; import java.util.*;
public class CF0597C {

    //Finds sigma such that
    //a_i=b_{\sigma(i)} for all i
    //Where sigma is a permutation of {1,2,...,n}
    //b is sorted
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int[] a=new int[N];int[] b=new int[N];
        
        for (int i = 0; i < N; i++) {
            a[i]=Integer.parseInt(br.readLine()); b[i]=a[i];
        }
        Arrays.sort(b);
        //Construct sigma (permutation), b(sigma(i))=a(i)
        //Binary Search
        
        int[] sigma=new int[N]; 
        boolean[] used=new boolean[N];//Deal with repetition
        boolean done=false;
        int cur, le, r, midd=0;
        for (int i = 0; i < N; i++) {
            done=false;
            cur=a[i];
            le=0; r=N-1;
            while(le<r){
                
                int mid=(le+r)/2;
                
                if(b[mid]<cur){
                    le=mid+1;
                    
                }else if(b[mid]>cur){
                    r=mid-1;
                }else{
                   midd=mid;
                    //System.out.println(i+" "+used[mid]);
                   while(midd<N && used[midd]==true && b[midd]==cur){
                        midd++;
                    }
                    
                   if(midd>=N || b[midd]>cur){
                       
                       while(mid>=0 && used[mid] && b[mid]==cur){
                            mid--;
                        }
                       sigma[i]=mid;
                       //System.out.println(i+" "+mid);
                       used[mid]=true; done=true;
                       
                   }else{
                       sigma[i]=midd; used[midd]=true; done=true;
                       
                   }
                   
                   break;
                }
                
            }
            if(!done){
                  sigma[i]=le; used[le]=true;
                  
             }
        }
        System.out.println(Arrays.toString(sigma));
    }
    
}
