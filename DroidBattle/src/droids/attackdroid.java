package droids;

public class attackdroid extends basedroid {
	private int power;
	

	public attackdroid(String name, int health, int damage, int armor, int power) {
		super(name, health, damage, armor);
		this.power = power;
	}
	
	public void Charge() {
		power ++;
	}
	
	public int UseMachineGun(basedroid droid) {
		if(IsPowered()) {
			power --;
			int allActualDamage = 0;
			for(int i = 0; i < 5; i++) {
				allActualDamage += droid.GetHit(GetDamage()/4);
			}
			return allActualDamage;
		}
		else
			return 0;
	}
	
	public int UseSuperShot(basedroid droid) {
		if(IsPowered()) {
			power --;
			return droid.GetHit(GetDamage() * 2);
		}
		return 0;
	}
	
	public boolean IsPowered() {
		return power > 0;
	}
	
}
