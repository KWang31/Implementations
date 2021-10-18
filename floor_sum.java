public static long floorsum(long T, long M, long N, long X) {
    	if(X==0)return 0;
    	long ans;
    	if(M==0) {
    		ans=X*(T/N);
    	}else if(T<0){
    		ans=floorsum(T+((-T+N-1)/N)*N, M, N, X);
    		ans-=((-T+N-1)/N)*X;
    		
    	}else if(M>=N) {
    		ans=floorsum(T,M%N, N, X);
    		ans+=(M/N)*X*(X+1)/2;
    	}else {
    		ans=(T+M*X)/N; ans*=X;
    		//System.out.print(ans+"-");
    		ans-=floorsum(-(T+1), N, M, (T+M*X)/N);
    		
    		
    	}
    	//System.out.println("f("+T+","+M+","+N+","+X+")="+ans);
    	return ans;
    }
