package tv.gage.common.util;

import java.util.List;
import java.util.Random;

import tv.gage.common.game.Player;

public class PlayerUtils {

	public static Player randomPlayer(List<Player> players) {
		int index = new Random().ints(0, (players.size() - 1) + 1).findFirst().getAsInt();
		return players.get(index);
	}

}
