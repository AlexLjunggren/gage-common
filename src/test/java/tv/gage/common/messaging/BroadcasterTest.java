package tv.gage.common.messaging;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import tv.gage.common.game.Player;

public class BroadcasterTest {

	private Broadcaster broadcaster = new Broadcaster(
			new BroadcastService() {
				protected void sendPlayerMessage(Message message) {}
				protected void sendGameMessage(Message message) {}
			}, "SIMN");

	@Test
	public void broadcastToPlayerTest() {
		Player player = Player.builder().playerCode("PLYR").build();
		broadcaster.broadcastToPlayer(player, "Test");
	}
	
	@Test
	public void broadcastToPlayersTest() {
		Player player1 = Player.builder().playerCode("PLYR").build();
		Player player2 = Player.builder().playerCode("WINR").build();
		List<Player> players = Arrays.asList(new Player[] {player1, player2});
		broadcaster.broadcastToPlayers(players, "Test");
	}
	
	@Test
	public void broadcastToPlayersExcept() {
		Player player1 = Player.builder().playerCode("PLYR").build();
		Player player2 = Player.builder().playerCode("WINR").build();
		List<Player> players = Arrays.asList(new Player[] {player1, player2});
		broadcaster.broadcastToPlayersExcept(players, player1, "Test");
	}
	
	@Test
	public void broadcastToGameTest() {
		broadcaster.broadcastToGame("Test");
	}

}
