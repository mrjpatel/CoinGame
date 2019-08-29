/**
 * 
 */
package model;

import java.util.Random;

import model.enumeration.CoinFace;
import model.interfaces.Coin;

/**
 * @author japan
 *
 */
public class CoinImpl implements Coin {

	private CoinFace coinFace;
	
	private int coinNumber;
	
	/**
	 * 
	 */
	public CoinImpl(int coinNumber) {
		this.coinNumber = coinNumber;
		this.coinFace = getRandomCoinFace();
	}

	@Override
	public int getNumber() {
		return coinNumber;
	}

	@Override
	public CoinFace getFace() {
		return this.coinFace;
	}

	@Override
	public void flip() {
		if(this.coinFace == CoinFace.HEADS) {
			this.coinFace = CoinFace.TAILS;
		}
		else {
			this.coinFace = CoinFace.HEADS;
		}
	}

	@Override
	public boolean equals(Coin coin) {
		return this.coinFace.equals(coin.getFace());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Coin) {
			equals(((Coin) obj));
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return coinFace.hashCode();
	}
	
	@Override
	public String toString() {
		return "Coin " + this.coinNumber +": " + this.coinFace.toString();
	}
	
	/**
	 * Gets Random coin face
	 * @return CoinFace
	 */
	private CoinFace getRandomCoinFace() {
		int max = 3;
		int min = 1;
		
		Random random = new Random();
		int result = random.nextInt(max - min) + min;
		
		if(result == 1) {
			return CoinFace.HEADS;
		}
		return CoinFace.TAILS;
	}

}
