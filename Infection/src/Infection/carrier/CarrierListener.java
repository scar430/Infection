package Infection.carrier;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;

import Infection.InfectionUtil;

public class CarrierListener implements Listener {
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		
		// Only players can get diseases.
		if (e.getEntityType() != EntityType.PLAYER) return;
		
		// Check if any carriers attacked the player.
		for (Carrier disease : InfectionUtil.carriers) {
			
			if (e.getDamager().getType() == disease.carrier) {
				// Roll for infection chance.
				if (InfectionUtil.chance(disease.chance)) {
					
					// Send a message alerting the player they contracted a disease.
					e.getEntity().sendMessage(disease.message);
					
					// Apply all potion effects from the disease
					for (PotionEffect effect : disease.effect) {
						effect.apply((LivingEntity) e.getEntity());
					}
					
					break;
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
}
