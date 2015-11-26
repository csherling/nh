public class Terrain extends Tile{

    protected boolean canWalk;

    public Terrain(){
	super(".");
    }

    public Terrain(String newSprite){
	super(newSprite);
    }

    public Terrain(String newSprite, Boolean walk){
	super(newSprite, walk);
    }

}