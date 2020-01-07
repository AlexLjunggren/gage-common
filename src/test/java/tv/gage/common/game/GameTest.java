package tv.gage.common.game;

import static org.junit.Assert.*;

import org.junit.Test;

import tv.gage.common.exception.PlayerRosterFullException;
import tv.gage.common.exception.UnknownPlayerException;

public class GameTest {

	@Test
	public void instantiationTest() throws PlayerRosterFullException {
		String gameCode = "GAME";
		Game game = new TestGame(null, gameCode);
		assertEquals(gameCode, game.getGameCode());
	}
	
	@Test 
	public void addPlayerTest() throws PlayerRosterFullException {
		Game game = new TestGame(null, "SIMN");
		game.addPlayer(Player.builder().build());
		assertEquals(1, game.getPlayers().size());
	}
	
	@Test
	public void removePlayerTest() throws PlayerRosterFullException, UnknownPlayerException {
		Game game = new TestGame(null, "SIMN");
		game.addPlayer(Player.builder().playerCode("PLYR").build());
		game.addPlayer(Player.builder().playerCode("WINR").build());
		game.removePlayer(game.getPlayers().get(1));
		assertEquals(1, game.getPlayers().size());
	}
	
}
