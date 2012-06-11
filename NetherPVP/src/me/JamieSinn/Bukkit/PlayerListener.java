package me.JamieSinn.Bukkit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener 
{
	NetherPVP plugin;
	BlockListener generator;

	
	public void SlowThrow(PlayerEggThrowEvent evt)
	{
	   	Egg egg = evt.getEgg();
    	Location loc = egg.getLocation();
    	Player player = evt.getPlayer();
    	World world = loc.getWorld();
    	if(player.hasPermission("NetherPVP.throw.slow"))
    	{
    		int slowlength = 5;
    		Location point = evt.getEgg().getLocation();
    		generator.generateSlowCube(point, slowlength);
    	}
    	
	}
	public void LavaThrow(Fireball evt)
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
		if(player.getItemInHand().getType() == Material.WEB)
		{
			SlowThrow(null);
		}
		if(player.getItemInHand().getType() == Material.REDSTONE_WIRE)
		{
			LavaThrow(null);
		}
		if(player.getItemInHand().getType() == Material.WEB)
		{
			ExplodeThrow(null);
		}
	}
}
