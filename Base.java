import java.util.Scanner;

public class Base{

    private String[][] field;
    private int rcor;
    private int ccor;

    public Base(){
	field = new String[5][5];
	rcor = 2;
	ccor = 2;
	populate();
	field[2][2] = "@";
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
	for(int i=0; i<field.length; i++){
	    for(int j=0; j<field[i].length; j++)
	 	this.field[i][j] = ".";	    
	}
    }

    public void swap( int i, int j, int k, int l ) {
	String extra = field[i][j];
	field[i][j] = field[k][l];
	field[k][l] = extra;
    }

    public void move( int a, int b, int c, int d){
	swap(a, b, a + c, b + d);
	setRcor(a + c);
	setCcor(b + d);
    }

    public void print2() {
    	String [] [] a = this.field;
    	for (String [] s: a) {
    	    for (String x: s) {
    		System.out.print(x);
    	    }
    		
    	    System.out.println();
    	} 
    }

    public void play(){
	Scanner s = new Scanner(System.in);
	Boolean x = false;

	String dir = "";


	while(x == false){
	    this.print2();
	    System.out.println("Which Way Do You Want To Move? (u/d/l/r)");
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

	}

    }
    public static void main(String[] args){
    	Base u = new Base();
	u.play();
    }

}