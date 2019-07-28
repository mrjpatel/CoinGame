/**
 * 
 */
package model;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.Player;

/**
 * Simple Player Implementation
 * 
 * @author Japan Patel
 */
public class SimplePlayer implements Player {

	
	private String playerName;
	
	private String playerId;
	
	private int playerPoints;
	
	private BetType betType;
	
	private int bet;
	
	private CoinPair coinPair;
	
//	/**
//	 * Constructor
//	 */
//	public SimplePlayer() {
//		// TODO Auto-generated constructor stub
//	}

	/**
	 * Constructor, Initialises Simple Player
	 * @param playerId
	 * @param playerName
	 * @param int1
	 */
	public SimplePlayer(String playerId, String playerName, int int1) {
		this.playerId = playerId;
		this.playerName = playerName;
//		this.playerPoints = playerPoints;
	}

	@Override
	public String getPlayerName() {
		return this.playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public int getPoints() {
		return this.playerPoints;
	}

	@Override
	public void setPoints(int points) {
		this.playerPoints = points;
	}

	@Override
	public String getPlayerId() {
		return this.playerId;
	}

	@Override
	public boolean setBet(int bet) {
		// TODO JAPAN to Check the logic of this implementation
		resetBet();
		if(bet > 0 && this.playerPoints >= bet) {
			return true;
		}
		return false;
	}

	@Override
	public int getBet() {
		return this.bet;
	}

	@Override
	public void setBetType(BetType betType) {
		this.betType = betType;
	}

	@Override
	public BetType getBetType() {
		return this.betType;
	}

	@Override
	public void resetBet() {
		this.setBet(0);
		this.setBetType(BetType.NO_BET);
	}

	@Override
	public CoinPair getResult() {
		return this.coinPair;
	}

	@Override
	public void setResult(CoinPair coinPair) {
		this.coinPair = coinPair;
	}

}
