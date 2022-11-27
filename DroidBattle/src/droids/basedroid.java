package droids;

import java.util.Random;

public class basedroid {
	private String name;
	private int health;
	private int healthlimit;
	private int damage;
	private int armor;
	
	public basedroid(String name,int health,int damage, int armor) {
		this.name = name;
		this.healthlimit = this.health = health;
		this.damage = damage;
		this.armor = armor;
	}
	
	protected void AddHealth(int add) {
		health += add;
		if(health > healthlimit)
			health = healthlimit;
	}
	
	protected void AddArmor(int add) {
		armor += add;
	}

	public String getName() {
		return name;
	}

	public int GetDamage() {
		return damage;
	}
	
	
	public int GetHit(int damage) {
		if(armor > 0) {
			armor -= damage/10;
			if(armor < 0)
				armor = 0;
			damage -= armor;
			if(damage <= 0)
				return 0;
		}
		
		Random random = new Random();
		int actualDamage = damage - random.nextInt(damage)/2;
		health -= actualDamage;
		if (health < 0) {
            health = 0;
        }
		return actualDamage;
	}
	
	public boolean IsAlive() {
		return health > 0;
	}
	
	public int Attack(basedroid droid) {
		return droid.GetHit(this.damage);
	}
	
	public String DroidInfo() {
		return name + ": health - " + health + "/" + healthlimit + ", damage - " + damage + ", armor - " + armor;
	}
	
	public void Charge() {
	}
	
	public void Wait() {
	}
	
	
}

