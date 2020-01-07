package tv.gage.common.messaging;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import tv.gage.common.game.Player;

@Data
public class Broadcaster {

	private BroadcastService broadcastService;
	private String gameCode;
	
	public Broadcaster(BroadcastService broadcastService, String gameCode) {
		this.broadcastService = broadcastService;
		this.gameCode = gameCode;
	}
	
	public void broadcastToPlayer(Player player, Object payload) {
		broadcastService.broadcastToPlayer(gameCode, player, payload);
	}
	
	public void broadcastToPlayers(List<Player> players, Object payload) {
		broadcastService.broadcastToPlayers(gameCode, players, payload);
	}
	
	public void broadcastToPlayersExcept(List<Player> players, Player notThisPlayer, Object payload) {
		broadcastService.broadcastToPlayers(gameCode,
				players.stream()
					.filter(player -> player != notThisPlayer)
					.collect(Collectors.toList()), payload);
	}
	
	public void broadcastToGame(Object payload) {
		broadcastService.broadcastToGame(gameCode, payload);
	}
	
}
