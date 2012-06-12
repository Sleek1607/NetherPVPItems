package me.JamieSinn.Bukkit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener
{

	public static NetherPVP plugin;
	
	public static Material[] slowblock = {Material.WEB};
	public static Material[] lavablock = {Material.REDSTONE_WIRE};
	public static Material[] explodeblock = {Material.LOCKED_CHEST};
	Slow slowclass;
	Lava lavaclass;
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event)
	{
		int slowlength = 5;
		int lavalength = 5;
		Material block = event.getBlock().getType();
		Player player = event.getPlayer();
		Block targetBlock = player.getTargetBlock(null, 50);
		Location point = targetBlock.getLocation();
		if(player.hasPermission("NetherPVP.place.slow"))
		{
			for (Material slow : slowblock) 
			{
				if (slow == block) 
				{
					targetBlock.getLocation();
					slowclass.generateSlowCube(point, slowlength);
				}
			}
		}
		if(player.hasPermission("NetherPVP.place.lava"))
		{
			for (Material lava : lavablock) 
			{
				if (lava == block) 
				{
					targetBlock.getLocation();
					lavaclass.generateLavaCube(point, lavalength);
				}
			}
		}
		if(player.hasPermission("NetherPVP.place.explode"))
		{
			for (Material explode : explodeblock) 
			{
				if (explode == block) 
				{
					event.getBlock().setType(Material.TNT);
					event.getBlockAgainst().setType(Material.FIRE);			
				}
			}
		}
	}
}


		
	

