/*
  Team GitRekt - Sachal Malick, Vincent Alykin, Christopher Sherling
  APCS1 pd5
  HW30 -- Ye Olde Role Playing Game Expanded
  2015-11-15
*/

public class Rogue extends Character{

    private String name;

    public Rogue(String newName){
	// Sets attributes
	super(newName);
	hp = 75;
	strength = 75;
	defense = 25;
	attack = 0.5;
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
	double x = Math.random();
	if (x < 1.0f/3.0f)
	    System.out.println("Evaded"); // returns the "hp" after the "damage" has been applied
	else
	    hp -= dmg;
    }

    public int attack(Monster mon){
	int damage;
	damage = (int)(strength * attack) - mon.getDefense(); // sets damage
    	mon.lowerHP(damage);
	return damage;
    }
	
    public void normalize() {
		
	defense = 30;
	attack = 1;
		
    }
	
    public void specialize() {
	defense-=10;
	attack+=1;
    }


}