public class Tile{

    protected String sprite;
    protected boolean canWalk;

    public Tile(String x){
	sprite = x;
	canWalk = false;
    }

    public Tile (String x, boolean walk){
	sprite = x;
	canWalk = walk;
    }

    public void setCanWalk(boolean walk){
	canWalk = walk;
    }

    public boolean getCanWalk(){
	return canWalk;
    }

    public void setSprite(String newSprite){
	sprite = newSprite;
    }

    public String getSprite(){
	return sprite;
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