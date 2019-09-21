package com.hunterahlquist.TheFrontier_Core.Base;

import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Events implements Listener {
	
	@EventHandler //tells the server that this is an event
	public void spawnChargedCreeper(PlayerInteractEvent event) { //define what kind of event listener
		Player user = event.getPlayer(); //get the player that triggered the event
		
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) { //check if the air was right clicked
			
			if (user.getInventory().getItemInMainHand().isSimilar(ItemDef.defineChargedCreeperEgg())) {
				user.getInventory().getItemInMainHand().setAmount(user.getInventory().getItemInMainHand().getAmount() - 1);
				World thisWorld = user.getWorld();
				
				Creeper chargedCreep = (Creeper) thisWorld.spawnEntity(event.getClickedBlock().getRelative(BlockFace.UP).getLocation(), EntityType.CREEPER);
				chargedCreep.setPowered(true);
				event.setCancelled(true);
				
			}
				
		}
		
	}
	
	@EventHandler //tells the server that this is an event
	public void useBedTP(PlayerInteractEvent event) { //define what kind of event listener
		Player user = event.getPlayer(); //get the player that triggered the event
		
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) { //check if the air was right clicked
			
			if (user.getInventory().getItemInMainHand().isSimilar(ItemDef.defineBedTPItem())) {
				event.setCancelled(true);
				if (user.getBedSpawnLocation() != null) {
					user.getInventory().getItemInMainHand().setAmount(user.getInventory().getItemInMainHand().getAmount() - 1);
					user.playSound(user.getLocation(), Sound.BLOCK_END_PORTAL_SPAWN, 1, 0.3f);
					user.teleport(user.getBedSpawnLocation());
				}
			}
				
		}
		
	}
}
