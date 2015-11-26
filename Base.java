import java.util.Scanner;

public class Base{

    private Tile[][] field;
    private int rcor;
    private int ccor;
    private Character you;

    public Base(){
	field = new Tile[9][9];
	rcor = 2;
	ccor = 2;
	populate();
	Character temp = new Character();
	field[2][2] = temp;
	Wall tem = new Wall();
	field[3][3] = tem;
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

    public void populate(){
	Floor te = new Floor();
	Wall wa = new Wall();
	for(int i=0; i<field.length; i++){
	    for(int j=0; j<field[i].length; j++){	
	 	this.field[i][j] = te;	    
	    }
	}
	for(int k=0; k<9; k++){
	    this.field[k][0] = wa;
	    this.field[k][8] = wa;
	    this.field[0][k] = wa;
	    this.field[8][k] = wa;
	}
    }

    public void swap( int i, int j, int k, int l ) {
	Tile extra = field[i][j];
	field[i][j] = field[k][l];
	field[k][l] = extra;
    }

    public void move( int a, int b, int c, int d){
	if(field[a+c][b+d].getSprite().equals(".")){
	    swap(a, b, a + c, b + d);
	    setRcor(a + c);
	    setCcor(b + d);
	}
	else{
	    System.out.println("Can't move there");
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

    public void play(){
	Scanner s = new Scanner(System.in);
	String g;
	String name = "";
	int character = 0;
	// s = "Welcome to Ye Olde RPG!\n";

	// s += "\nChoose your difficulty: \n";
	// s += "\t1: Easy\n";
	// s += "\t2: Not so easy\n";
	// s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
	// s += "Selection: ";
	// System.out.print( s );

	// try {
	//     difficulty = Integer.parseInt( in.readLine() );
	// }
	//catch ( IOException e ) { }

	g = "(State your name): ";
	System.out.print( g );

	if(s.hasNext()){
	    name = s.nextLine();
	}
	
	g = "What are ya?: Choose \n (1) Warrior \n (2) Archer \n";
	System.out.print( g );
	
	if(s.hasNext()){
	    character = Integer.parseInt( s.nextLine() );
	}
	//instantiate the player's character
	String cclass = "";
	if (character == 1) {
	    you = new Warrior( name );
	    cclass = "Warrior";
	}
	if (character == 2) {
	    you = new Archer( name );
	    cclass = "Archer";
	}

	Boolean x = false;

	String dir = "";
	String op = "";

	while(x == false){
	    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	    this.print2();
	    System.out.println(cclass + " " + name + ", What do you want to do? m/q");
	    if(s.hasNext()){
		op = s.nextLine();
	    }
	    
	    if(op.equals("m")){
		System.out.println("Which Way Do You Want To Move? (u/d/l/r/ul/ur/dl/dr)");
		if(s.hasNext()){
		    dir = s.nextLine();
		}
	    
		if(dir.equals("u")){
		    move(getRcor(),getCcor(), -1, 0);
		}
		if(dir.equals("d")){
		    move(getRcor(),getCcor(), 1, 0);
		}
		if(dir.equals("l")){
		    move(getRcor(),getCcor(), 0, -1);
		}
		if(dir.equals("r")){
		    move(getRcor(),getCcor(), 0, 1);
		}
		if(dir.equals("ul")){
		    move(getRcor(),getCcor(), -1, -1);
		}
		if(dir.equals("ur")){
		    move(getRcor(),getCcor(), -1, 1);
		}
		if(dir.equals("dl")){
		    move(getRcor(),getCcor(), 1, -1);
		}
		if(dir.equals("dr")){
		    move(getRcor(),getCcor(), 1, 1);
		}
	    }
	    if(op.equals("q")){
		break;
	    }
	}

    }
    public static void main(String[] args){
    	Base u = new Base();
	u.play();
    }

}