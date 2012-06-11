package me.JamieSinn.Bukkit;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerEggThrowEvent;

public class Slow 
{
	public void generateSlowCube(Location point, int slowlength){  
		World world = point.getWorld();
		int x_start = point.getBlockX();    
		int y_start = point.getBlockY();     
		int z_start = point.getBlockZ();
	 
		int x_length = x_start + slowlength;    
		int y_length = y_start + slowlength;
		int z_length = z_start + slowlength;
	 
		for(int x_operate = x_start; x_operate <= x_length; x_operate++)
		{ 
			for(int y_operate = y_start; y_operate <= y_length; y_operate++)
			{
				for(int z_operate = z_start; z_operate <= z_length; z_operate++)
				{
	 
					Block blockToChange = world.getBlockAt(x_operate,y_operate,z_operate); 
					blockToChange.setTypeId(30);    
				}
			}
		}
	}
	@SuppressWarnings("unused")
	@EventHandler
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
    			this.generateSlowCube(point, slowlength);
    		}
    	
    	
	}
}
