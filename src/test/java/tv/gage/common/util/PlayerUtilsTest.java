package tv.gage.common.util;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import tv.gage.common.game.Player;

public class PlayerUtilsTest {

	@Test
	public void randomPlayerTest() {
		List<Player> players = Arrays.asList(new Player[] {
				Player.builder().gameCode("PLYR").build(),
				Player.builder().gameCode("WINR").build()
		});
		Player player = PlayerUtils.randomPlayer(players);
		assertTrue(players.contains(player));
	}
	
	@Test
	public void instantiationTest() {
		PlayerUtils playerUtils = new PlayerUtils();
		assertTrue(playerUtils instanceof PlayerUtils);
	}

}
