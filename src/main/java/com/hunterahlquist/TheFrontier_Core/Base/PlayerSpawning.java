package com.hunterahlquist.TheFrontier_Core.Base;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import randomtp.whoktor.other.RandomTPAPI;

public class PlayerSpawning implements Listener {
	RandomTPAPI rTP = RandomTPAPI.getInstance();
	
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent e) {
		if (e.isBedSpawn()) {
			return;
		} else {
			rTP.randomTeleportPlayer(e.getPlayer(), Bukkit.getWorlds().get(0), 2000, e.getRespawnLocation());
		}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		
		if (!player.hasPlayedBefore()) {
			rTP.randomTeleportPlayer(player, Bukkit.getWorlds().get(0), 2000);
			
			//open the guide for new retarded players who cant fucking read
			player.openBook(BooksDef.getIntroBook());
		}
	}
}
