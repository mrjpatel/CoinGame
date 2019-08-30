/**
 * 
 */
package model;

import model.interfaces.Coin;
import model.interfaces.CoinPair;

/**
 * @author japan
 *
 */
public class CoinPairImpl implements CoinPair {

	private Coin coin1;
	
	private Coin coin2;
	
	private int coin1Number = 1;
	
	private int coin2Number = 2;
	
	/**
	 * Constructor
	 */
	public CoinPairImpl() {
		coin1 = new CoinImpl(coin1Number);
		coin2 = new CoinImpl(coin2Number);
	}

	@Override
	public Coin getCoin1() {
		 return coin1;
	}

	@Override
	public Coin getCoin2() {
		 return coin2;
	}
	
	@Override
   public String toString() {
		return "Coin 1: " + coin1.getFace().toString() + ", Coin 2: " + coin2.getFace().toString();
	}

	@Override
	public boolean equals(CoinPair coinPair) {
		//TODO Fix this
		if(this.coin1.equals(coinPair.getCoin1()) && this.coin2.equals(coinPair.getCoin2())) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof CoinPair) {
			equals(((CoinPair)obj));
		}
		return false;
	}

   @Override
   public int hashCode() {
	   //TODO fix this
	   return coin1.hashCode() + coin2.hashCode();
   }

}
