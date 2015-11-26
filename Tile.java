public class Tile{

    protected String sprite;

    public Tile(String x){
	sprite = x;
    }

    public void setSprite(String newSprite){
	sprite = newSprite;
    }
    public String toString(){
	String info = sprite;
	return info;
    }

    public boolean equals( Object o ) {
	//First, check for aliasing.
	boolean retVal = this == o;
	//Next, if this and input Object are different objects,
        if ( !retVal )
	    //...check to see if input Object is a Tile
	    retVal = o instanceof Tile 
		//...and that its state variables match those of this Tile
		&& this.sprite == ((Tile)o).sprite;
	return retVal;
    }

}