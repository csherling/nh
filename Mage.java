/*
  Team GitRekt - Sachal Malick, Vincent Alykin, Christopher Sherling
  APCS1 pd5
  HW30 -- Ye Olde Role Playing Game Expanded
  2015-11-15
*/

public class Mage extends Character{

    private String name;

    public Mage(String newName){
	// Sets attributes
	super(newName);
	hp = 100;
    }
	
    // public  boolean isAlive(){
    // 	return hp > 0; // If the "hp" is above 0, return true;
    // }

    // public int getDefense(){
    // 	return defense; // returns the defense
    // }

    // public String getName(){
    // 	return name; // returns the name
    // }

    public void lowerHP(int dmg){
	if (Math.random() < (1.00f/3.00f)) {
	    hp += dmg;
	    System.out.println("Monster Damage Healed!");
	}
	else {
	    hp -= dmg; // returns the "hp" after the "damage" has been applied
	}
    }

    // public void lifeDrain (int damage) {
    // 	hp += damage;
    // }
		
    public int attack(Monster mon){
     	int damage;
     	damage = (int)(strength * attack) - mon.getDefense(); // sets damage
     	mon.lowerHP(damage);
	// if (Math.random() < (1.00f/3.00f)) {
	//     lifeDrain(damage);
	//     System.out.println("Drain");
	// }
     	return damage;
    }
	


}