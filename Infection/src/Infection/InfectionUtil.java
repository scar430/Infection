package Infection;

import java.util.Random;

import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Infection.carrier.CarrierDisease;
import Infection.transformative.Stage;
import Infection.transformative.TransformativeDisease;

public class InfectionUtil {

	// TO DO ..
	// Add cures.
	
	public static final CarrierDisease[] carriers = {
			new CarrierDisease(
					EntityType.WOLF, 
					0.1f, 
					new PotionEffect[] { 
							new PotionEffect(PotionEffectType.WEAKNESS, Integer.MAX_VALUE, 0)
					},
					"§cYou feel your muscles weaken..."),
	};
	
	public static final TransformativeDisease[] transfers = {
			new TransformativeDisease(EntityType.ZOMBIE, 0.2f, 
					new Stage[] {
							new Stage(
									new PotionEffect[] {
											new PotionEffect(PotionEffectType.HUNGER, Integer.MAX_VALUE, 0)
									}, 
									"§cYou feel extremely hungry..."),
							new Stage(
									new PotionEffect[] {
											new PotionEffect(PotionEffectType.WEAKNESS, Integer.MAX_VALUE, 0)
									}, 
									"§cYou feel your muscles weaken..."),
							new Stage(
									new PotionEffect[] {
											new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 0)
									}, 
									"§cYou feel so tired..."),
					}
					)
	};
	
	// Calculate if the infection was successful.
	public static boolean chance(float iChance) {
		
		Random rand = new Random();
		
		if (rand.nextFloat() < iChance) {
			return true;
		}
		else {
			return false;
		}
	}
}
