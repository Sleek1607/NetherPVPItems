package me.JamieSinn.Bukkit;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;

@SuppressWarnings({ "unused" })
public class PlayerListener implements Listener 
{
	NetherPVP plugin;
	BlockListener generator;
	Slow slow;
	Lava lava;
	Explosion explosion;
	
	@EventHandler
	public void InteractWithItems(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if(player.getItemInHand().getType() == Material.EGG && event.getAction() == Action.RIGHT_CLICK_AIR)
		{
			slow.SlowThrow(null);
		}
		if(player.getItemInHand().getType() == Material.FIREBALL && event.getAction() == Action.RIGHT_CLICK_AIR)
		{
			lava.LavaThrow(null);
		}
		if(player.getItemInHand().getType() == Material.SNOW_BALL && event.getAction() == Action.RIGHT_CLICK_AIR)
		{
			explosion.ExplodeThrow(null);
		}
	}
	
}
