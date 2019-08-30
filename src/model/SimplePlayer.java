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
	
	private int initialPoints;
	
	private BetType betType;
	
	private int bet;

	private CoinPair coinPair;
	
	/**
	 * Constructor, Initialises Simple Player
	 * @param playerId
	 * @param playerName
	 * @param initialPoints
	 */
	public SimplePlayer(String playerId, String playerName, int initialPoints) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.initialPoints = initialPoints;
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
		return this.initialPoints;
	}

	@Override
	public void setPoints(int points) {
		this.initialPoints = points;
	}

	@Override
	public String getPlayerId() {
		return this.playerId;
	}

	@Override
	public boolean setBet(int bet) {
		if(bet > 0 && this.initialPoints >= bet) {
			this.bet = bet;
			return true;
		}
		resetBet();
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
		//TODO fix this if need be. DO I flip this?
		this.coinPair = coinPair;
	}
	
	@Override
	public String toString() {
		//TODO: fix this
		return "Player: id=" + this.playerId + ", name=" + this.playerName + ", bet=" + this.bet + 
				", betType= " + this.betType + ", points=" + this.initialPoints;
//		return "Player: id=1, name=The Coin Master, bet=100, betType=COIN1, points=900, RESULT .. Coin 1: Heads, Coin 2: Tails";
	}

}
