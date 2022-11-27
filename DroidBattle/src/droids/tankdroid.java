package droids;

public class tankdroid extends basedroid{
	private int cooldown;

	public tankdroid(String name, int health, int damage, int armor, int cooldown) {
		super(name, health, damage, armor);
		this.cooldown = cooldown;
	}
	
	public boolean IsReady(){
		return cooldown <= 0;
	}
	
	public void Wait() {
		cooldown++;
	}
	
	public int UseSuperShot(basedroid droid) {
		if(IsReady()) {
			cooldown += 5;
			return droid.GetHit(GetDamage() * 7);
		}
		return 0;
	}

}
