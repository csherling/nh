public class Archer extends Character{

    private String name;

    public Archer(){
	// Sets attributes
	super();
	hp = 75;
	defense = 25;
	attack = 4;
    }
    public Archer(String newName){
	// Sets attributes
	super(newName);
	hp = 75;
	defense = 25;
	attack = 4;
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

    // public void lowerHP(int dmg){
    // 	hp -= dmg; // returns the "hp" after the "damage" has been applied
    // }


    // public void specialize(){
    // 	defense -= 10;
    // 	attack = Math.random() + 0.2; //Randomized accuracy
    // }

    // public int attack(Monster mon){
    //  	int damage;
    // 	damage = (int)(strength * attack) - mon.getDefense(); // sets damage
    //  	mon.lowerHP(damage);
    //  	return damage;
    //  }
	


}