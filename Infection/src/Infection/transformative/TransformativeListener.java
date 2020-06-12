package Infection.transformative;

import java.util.HashMap;

import org.bukkit.Bukkit;
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
import Infection.transformative.zombiePlauge.UZombieInfection;

public class TransformativeListener implements Listener {

	private JavaPlugin plugin;
	
	public HashMap<String, Integer[]> pInfected = new HashMap<String, Integer[]>();
	
	
	
	public TransformativeListener(JavaPlugin newPlugin) {
		plugin = newPlugin;
	}
	
	@EventHandler
	public void onContract(EntityDamageByEntityEvent e) {
		// Infections are only for players
		if (e.getEntity().getType() != EntityType.PLAYER) return;
		if (pInfected.containsKey(e.getEntity().getName())) return;
		
		for (Transformative d : InfectionUtil.transfers) {
			switch(d.carrier) {
			case ZOMBIE:
				UZombieInfection inf = new UZombieInfection(e, plugin);
				pInfected.put(e.getEntity().getName(), inf.getTasks());
				//System.out.print(pInfected.toString());
				break;
				default:
					break;
			}
		}
		
		return;
	}
}
