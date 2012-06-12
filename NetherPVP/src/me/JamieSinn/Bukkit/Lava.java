package me.JamieSinn.Bukkit;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class Lava implements Listener
{


	public void generateLavaCube(Location point, int lavalength){  
		World world = point.getWorld();
		int x_start = point.getBlockX();    
		int y_start = point.getBlockY();     
		int z_start = point.getBlockZ();
	 
		int x_length = x_start + lavalength;    
		int y_length = y_start + lavalength;
		int z_length = z_start + lavalength;
	 
		for(int x_operate = x_start; x_operate <= x_length; x_operate++)
		{ 
			for(int y_operate = y_start; y_operate <= y_length; y_operate++)
			{
				for(int z_operate = z_start; z_operate <= z_length; z_operate++)
				{
	 
					Block blockToChange = world.getBlockAt(x_operate,y_operate,z_operate); 
					blockToChange.setTypeId(10);    
				}
			}
		}
	}
	@EventHandler
	public void LavaThrow(SmallFireball event)
	{
	  
    	Player player = (Player) event.getShooter();
  
    	if(player.hasPermission("NetherPVP.throw.lava"))
    	{
    		int lavalength = 5;
    		Location point = event.getLocation();
    		this.generateLavaCube(point, lavalength);
    	}
    
    	
	}
}
