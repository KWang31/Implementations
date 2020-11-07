public static int find_centroid(ArrayList<Integer>[] arl, int i){
         for (int q: arl[i]) {
             if(2*siz[q]>N){
                 siz[i]-=siz[q]; siz[q]+=siz[i];
                 return find_centroid(arl,q);
             }
         }
         return i;
}
