package Infection.cure;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import Infection.transformative.TransformativeListener;

public class CureListener implements Listener {

	private TransformativeListener tListener;
	private JavaPlugin plugin;
	
	public CureListener(TransformativeListener a, JavaPlugin b) {
		tListener = a;
		plugin = b;
	}
	
	@EventHandler
	public void onCure(PlayerItemConsumeEvent e) {
		if (e.getPlayer().getGameMode() == GameMode.CREATIVE) return;
		if (e.getItem().getType() != Material.MILK_BUCKET) return;
		
		// This is so fucked.
		/* PLAUGE */
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		if (!tListener.pInfected.containsKey(e.getPlayer().getName())) return;
		
		for(int t : tListener.pInfected.get(e.getPlayer().getName())) {
			scheduler.cancelTask(t);
			System.out.print(t);
		}
		
		tListener.pInfected.remove(e.getPlayer().getName());
		
		e.getPlayer().sendMessage("§cYou have been cured.");
	}
	
}
