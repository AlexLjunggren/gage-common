package tv.gage.common.game;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import tv.gage.common.messaging.BroadcastService;
import tv.gage.common.messaging.Broadcaster;

@Data
public abstract class Game {

	protected Broadcaster broadcaster;
	protected String gameCode;
	protected List<Player> players = new ArrayList<Player>();
	
	public Game(BroadcastService broadcastService, String gameCode) {
		this.broadcaster = new Broadcaster(broadcastService, gameCode);
		this.gameCode = gameCode;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void removePlayer(Player player) {
		players.remove(player);
	}
	
	public abstract void receiveGameCommand(String json);
	public abstract void receivePlayerCommand(Player player, String json);
	
}
