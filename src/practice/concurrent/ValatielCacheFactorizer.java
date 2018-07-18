package practice.concurrent;

import java.math.BigInteger;

public class ValatielCacheFactorizer {
	
	private volatile OneValueCache cache = new OneValueCache(null, null);
	
	public void service( BigInteger i){
		
		BigInteger[]  factors  = cache.getFactors(i);
		
		if( factors == null){
			factors = factor(i);
			cache = new OneValueCache(i, factors);
		}
	}
	
	private BigInteger[] factor(BigInteger i) {
		// TODO Auto-generated method stub
		return null;
	}


}
