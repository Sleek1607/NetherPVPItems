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
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener 
{
	NetherPVP plugin;
	BlockListener generator;

	
	@SuppressWarnings("unused")
	public void SlowThrow(PlayerEggThrowEvent evt)
	{
	   	Egg egg = evt.getEgg();
    	Location loc = egg.getLocation();
    	Player player = evt.getPlayer();
    	World world = loc.getWorld();
    	if(egg.isEmpty())
    	{
    		if(player.hasPermission("NetherPVP.throw.slow"))
    		{
    			int slowlength = 5;
    			Location point = evt.getEgg().getLocation();
    			generator.generateSlowCube(point, slowlength);
    		}
    	}
    	
	}
	public void LavaThrow(SmallFireball evt)
	{
	  
    	Player player = (Player) evt.getShooter();
  
    	if(player.hasPermission("NetherPVP.throw.lava"))
    	{
    		int lavalength = 5;
    		Location point = evt.getLocation();
    		generator.generateLavaCube(point, lavalength);
    	}
    
    	
	}
	public void ExplodeThrow(Snowball evt)
	{
	  
    	Player player = (Player) evt.getShooter();
    
    	if(player.hasPermission("NetherPVP.throw.explode"))
    	{
    		
    		Location location = evt.getLocation();
    		World world = evt.getWorld();
    		world.createExplosion(location, 7);
    	}
    	
	}
	public void InteractWithItems(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if(player.getItemInHand().getType() == Material.WEB && event.getAction() == Action.RIGHT_CLICK_AIR)
		{
			SlowThrow(null);
		}
		if(player.getItemInHand().getType() == Material.REDSTONE_WIRE && event.getAction() == Action.RIGHT_CLICK_AIR)
		{
			LavaThrow(null);
		}
		if(player.getItemInHand().getType() == Material.LOCKED_CHEST && event.getAction() == Action.RIGHT_CLICK_AIR)
		{
			ExplodeThrow(null);
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		Player player = (Player) sender;
		World world = player.getWorld();
		if (commandLabel.equalsIgnoreCase("strike"))
		{
			if (args.length == 0)
			{
			    if(player.hasPermission("NetherPVP.lightning.aim")) 
			    {
			  	Block targetblock = player.getTargetBlock(null, 50);
				Location location = targetblock.getLocation();
				world.strikeLightning(location);
	 
			    }
			    	else
			    	{
			    		player.sendMessage(ChatColor.RED + "Error:" + ChatColor.WHITE + "Improper Syntax");
			    	}
			}
			else if(args.length == 1)
			{
				if(player.getServer().getPlayer(args[0]) !=null)
				{
				    if(player.hasPermission("NetherPVP.lightning.player")) 
				    {
				Player targetPlayer1 = player.getServer().getPlayer(args [0]);
				Location location = targetPlayer1.getLocation();
				world.strikeLightning(location);
				world.createExplosion(location, 2);
						      
				     }
				    else
				    {
				    	player.sendMessage(ChatColor.RED + "Error:" + ChatColor.WHITE + "Improper Syntax");
				    }
				}
			}
			else
			{
				player.sendMessage(ChatColor.RED + "PLAYER NOT ONLINE");
			}
		}
		return false;
	}
}
