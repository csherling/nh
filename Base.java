import java.util.Scanner;

public class Base{

    private Tile[][] field;
    private Character you = new Character();
    private Floor flo;
    private String name;
    private String cclass;
    private Dwall dwal = new Dwall();
    private Lwall lwal = new Lwall();
    private Monster mon = new Monster(4, 4);
    private Monster mon1 = new Monster(4, 4);

    public Base(){
	field = new Tile[9][9];
	flo = new Floor();
	populate();
	field[2][2] = you;
	field[3][3] = dwal;
	field[4][4] = mon;
    }

    public void populate(){
	Floor te = new Floor();
	for(int i=0; i<field.length; i++){
	    for(int j=0; j<field[i].length; j++){	
	 	this.field[i][j] = te;	    
	    }
	}
	for(int k=0; k<9; k++){
	    this.field[k][0] = lwal;
	    this.field[k][8] = lwal;
	    this.field[0][k] = lwal;
	    this.field[8][k] = lwal;
	}
    }

    public void swap( int i, int j, int k, int l ) {
	Tile extra = field[i][j];
	field[i][j] = field[k][l];
	field[k][l] = extra;
    }

    public void move(int c, int d){
	int a = you.getRcor();
	int b = you.getCcor();
	if(field[a+c][b+d].getSprite().equals(".")){
	    swap(a, b, a + c, b + d);
	    you.setRcor(a + c);
	    you.setCcor(b + d);
	}
	else{
	    System.out.println("Can't move there");
	}
    }

    public void monMove(int c, int d){
	int a = mon.getRcor();
	int b = mon.getCcor();
	if(field[a+c][b+d].getSprite().equals(".")){
	    swap(a, b, a + c, b + d);
	    mon.setRcor(a + c);
	    mon.setCcor(b + d);
	}
	else{
	    System.out.println("Can't move there");
	}
    }

    public void chaseMonMove(){
	if(!((mon.getRcor() - you.getRcor() <= 1) 
	   && (mon.getRcor() - you.getRcor() >= -1)
	   && (mon.getCcor() - you.getCcor() <= 1)
	     && (mon.getCcor() - you.getCcor() >= -1))){

	    if(mon.getRcor() - you.getRcor() >= 1){
		monMove(-1, 0);
	    }
	    if(mon.getRcor() - you.getRcor() <= -1){
		monMove(1, 0);
	    }
	    if(mon.getCcor() - you.getCcor() >= 1){
		monMove(0, -1);
	    }
	    if(mon.getCcor() - you.getCcor() <= -1){
		monMove(0, 1);
	    }
	}
	else{
	    mon.attack(you);
	    you.attack(mon);
	}
    }

    public void aggMonMove(){
	if((mon.getRcor() - you.getRcor() <= 1) 
	   && (mon.getRcor() - you.getRcor() >= -1)
	   && (mon.getCcor() - you.getCcor() <= 1)
	   && (mon.getCcor() - you.getCcor() >= -1)){

	    if(mon.getRcor() - you.getRcor() <= 1
	       && (mon.getRcor() - you.getRcor() > 0) ){
		mon.attack(you);
		you.attack(mon);
	    }
	    if(mon.getRcor() - you.getRcor() >= -1
	       && (mon.getRcor() - you.getRcor() < 0) ){
		mon.attack(you);
		you.attack(mon);
	    }
	    if(mon.getCcor() - you.getCcor() <= 1
	       && (mon.getCcor() - you.getCcor() > 0) ){
		mon.attack(you);
		you.attack(mon);
	    }
	    if(mon.getCcor() - you.getCcor() >= -1
	       && (mon.getCcor() - you.getCcor() < 0) ){
		mon.attack(you);
		you.attack(mon);
	    }
	}
	else{
	    monMove((int)(Math.random() * 3) - 1, (int)(Math.random() * 3) - 1);
	}
    }

    public void evasiveMonMove(){
	if(((mon.getRcor() - you.getRcor() <= 1) 
	    && (mon.getRcor() - you.getRcor() > 0)) 
	   || ((mon.getRcor() - you.getRcor() >= -1)
	    && (mon.getRcor() - you.getRcor() < 0)) 
	   || ((mon.getCcor() - you.getCcor() <= 1)
	    && (mon.getCcor() - you.getCcor() > 0)) 
	   || ((mon.getCcor() - you.getCcor() >= -1)//could use abs
	    && (mon.getCcor() - you.getCcor() < 0))){

	    if(mon.getRcor() - you.getRcor() <= 1
	       && (mon.getRcor() - you.getRcor() > 0) ){
		monMove(1, 0);
	    }
	    if(mon.getRcor() - you.getRcor() >= -1
	       && (mon.getRcor() - you.getRcor() < 0) ){
		monMove(-1, 0);
	    }
	    if(mon.getCcor() - you.getCcor() <= 1
	       && (mon.getCcor() - you.getCcor() > 0) ){
		monMove(0, 1);
	    }
	    if(mon.getCcor() - you.getCcor() >= -1
	       && (mon.getCcor() - you.getCcor() < 0) ){
		monMove(0, -1);
	    }
	}
	else{
	    monMove((int)(Math.random() * 3) - 1, (int)(Math.random() * 3) - 1);
	}
    }

