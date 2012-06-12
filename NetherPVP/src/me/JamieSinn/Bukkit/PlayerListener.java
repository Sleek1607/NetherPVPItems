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
import org.bukkit.event.Event;
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

	

	public PlayerListener(NetherPVP plugin)
	{
		this.plugin = plugin;
		slow = new Slow();
		lava = new Lava();
		explosion = new Explosion();
	}
	@EventHandler
	public void InteractWithItems(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if(player.getItemInHand().getType() == Material.WEB && event.getAction() == Action.LEFT_CLICK_AIR)
		{
			slow.SlowThrow(slow);
		}
		if(player.getItemInHand().getType() == Material.REDSTONE_WIRE && event.getAction() == Action.LEFT_CLICK_AIR)
		{
		
			lava.LavaThrow(lava);
		}
		if(player.getItemInHand().getType() == Material.LOCKED_CHEST && event.getAction() == Action.LEFT_CLICK_AIR)
		{
			explosion.ExplodeThrow(explosion);
		}
	}
	
}
