package Infection.transformative;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitScheduler;

import Infection.InfectionUtil;

public class TransformativeListener implements Listener {

	private JavaPlugin plugin;
	
	private ArrayList<String> infected = new ArrayList<String>();
	
	public TransformativeListener(JavaPlugin newPlugin) {
		plugin = newPlugin;
	}
	
	@EventHandler
	public void onContract(EntityDamageByEntityEvent e) {
		// Infections are only for players
		if (e.getEntity().getType() != EntityType.PLAYER) return;
		
		for (TransformativeDisease d : InfectionUtil.transfers) {
			if (e.getDamager().getType() == d.carrier) {
				if (InfectionUtil.chance(d.chance)) {
					
					Player player = (Player) e.getEntity();
					
					infected.add(player.getName());
					
					/* STAGE 1 */
					
					// Apply intial effects
					e.getEntity().sendMessage(d.stages[0].message);
					
					for (PotionEffect effect : d.stages[0].effects) {
						effect.apply((LivingEntity) e.getEntity());
					}
					
					/* STAGE 2 */
					
					BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
					
					scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
		                @Override
		                public void run() {
		                	e.getEntity().sendMessage(d.stages[1].message);
							
							for (PotionEffect effect : d.stages[1].effects) {
								effect.apply((LivingEntity) e.getEntity());
							}
		                }
		            }, 8000);
					
					/* STAGE 3 */
					
					scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
		                @Override
		                public void run() {
		                	//  Times up, apply effects
							e.getEntity().sendMessage(d.stages[2].message);
							
							for (PotionEffect effect : d.stages[2].effects) {
								effect.apply((LivingEntity) e.getEntity());
							}
		                }
		            }, 16000);
					
					/* STAGE 4 */
					
					scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
		                @Override
		                public void run() {
		                	Player player = (Player) e.getEntity();
		                	player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
		                	player.setHealth(0.0);
		                }
		            }, 24000);
				}
				else {
					break;
				}
			}
			else {
				continue;
			}
		}
		
		return;
	}
}
