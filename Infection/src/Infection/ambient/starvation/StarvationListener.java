package Infection.ambient.starvation;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

public class StarvationListener implements Listener {

	/*
	private HashMap<String, int[]> starving = new HashMap<String, int[]>();
	
	private JavaPlugin plugin;
	
	public StarvationListener(JavaPlugin newPlugin) {
		plugin = newPlugin;
	}
	
	@EventHandler
	public void onStarve(EntityDamageEvent e) {
		
		if (e.getEntityType() != EntityType.PLAYER) return;
		if(starving.containsKey(e.getEntity().getName())) return;
		if (e.getCause() != DamageCause.STARVATION) return;
		
		// STAGE 1 
		
		e.getEntity().sendMessage("§cYour stomach aches ...");
		new PotionEffect(PotionEffectType.WEAKNESS, Integer.MAX_VALUE, 0).apply((LivingEntity) e.getEntity());
		
		// STAGE 2
		
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		
		int a = scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
            	
            	e.getEntity().sendMessage("§cYour stomach aches ...");
        		new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 0).apply((LivingEntity) e.getEntity());
				
            }
        }, 8000);
		
		// STAGE 3
		
		int b = scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
            	
            	e.getEntity().sendMessage("§cYour stomach aches ...");
        		new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 0).apply((LivingEntity) e.getEntity());
				
            }
        }, 1600);
		
		// STAGE 4
		
		int c = scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
            	
            	Player player = (Player) e.getEntity();
				player.setHealth(0.0);
            }
        }, 24000);
		
		int[] tasks = {
			a,
			b,
			c
		};
		
		starving.put(e.getEntity().getName(), tasks);
		
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onEat(FoodLevelChangeEvent e) {
		if (e.getFoodLevel() <= 0) return;
		if (!starving.containsKey(e.getEntity().getName())) return;
		
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		
		for (int t : starving.get(e.getEntity().getName())) {
			scheduler.cancelTask(t);
		}
		
		starving.remove(e.getEntity().getName());
	}
	*/
	
}
