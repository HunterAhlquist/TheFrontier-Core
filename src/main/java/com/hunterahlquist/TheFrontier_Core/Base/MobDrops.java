package com.hunterahlquist.TheFrontier_Core.Base;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class MobDrops implements Listener{
	public double dropChance = 0.01f;
	
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
	
	
}
