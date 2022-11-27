package battlegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import droids.basedroid;
import droids.attackdroid;
import droids.repairdroid;
import droids.tankdroid;

public class hangar {
	 public List<basedroid> droids = new ArrayList<>();
	 public List<basedroid> team1 = new ArrayList<>();
	 public List<basedroid> team2 = new ArrayList<>();
	 
	 public hangar() {
	 }
	 
	 public void AddDroid(Scanner scan) {
		 System.out.print("1 - to add attackdroid\n2 - to add repairdroid\n3 - to add tankdroid\n");
		 int inp = scan.nextInt();
		 switch(inp){
		 case 1 -> {
			 System.out.print("attackdroid priority\n1 - health\n2 - armor\n");
			 inp = scan.nextInt();
			 switch(inp) {
			 case 1 ->{
				 droids.add(new attackdroid("AH" + droids.size(), 100, 20, 15, 2));
			 }
			 case 2 ->{
				 droids.add(new attackdroid("AA" + droids.size(), 50, 20, 20, 2));
			 }
			 }
		 }
		 case 2 ->{
			 System.out.print("repairdroid priority\n1 - health\n2 - armor\n3 - repair\n");
			 inp = scan.nextInt();
			 switch(inp) {
			 case 1 ->{
				 droids.add(new repairdroid("RH" + droids.size(), 100, 15, 15));
			 }
			 case 2 ->{
				 droids.add(new repairdroid("RA" + droids.size(), 50, 15, 25));
			 }
			 case 3 ->{
				 droids.add(new repairdroid("RR" + droids.size(), 60, 20, 15));
			 }
			 }
		 }
		 case 3 ->{
			 System.out.print("tankdroid priority\n1 - damage\n2 - armor\n");
			 inp = scan.nextInt();
			 switch(inp) {
			 case 1 ->{
				 droids.add(new tankdroid("TD" + droids.size(), 100, 30, 10, 2));
			 }
			 case 2 ->{
				 droids.add(new tankdroid("TA" + droids.size(), 150, 10, 20, 2));
			 }
			 }
		 }
		 }
		 System.out.print(droids.get(droids.size() - 1).DroidInfo() + " created\n");
	 }
	 
	 public void RemoveDroid(String name) {
		 for(basedroid droid: droids) {
			 if(name.equals(droid.getName())){
				 droids.remove(droid);
				 System.out.print(droid.DroidInfo() + " removed\n");
			 }
		 }
	 }
	 
	 public void ListDroid() {
		 for(basedroid droid: droids) {
			 System.out.print(droid.DroidInfo() + "\n");
		 }
		 if(droids.isEmpty())
			 System.out.print("hangar is empty\n");
	 }
	 
	 public void AddDroidToTeam(String name, Scanner scan) {
		 System.out.print("wich team(1 or 2)");
		 int inp = scan.nextInt();
		 switch(inp){
		 case 1 -> {
			 for(basedroid droid: droids) {
				 if(name.equals(droid.getName())){
					 team1.add(droid);
					 System.out.print(droid.DroidInfo() + " added to team1\n");
				 }
			 }
		 }
		 case 2 -> {
			 for(basedroid droid: droids) {
				 if(name.equals(droid.getName())){
					 team2.add(droid);
					 System.out.print(droid.DroidInfo() + " added to team2\n");
				 }
			 }
		 }
		 
		 }
	 }
	 
	 public void ListDroidTeams() {
		 System.out.print("team1:\n");
		 for(basedroid droid: team1) {
			 System.out.print(droid.DroidInfo() + "\n");
		 }
		 if(team1.isEmpty())
			 System.out.print("team1 is empty\n");
		 
		 System.out.print("team2:\n");
		 for(basedroid droid: team2) {
			 System.out.print(droid.DroidInfo() + "\n");
		 }
		 if(team2.isEmpty())
			 System.out.print("team2 is empty\n");
	 }
	 
	 public String TeamInfo(int num) {
		 String info = "";
		 if(num == 1) {
			 for(basedroid droid: team1) {
				 info = info + droid.DroidInfo() + "\n";
			 }
		 }
		 if(num == 2) {
			 for(basedroid droid: team2) {
				 info = info + droid.DroidInfo() + "\n";
			 }
		 }
		 return info;
	 }
}
