package com.hunterahlquist.TheFrontier_Core.Base;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.hunterahlquist.TheFrontier_Core.Definitions.BookData;

public class Commands implements Listener{
	public static void giveIntroBook(Player player) {
		//make it so that there is a check for a delay on the player
		player.openBook(BookData.getIntroBook());
	}
	
}
