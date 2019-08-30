package client;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import validate.Validator;
import view.GameEngineCallbackImpl;

/**
 * Testing Client
 * @author Japan Patel
 *
 */
public class MyTestClient
{
   private static final Logger logger = Logger.getLogger(SimpleTestClient.class.getName());

   public static void main(String args[]) {
	   
	   final GameEngine gameEngine = new GameEngineImpl();
	   
	   Validator.validate(true);

	   Player[] players = new Player[] { 
			   new SimplePlayer("1", "Player 1", 500),
		       new SimplePlayer("2", "Player 2", 750),
		       new SimplePlayer("3", "Player 3", 500) };

      gameEngine.addGameEngineCallback(new GameEngineCallbackImpl()); // add logging callback

      int enumOrdinal = 0;
      for (Player player : players) {
         gameEngine.addPlayer(player);
         
         gameEngine.placeBet(player, 100, BetType.values()[enumOrdinal++ % BetType.values().length]);
         gameEngine.spinPlayer(player, 100, 1000, 100, 50, 500, 50);
      }

      logger.log(Level.INFO, "SPINNING ...");
      gameEngine.spinSpinner(100, 1000, 200, 50, 500, 25);

      // TODO reset bets for next round if you were playing again
      
      logger.log(Level.INFO, "\n-------------------------------- NEW GAME --------------------------------\n");
           
      for (Player player : players) {
         gameEngine.addPlayer(player);
         
         gameEngine.placeBet(player, 500, BetType.values()[enumOrdinal++ % BetType.values().length]);
         gameEngine.spinPlayer(player, 100, 1000, 100, 50, 500, 50);
      }

      logger.log(Level.INFO, "SPINNING ...");
      gameEngine.spinSpinner(100, 1000, 200, 50, 500, 25);
   }
}
