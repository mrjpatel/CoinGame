package view;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.Coin;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback {
	private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());

	public GameEngineCallbackImpl() {
		// NOTE need to also set the console to FINE in
		// %JRE_HOME%\lib\logging.properties
		logger.setLevel(Level.FINE);
	}

	public void playerCoinUpdate(Player player, Coin coin, GameEngine engine) {
		// intermediate results logged at Level.FINE
		logger.log(Level.FINE, player.getPlayerName() + " coin " + coin.getNumber() + " flipped to " + coin.getFace());
		// TODO: complete this method to log intermediate results
	}

	public void playerResult(Player player, CoinPair coinPair, GameEngine engine) {
		logger.log(Level.INFO, player.getPlayerName() + ", final result=Coin 1: " + coinPair.getCoin1().getFace() + ", Coin 2: " + coinPair.getCoin2().getFace());
		// TODO: complete this method to log results
	}

	// TODO: implement rest of interface
	@Override
	public void spinnerCoinUpdate(Coin coin, GameEngine engine) {
		logger.log(Level.FINE, "Spinner coin " + coin.getNumber() + " flipped to " + coin.getFace());
	}

	@Override
	public void spinnerResult(CoinPair coinPair, GameEngine engine) {
		logger.log(Level.INFO, "Spinner, final result=Coin " + coinPair.getCoin1().getNumber() + ": " + coinPair.getCoin1().getFace() +
				", Coin " + coinPair.getCoin2().getNumber() + ": " + coinPair.getCoin2().getFace());
	}

}
