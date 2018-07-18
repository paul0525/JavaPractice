package practice.concurrent;

import java.math.BigInteger;
import java.util.Arrays;


public class OneValueCache {
		
	private final BigInteger lastNumber;
	private final BigInteger[] lastFactors;
	
	public OneValueCache(BigInteger i, BigInteger[] lastFactors) {
		super();
		this.lastNumber = i;
		this.lastFactors = lastFactors;
	}
	
	
	public BigInteger[] getFactors(BigInteger i){
		
		if( lastNumber == null ||  !lastNumber.equals(i) ){
			return null;
		} else{
			return Arrays.copyOf(lastFactors, lastFactors.length);
		}
			
		
	}
	
}
