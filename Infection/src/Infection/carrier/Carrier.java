package Infection.carrier;

import java.util.Random;

import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;

public class Carrier {
	
	public EntityType carrier;
	public float chance;
	public PotionEffect[] effect;
	public String message;
	
	public Carrier(EntityType newCarrier, float newChance, PotionEffect[] newEffect, String newMessage) {
		carrier = newCarrier;
		chance = newChance;
		effect = newEffect;
		message = newMessage;
	}
}
