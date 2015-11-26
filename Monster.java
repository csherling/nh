/*
  Team GitRekt - Sachal Malick, Vincent Alykin, Christopher Sherling
  APCS1 pd5
  HW30 -- Ye Olde Role Playing Game Expanded
  2015-11-15
*/

public class Monster extends Character{


    
    public Monster () {
	super();
    }
	
    public void setStrength(int newStrength){
	strength = newStrength;
    }

    public void confuse(){
	strength = -100;
    }

    // public  boolean isAlive(){
    // 	return hp > 0; // If the "hp" is above 0, return true;
    // }

    // public int getDefense(){
    // 	return defense; // returns the defense
    // }

    // public String getName(){
    // 	return name; // returns  the name
    // }

    // public void lowerHP(int dmg){
    // 	hp -= dmg; // returns the "hp" after the "damage" has been applied
    // }

    // public int attack(Warrior war){
    // 	int damage;
    // 	damage = (int)(strength * attack) - war.getDefense();
    // 	war.lowerHP(damage);
    // 	return damage;
    // }


    // public int attack(Sachal foe){
    // 	int damage;
    // 	damage = (int)(strength * attack) - foe.getDefense(); // sets damage
    // 	double x = Math.random();
    // 	if (x < 1.0f/2.0f){
    // 	    damage = damage * -1;
    // 	    foe.lowerHP(damage);
    // 	    System.out.print("Confused");
    // 	}
    // 	else
    // 	    foe.lowerHP(damage);
    // 	return damage;
    // }

}