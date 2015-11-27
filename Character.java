public class Character extends Tile{

    protected String name;
    protected String cclass;
    protected int rcor = 2;
    protected int ccor = 2;
    protected int hp;
    protected int defense;
    protected int attack;

    public Character(){
	// Sets attributes;
	super("@");
	name = "Thing";
	hp = 25;
	defense = 3;
	attack = 10;
    }

    public Character(String newName){
	super("@");
	hp = 25;
	defense = 3;
	attack = 10;
	name = newName;
    }

    public int getRcor(){
	return rcor;
    }
    public int getCcor(){
	return ccor;
    }
    public void setRcor(int newRcor){
	rcor = newRcor;
    }
    public void setCcor(int newCcor){
	ccor = newCcor;
    }
	
    public  boolean isAlive(){
	return hp > 0; // If the "hp" is above 0, return true;
    }

    public int getDefense(){
	return defense; // returns the defense
    }

    public void lowerHP(int dmg){
	hp -= dmg; // returns the "hp" after the "damage" has been applied
    }

    public int attack(Monster foe){
    	int damage;
    	damage = attack - foe.getDefense();
    	foe.lowerHP(damage);
    	return damage;
    }

    // public void normalize() {
		
    // 	defense = 40;
    // 	attack = 0.4;
		
    // }
	
    // public void specialize() {
    // 	defense-=10;
    // 	attack+=1;
    // }

    public void setName(String newName){
	name = newName;
    }
    
    public String getName(){
	return name;
    }
    public void setcclass(String newcclass){
	name = newcclass;
    }
    
    public String getcclass(){
	return cclass;
    }

   //  public String about(){
   // 	String info = "";
   // 	info += "Name: " + name + "\n";
   // 	//info += "Class: " + dude + "\n";
   // 	info += "hp: " + hp + "\n";
   // 	info += "Strength: " + strength + "\n";
   // 	info += "Defense: " + defense + "\n";
   // 	info += "Attack: " + attack + "\n";
   // 	return info;
   // }

}