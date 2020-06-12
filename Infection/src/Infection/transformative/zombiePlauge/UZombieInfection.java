package Infection.transformative.zombiePlauge;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitScheduler;

import Infection.InfectionUtil;
import Infection.transformative.Transformative;

public class UZombieInfection {

	private Integer[] tasks;
	
	public UZombieInfection(EntityDamageByEntityEvent e, JavaPlugin plugin) {
		for (Transformative d : InfectionUtil.transfers) {
			if (EntityType.ZOMBIE == d.carrier) {
				if (InfectionUtil.chance(d.chance)) {
					
					Player player = (Player) e.getEntity();
					
					//infected.put(player.getName(), e);
					
					/* STAGE 1 */
					
					// Apply intial effects
					e.getEntity().sendMessage(d.stages[0].message);
					
					for (PotionEffect effect : d.stages[0].effects) {
						effect.apply((LivingEntity) e.getEntity());
					}
					
					/* STAGE 2 */
					
					BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
					
					int a = scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
		                @Override
		                public void run() {
		                	e.getEntity().sendMessage(d.stages[1].message);
							
							for (PotionEffect effect : d.stages[1].effects) {
								effect.apply((LivingEntity) e.getEntity());
							}
		                }
		            }, 8000);
					
					/* STAGE 3 */
					
					int b = scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
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
					
					int c = scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
		                @Override
		                public void run() {
		                	Player player = (Player) e.getEntity();
		                	player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
		                	player.setHealth(0.0);
		                	//infected.remove(player.getName());
		                }
		            }, 24000);
					
					tasks = new Integer[] {
						a,b,c	
					};
				}
				else {
					break;
				}
			}
			else {
				continue;
			}
		}
	}
	
	public Integer[] getTasks() {
		return (Integer[]) tasks;
	}
}
