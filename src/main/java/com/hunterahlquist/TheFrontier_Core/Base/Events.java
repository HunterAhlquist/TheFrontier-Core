package com.hunterahlquist.TheFrontier_Core.Base;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import com.hunterahlquist.TheFrontier_Core.Definitions.BookData;
import com.hunterahlquist.TheFrontier_Core.Definitions.ItemData;

import net.md_5.bungee.api.ChatColor;
import randomtp.whoktor.other.RandomTPAPI;

public class Events implements Listener {
	//parameters
	public double dropChance = 0.01f; //mob egg drop chance
	
	//objects
	RandomTPAPI rTP = RandomTPAPI.getInstance();
	
	//events
	//charged creeper egg
	@EventHandler //tells the server that this is an event
	public void spawnChargedCreeper(PlayerInteractEvent event) { //define what kind of event listener
		Player user = event.getPlayer(); //get the player that triggered the event
		
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) { //check if the air was right clicked
			
			if (user.getInventory().getItemInMainHand().isSimilar(ItemData.defineChargedCreeperEgg())) {
				user.getInventory().getItemInMainHand().setAmount(user.getInventory().getItemInMainHand().getAmount() - 1);
				World thisWorld = user.getWorld();
				
				Creeper chargedCreep = (Creeper) thisWorld.spawnEntity(event.getClickedBlock().getRelative(BlockFace.UP).getLocation(), EntityType.CREEPER);
				chargedCreep.setPowered(true);
				event.setCancelled(true);
				
			}
				
		}
		
	}
	
	//bed teleport item
	@EventHandler //tells the server that this is an event
	public void useBedTP(PlayerInteractEvent event) { //define what kind of event listener
		Player user = event.getPlayer(); //get the player that triggered the event
		
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) { //check if the air was right clicked
			
			if (user.getInventory().getItemInMainHand().isSimilar(ItemData.defineBedTPItem())) {
				event.setCancelled(true);
				if (user.getBedSpawnLocation() != null) {
					user.getInventory().getItemInMainHand().setAmount(user.getInventory().getItemInMainHand().getAmount() - 1);
					user.playSound(user.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1.1f);
					user.playSound(user.getBedSpawnLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1.1f);
					user.teleport(user.getBedSpawnLocation());
				} else {
					user.sendMessage(ChatColor.RED + "You do not have a bed available to you.");
				}
			}
				
		}
		
	}
	
	//mob egg drops
	@EventHandler
	public void eggDrop(EntityDeathEvent e) {
		double random = Math.random();
		
		if (random < dropChance) {
			switch (e.getEntityType()) {
			case PIG:
				e.getDrops().add(new ItemStack(Material.PIG_SPAWN_EGG, 1));
				break;
			case COW:
				e.getDrops().add(new ItemStack(Material.COW_SPAWN_EGG, 1));
				break;
			case CREEPER:
				e.getDrops().add(new ItemStack(Material.CREEPER_SPAWN_EGG, 1));
				break;
			case SKELETON:
				e.getDrops().add(new ItemStack(Material.SKELETON_SPAWN_EGG, 1));
				break;
			case ZOMBIE:
				e.getDrops().add(new ItemStack(Material.ZOMBIE_SPAWN_EGG, 1));
				break;
			case SPIDER:
				e.getDrops().add(new ItemStack(Material.SPIDER_SPAWN_EGG, 1));
				break;
			case SHEEP:
				e.getDrops().add(new ItemStack(Material.SHEEP_SPAWN_EGG, 1));
				break;
			case CHICKEN: 
				e.getDrops().add(new ItemStack(Material.CHICKEN_SPAWN_EGG, 1));
				break;
			default:
				break;
			}
		}
	}
	
	//random teleporting
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
			player.openBook(BookData.getIntroBook());
		}
	}
}
