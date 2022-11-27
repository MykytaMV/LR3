package battlegame;

import java.util.Scanner;

import droids.basedroid;

public class Menu {
	public Scanner scan = new Scanner(System.in);
	
	public void start(hangar H) {
		boolean continuechoise = true;
		System.out.print("welcome to the droid battle arena\n");
		while(continuechoise) {
			System.out.print("1 - add droid to hangar\n2 - add droid to team\n3 - fast create teams\n4 - remove droid from hangar\n5 - show all droids\n6 - show teams\n7 - start battle\n8 - exit\n");
			int inp = scan.nextInt();
			 switch(inp) {
			 case 1 ->{
				 H.AddDroid(scan);
			 }
			 case 2 ->{
				 System.out.print("enter droid name to add\n");
				 String name = scan.next();
				 H.AddDroidToTeam(name, scan);
			 }
			 case 3 ->{
				 for(basedroid droid: H.droids) {
					System.out.print(droid.getName() + " ");
					H.AddDroidToTeam(droid.getName(), scan);
				 }
			 }
			 case 4 ->{
				 System.out.print("enter droid name to remove\n");
				 String name = scan.next();
				 H.RemoveDroid(name);
			 }
			 case 5 ->{
				 H.ListDroid();
			 }
			 case 6 ->{
				 H.ListDroidTeams();
			 }
			 case 7->{
				 battle B = new battle();
				 B.start(H, H.team1, H.team2);
			 }
			 case 8->{
				 continuechoise = false;
				 scan.close();
			 }
			 }
		}
	}

}
