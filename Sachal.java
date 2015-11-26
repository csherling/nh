/*
  Team GitRekt - Sachal Malick, Vincent Alykin, Christopher Sherling
  APCS1 pd5
  HW30 -- Ye Olde Role Playing Game Expanded
  2015-11-15
*/


public class Sachal extends Character{

    private String name;

    public Sachal(String newName){
	// Sets attributes
	super(newName);
	hp = 75;
	strength = 60;
	defense = 30;
	attack = 0.3;
	
    }
	
    public void lowerHP(int dmg){
	double x = Math.random();
	if (x < 1.0f/4.0f)
	    System.out.println("Sachal Evaded!"); // Chance of evasion
	else
	    hp -= dmg;
    }

    // public int attack(Monster mon){
    	
    // 	return tryToBeMean(mon);

    // }
    
    public void specialize(){
     	defense -= 10;
     	attack = (int)(Math.random() * 3); // 1/3 chace of sachal confused
    }
    
    // public int tryToBeMean(Monster mon) {
    // 	int s = (int) (Math.random() * 2);
    // 	if (s == 1) {
    // 	    return confuse(mon);
    // 	}
    // 	else {
			
    // 	    return accidentallRaiseMonstersSelfAstee(mon);
    // 	}
    // }
    
    // public int accidentallRaiseMonstersSelfAstee(Monster mon) {
    // 	return 0;
    // }
    
    // public int confuse (Monster mon) {
    // 	int damage;
    // 	damage = (int)(strength * attack) - mon.getDefense(); // sets damage
    //     mon.lowerHP(damage);
    // 	return damage;
    // }
	
    public void normalize() {
		
    	defense = 25;
    	attack = .3;
    		
    }
    	
    // public void specialize() {
    // 	defense-=10;
    // 	attack+=1;
    // }

    public int attack(Monster mon){
     	int damage;
     	damage = (int)(strength * attack) - mon.getDefense(); // sets damage
	mon.lowerHP(damage);
	return damage;
    }

}