    public void kill(int c, int d){
	int a = you.getRcor();
	int b = you.getCcor();
	if(field[a+c][b+d].getSprite().equals("M")){
	    field[a + c][b + d] = flo;
	    mon.die();
	}
	else{
	    System.out.println("You strike the air");
	}
    }

    public void fight(int c, int d, Monster m){
	int a = you.getRcor();
	int b = you.getCcor();
	if(field[a+c][b+d].getSprite().equals("M")){
	    you.attack(m);
	    m.attack(you);
	}
	else{
	    System.out.println("You strike the air");
	}
    }

    public void print2() {
    	Tile [] [] a = this.field;
    	for (Tile [] s: a) {
    	    for (Tile x: s) {
    		System.out.print(x);
    	    }
    		
    	    System.out.println();
    	} 
    }

    public void setup(){
	Scanner s = new Scanner(System.in);
	String g;
	int character = 0;

	g = "(State your name): ";
	System.out.print( g );

	if(s.hasNext()){
	    name = (s.nextLine());
	}
	
	

	g = "What are ya?: Choose \n (1) Warrior \n (2) Archer \n";
	System.out.print( g );
	
	if(s.hasNext()){
	    character = Integer.parseInt( s.nextLine() );
	}
	//instantiate the player's character
	if (character == 1) {
	    you = new Warrior( name );
	    cclass = "Warrior";
	}
	if (character == 2) {
	    you = new Archer( name );
	    cclass = "Archer";
	}

    }

    public void turn(){
	Scanner s = new Scanner(System.in);
	String dir = "";
	String op = "";

	while(you.isAlive()){
	    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	    this.print2();
	    System.out.println(mon.getRage() + " " + cclass + " " + name + " " + you.getHP());
	    System.out.println("What do you want to do? m/k/a/q");

	    // if(op.equals("s")){
	    // 	spawnMon();
	    // }
	    
	    if(s.hasNext()){
		op = s.nextLine();
	    }

	    if(op.equals("k")){
		System.out.println("Which Way Do You Want To Kill? (u/d/l/r/ul/ur/dl/dr)");
		if(s.hasNext()){
		    dir = s.nextLine();
		}
	    
		if(dir.equals("u")){
		    kill(-1, 0);
		}
		if(dir.equals("d")){
		    kill(1, 0);
		}
		if(dir.equals("l")){
		    kill(0, -1);
		}
		if(dir.equals("r")){
		    kill(0, 1);
		}
		if(dir.equals("ul")){
		    kill(-1, -1);
		}
		if(dir.equals("ur")){
		    kill(-1, 1);
		}
		if(dir.equals("dl")){
		    kill(1, -1);
		}
		if(dir.equals("dr")){
		    kill(1, 1);
		}
	    }

	    if(op.equals("a")){
		System.out.println("Which Way Do You Want To Attack? (u/d/l/r/ul/ur/dl/dr)");
		if(s.hasNext()){
		    dir = s.nextLine();
		}
	    
		if(dir.equals("u")){
		    fight(-1, 0, mon);
		}
		if(dir.equals("d")){
		    fight(1, 0, mon);
		}
		if(dir.equals("l")){
		    fight(0, -1, mon);
		}
		if(dir.equals("r")){
		    fight(0, 1, mon);
		}
		if(dir.equals("ul")){
		    fight(-1, -1, mon);
		}
		if(dir.equals("ur")){
		    fight(-1, 1, mon);
		}
		if(dir.equals("dl")){
		    fight(1, -1, mon);
		}
		if(dir.equals("dr")){
		    fight(1, 1, mon);
		}
	    }

	    if(op.equals("m")){
		System.out.println("Which Way Do You Want To Move? (u/d/l/r/ul/ur/dl/dr)");
		if(s.hasNext()){
		    dir = s.nextLine();
		}
	    
		if(dir.equals("u")){
		    move(-1, 0);
		}
		if(dir.equals("d")){
		    move(1, 0);
		}
		if(dir.equals("l")){
		    move(0, -1);
		}
		if(dir.equals("r")){
		    move(0, 1);
		}
		if(dir.equals("ul")){
		    move(-1, -1);
		}
		if(dir.equals("ur")){
		    move(-1, 1);
		}
		if(dir.equals("dl")){
		    move(1, -1);
		}
		if(dir.equals("dr")){
		    move(1, 1);
		}
	    }

	    if(op.equals("q")){
		break;
	    }
	    if(mon.isAlive()){
		if(mon.getRage() == -1){
		    evasiveMonMove();
		}
		if(mon.getRage() == 0){
		    monMove((int)(Math.random() * 3) - 1, (int)(Math.random() * 3) - 1);
		}
		if(mon.getRage() == 1){
		    aggMonMove();
		}
		if(mon.getRage() == 2){
		    chaseMonMove();
		}
	    }
	    else{
		field[mon.getRcor()][mon.getCcor()] = flo;
		mon = mon1;
		mon.setRage((int)(Math.random()*4) - 1);
		field[4][4] = mon;
		mon.setHp(10);
		mon.setLife(true);
	    }
	}
    }

    public void play(){
	setup();
	turn();

    }
    public static void main(String[] args){
    	Base u = new Base();
	u.play();
    }

}