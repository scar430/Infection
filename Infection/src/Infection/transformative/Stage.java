package Infection.transformative;

import org.bukkit.potion.PotionEffect;

public class Stage {

	// Effects to apply.
	public PotionEffect[] effects;
	
	// Message to send
	public String message;
	
	public Stage(PotionEffect[] newEffects, String newMessage) {
		effects = newEffects;
		message = newMessage;
	}
}
