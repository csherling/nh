import java.util.Scanner;

public class Base{

    private Tile[][] field;
    private int rcor;
    private int ccor;

    public Base(){
	field = new Tile[5][5];
	rcor = 2;
	ccor = 2;
	populate();
	Tile temp = new Tile("@");
	field[2][2] = temp;
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
	Tile te = new Tile(".");
	for(int i=0; i<field.length; i++){
	    for(int j=0; j<field[i].length; j++){	
	 	this.field[i][j] = te;	    
	    }
	}
    }

    public void swap( int i, int j, int k, int l ) {
	Tile extra = field[i][j];
	field[i][j] = field[k][l];
	field[k][l] = extra;
    }

    public void move( int a, int b, int c, int d){
	swap(a, b, a + c, b + d);
	setRcor(a + c);
	setCcor(b + d);
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
	Boolean x = false;

	String dir = "";
	String op = "";

	while(x == false){
	    this.print2();
	    System.out.println("What do you want to do? m/q");
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