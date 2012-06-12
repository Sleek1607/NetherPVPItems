package me.JamieSinn.Bukkit;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class NetherPVP extends JavaPlugin 
{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static NetherPVP Plugin;
	
	public final BlockListener bl = new BlockListener();
	public final PlayerListener pl = new PlayerListener(this);
	public final Lava lava = new Lava();
	public final Slow slow = new Slow();
	public final Explosion explosion = new Explosion();
	
	public void onEnable()
	{
		
		PluginManager pm =getServer().getPluginManager();
		pm.registerEvents(this.bl, this);
		pm.registerEvents(this.pl, this);
		pm.registerEvents(this.lava, this);
		pm.registerEvents(this.slow, this);
		pm.registerEvents(this.explosion, this);
	}
	public void onDisable()
	{
				
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
