/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import model.enumeration.BetType;
import model.interfaces.Coin;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackImpl;
import view.interfaces.GameEngineCallback;

/**
 * @author japan
 *
 */
public class GameEngineImpl implements GameEngine {
	
	private Map<String, Player> playersMap = null;
	
	private Set<GameEngineCallback> gameEngineCallbacks;
	
//	private GameEngineCallback gameEngineCallback;
	
	/**
	 * Constructor
	 */
	public GameEngineImpl() {
		playersMap = new HashMap<String, Player>();
		gameEngineCallbacks = new HashSet<GameEngineCallback>();
		
//		gameEngineCallback = new GameEngineCallbackImpl();
	}

	@Override
	public void spinPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2,
			int finalDelay2, int delayIncrement2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		//use delay1 for both coins A1: 

		CoinPair coinPair = new CoinPairImpl();
		
		int i = initialDelay1;
		while(i < finalDelay1) {
			if(i < finalDelay1) {
				coinPair.getCoin1().flip();
				coinPair.getCoin2().flip();
				i += delayIncrement1;
				for(GameEngineCallback callback: gameEngineCallbacks) {
					callback.playerCoinUpdate(player, coinPair.getCoin1(), this);
					callback.playerCoinUpdate(player, coinPair.getCoin2(), this);
				}
			}
		}
		
		for(GameEngineCallback callback: gameEngineCallbacks) {		
			callback.playerResult(player, coinPair, this);
		}
	}

	@Override
	public void spinSpinner(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2,
			int delayIncrement2) throws IllegalArgumentException {
		
		CoinPair coinPair = new CoinPairImpl();
		int i = initialDelay1;
		
		while(i < finalDelay1) {
			if(i < finalDelay1) {
				coinPair.getCoin1().flip();
				coinPair.getCoin2().flip();
				i += delayIncrement1;
				try {
					Thread.sleep(delayIncrement1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for(GameEngineCallback callback: gameEngineCallbacks) {
					callback.spinnerCoinUpdate(coinPair.getCoin1(), this);
					callback.spinnerCoinUpdate(coinPair.getCoin2(), this);
				}
			}
		}
		
		for(GameEngineCallback callback: gameEngineCallbacks) {		
			callback.spinnerResult(coinPair, this);
		}
	}

	@Override
	public void applyBetResults(CoinPair spinnerResult) {
		System.out.println("JP TEST");
		for(Player player : playersMap.values()) {
			player.getBetType().applyWinLoss(player, spinnerResult);
		}
		
	}

	@Override
	public void addPlayer(Player player) {
		playersMap.put(player.getPlayerId(), player);
	}

	@Override
	public Player getPlayer(String id) {
		return playersMap.get(id);
	}

	@Override
	public boolean removePlayer(Player player) {
		if(playersMap.containsKey(player.getPlayerId())) {
			playersMap.remove(player.getPlayerId());
			return true;
		}
		return false;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		gameEngineCallbacks.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		if(gameEngineCallbacks.contains(gameEngineCallback)) {
			gameEngineCallbacks.remove(gameEngineCallback);
			return true;
		}
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return new ArrayList<Player>(playersMap.values());
	}

	@Override
	public boolean placeBet(Player player, int bet, BetType betType) {
		//TODO check implementation
		if(player.setBet(bet)) {
			player.setBetType(betType);
			return true;
		}
		return false;
	}

}
