public class Monster extends Tile{
    
    protected String name;
    protected int rcor;
    protected int ccor;
    protected int hp;
    protected int defense;
    protected int attack;
    protected int rage;

    public Monster () {
	super("M");
	name = "Monster";
	hp = 10;
	defense = 2;
	attack = 5;
	rage = (int)(Math.random() * 3) - 1;
    }

    // public Monster (String newName) {
    // 	super("M");
    // 	name = newName;
    // 	hp = 10;
    // 	defense = 2;
    // 	attack = 5;
    // 	rage = (int)(Math.random() * 3) - 1;
    // }

    // public Monster (String newSprite, String newName) {
    // 	super(newSprite);
    // 	name = newName;
    // 	hp = 10;
    // 	defense = 2;
    // 	attack = 5;
    // 	rage = (int)(Math.random() * 3) - 1;
    // }

    // public Monster (String newSprite, String newName, int newr, int newc) {
    // 	super(newSprite);
    // 	name = newName;
    // 	hp = 10;
    // 	defense = 2;
    // 	attack = 5;
    // 	rcor = newr;
    // 	ccor = newc;
    // 	rage = (int)(Math.random() * 3) - 1;
    // }

    public Monster (int newr, int newc) {
	super("M");
	name = "Monster";
	hp = 10;
	defense = 2;
	attack = 5;
	rcor = newr;
	ccor = newc;
	rage = (int)(Math.random() * 4) - 1;
    }

    public int attack(Character foe){
    	int damage;
    	damage = attack - foe.getDefense();
    	foe.lowerHP(damage);
    	return damage;
    }


    public int getRcor(){
	return rcor;
    }
    public int getCcor(){
	return ccor;
    }
    public int getRage(){
	return rage;
    }
    public void setRcor(int newRcor){
	rcor = newRcor;
    }
    public void setCcor(int newCcor){
	ccor = newCcor;
    }
    public void die(){
	hp = 0;
    }
	
    
    // public void setStrength(int newStrength){
    // 	strength = newStrength;
    // }

    // public void confuse(){
    // 	strength = -100;
    // }

    public  boolean isAlive(){
	return hp > 0; // If the "hp" is above 0, return true;
    }

    public int getDefense(){
    	return defense; // returns the defense
    }

    // public String getName(){
    // 	return name; // returns  the name
    // }

    public void lowerHP(int dmg){
    	hp -= dmg; // returns the "hp" after the "damage" has been applied
    }

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