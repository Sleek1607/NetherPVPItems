package me.JamieSinn.Bukkit;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;

public class Explosion
{
	@EventHandler
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
}
