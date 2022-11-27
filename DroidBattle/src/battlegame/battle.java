package battlegame;

import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import droids.basedroid;
import droids.attackdroid;
import droids.repairdroid;
import droids.tankdroid;

public class battle {
	
	public void start(hangar alldroids, List<basedroid> team1, List<basedroid> team2) {
		DateTimeFormatter time = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		try {
			File file = new File(System.getProperty("user.dir") + "\\src\\logs\\droid_battle-" + time.format(now) + ".txt");
			if(file.createNewFile()) {
				System.out.print("file created " + file.getName() + "\n");
			}
			else {
				System.out.print("file already exists" + "\n");
			}
		} catch (IOException e) {
			System.out.print("ERROR");
			e.printStackTrace();
		}
		try {
			FileWriter log = new FileWriter(System.getProperty("user.dir") + "\\src\\logs\\droid_battle-" + time.format(now) + ".txt");
			log.write("battle has begun\nteam1:\n" + alldroids.TeamInfo(1) + "\nteam2:\n" + alldroids.TeamInfo(2));
			System.out.print("battle has begun\nteam1:\n" + alldroids.TeamInfo(1) + "\nteam2:\n" + alldroids.TeamInfo(2));
			Random random = new Random();
			boolean battlecontinue = true;
			boolean anyteam1 = true;
			boolean anyteam2 = true;
			int roundcounter = 0;
			while (battlecontinue) {
				log.write("\n\n*********round " + ++roundcounter + "\n");
				System.out.print("\n\n*********round " + roundcounter + "\n");
				log.write("\n\nteam1 turn\n");
				System.out.print("\nteam1 turn\n");
				for(basedroid droid: team1) {
					if(!(droid.IsAlive() && anyteam2))
						continue;
					basedroid enemy;
					do {
						enemy = team2.get(random.nextInt(team2.size()));
					}while(!enemy.IsAlive());
					
					int damage;
					if(random.nextInt(3) == 0) {
						damage = droid.Attack(enemy);
						log.write(droid.getName() + " dealt " + damage + " damage to " + enemy.getName() + " by attack\n");
						System.out.print(droid.getName() + " dealt " + damage + " damage to " + enemy.getName() + " by attack\n");
					}
					else {
						String type = "" + droid.getClass();
						switch(type) {
						case "class droids.attackdroid" ->{
							attackdroid droidCheck = (attackdroid) droid;
							if(droidCheck.IsPowered()) {
								if(random.nextInt(3) == 0) {
									damage = droidCheck.UseMachineGun(enemy);
									log.write(droid.getName() + " dealt " + damage + " damage to " + enemy.getName() + " by MachineGun\n");
									System.out.print(droid.getName() + " dealt " + damage + " damage to " + enemy.getName() + " by MachineGun\n");
								}
								else {
									damage = droidCheck.UseSuperShot(enemy);
									log.write(droid.getName() + " dealt " + damage + " damage to " + enemy.getName() + " by SuperShot\n");
									System.out.print(droid.getName() + " dealt " + damage + " damage to " + enemy.getName() + " by SuperShot\n");
								}
							}
							else {
								droid.Charge();
								log.write(droid.getName() + " charged\n");
								System.out.print(droid.getName() + " charged\n");
							}
						}
						case "class droids.repairdroid"->{
							repairdroid droidCheck = (repairdroid) droid;
							enemy = team1.get(random.nextInt(team1.size()));
							damage = droidCheck.Repair(enemy);
							log.write(droid.getName() + " repaired " + enemy.getName() + " by "+ damage + " points\n");
							System.out.print(droid.getName() + " repaired " + enemy.getName() + " by "+ damage + " points\n");
						}
						case "class droids.tankdroid" ->{
							tankdroid droidCheck = (tankdroid) droid;
							if(droidCheck.IsReady()) {
								damage = droidCheck.UseSuperShot(enemy);
								log.write(droid.getName() + " dealt " + damage + " damage to " + enemy.getName() + " by SuperShot\n");
								System.out.print(droid.getName() + " dealt " + damage + " damage to " + enemy.getName() + " by SuperShot\n");
							}
							else {
								droid.Wait();
								log.write(droid.getName() + " waited\n");
								System.out.print(droid.getName() + " waited\n");
							}
						}
						}
					}
					anyteam2 = false;
					for(basedroid enemydroid: team2) {
						if(enemydroid.IsAlive())
							anyteam2 = true;
					}
					
					
					
					
				}
				log.write("\nteam2 turn\n");
				System.out.print("\nteam2 turn\n");
				for(basedroid droid: team2) {
					if(!(droid.IsAlive() && anyteam1))
						continue;
					basedroid enemy;
					do {
						enemy = team1.get(random.nextInt(team1.size()));
					}while(!enemy.IsAlive());
					int damage;
					if(random.nextInt(3) == 0) {
						damage = droid.Attack(enemy);
						log.write(droid.getName() + " dealt " + damage + " damage to " + enemy.getName() + " by attack\n");
						System.out.print(droid.getName() + " dealt " + damage + " damage to " + enemy.getName() + " by attack\n");
					}
					else {
						String type = "" + droid.getClass();
						switch(type) {
						case "class droids.attackdroid" ->{
							attackdroid droidCheck = (attackdroid) droid;
							if(droidCheck.IsPowered()) {
								if(random.nextInt(3) == 0) {
									damage = droidCheck.UseMachineGun(enemy);
									log.write(droid.getName() + " dealt " + damage + " damage to " + enemy.getName() + " by MachineGun\n");
									System.out.print(droid.getName() + " dealt " + damage + " damage to " + enemy.getName() + " by MachineGun\n");
								}
								else {
									damage = droidCheck.UseSuperShot(enemy);
									log.write(droid.getName() + " dealt " + damage + " damage to " + enemy.getName() + "by SuperShot\n");
									System.out.print(droid.getName() + " dealt " + damage + " damage to " + enemy.getName() + " by SuperShot\n");
								}
							}
							else {
								droid.Charge();
								log.write(droid.getName() + " charged\n");
								System.out.print(droid.getName() + " charged\n");
							}
						}
						case "class droids.repairdroid"->{
							repairdroid droidCheck = (repairdroid) droid;
							enemy = team2.get(random.nextInt(team2.size()));
							damage = droidCheck.Repair(enemy);
							log.write(droid.getName() + " repaired " + enemy.getName() + " by "+ damage + " points\n");
							System.out.print(droid.getName() + " repaired " + enemy.getName() + " by "+ damage + " points\n");
						}
						case "class droids.tankdroid" ->{
							tankdroid droidCheck = (tankdroid) droid;
							if(droidCheck.IsReady()) {
								damage = droidCheck.UseSuperShot(enemy);
								log.write(droid.getName() + " dealt " + damage + " damage to " + enemy.getName() + " by SuperShot\n");
								System.out.print(droid.getName() + " dealt " + damage + " damage to " + enemy.getName() + " by SuperShot\n");
							}
							else {
								droid.Wait();
								log.write(droid.getName() + " waited\n");
								System.out.print(droid.getName() + " waited\n");
							}
						}
						}
					}
					anyteam1 = false;
					for(basedroid enemydroid: team1) {
						if(enemydroid.IsAlive())
							anyteam1 = true;
					}
				}
				
				
				
				
				log.write("\nteam1: \n");
				System.out.print("\nteam1: \n");
				anyteam1 = false;
				for(basedroid droid: team1) {
					log.write(droid.DroidInfo() + "\n");
					System.out.print(droid.DroidInfo() + "\n");
					if(droid.IsAlive())
						anyteam1 = true;
				}
				log.write("team2: \n");
				System.out.print("team2: \n");
				anyteam2 = false;
				for(basedroid droid: team2) {
					log.write(droid.DroidInfo() + "\n");
					System.out.print(droid.DroidInfo() + "\n");
					if(droid.IsAlive())
						anyteam2 = true;
				}
				battlecontinue = false;
				if(anyteam1 && anyteam2)
					battlecontinue = true;
				if(!battlecontinue) {
					if(anyteam1) {
						log.write("\n\nteam1 wom!!!\n");
						System.out.print("\n\nteam1 wom!!!\n");
					}
					if(anyteam2) {
						log.write("\n\nteam2 wom!!!\n");
						System.out.print("\n\nteam2 wom!!!\n");
					}
				}
			}
			log.close();
		} catch (IOException e) {
			System.out.print("ERROR");
			e.printStackTrace();
			
		}
	}

}
