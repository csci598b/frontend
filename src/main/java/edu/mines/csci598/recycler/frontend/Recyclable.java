package edu.mines.csci598.recycler.frontend;

import edu.mines.csci598.recycler.frontend.RecyclableType;
import edu.mines.csci598.recycler.frontend.graphics.Coordinate;
import edu.mines.csci598.recycler.frontend.graphics.Displayable;
import edu.mines.csci598.recycler.frontend.graphics.Path;
import edu.mines.csci598.recycler.frontend.graphics.Sprite;
import edu.mines.csci598.recycler.frontend.utils.GameConstants;
import org.apache.log4j.Logger;

/**
 * Recyclables are things like bottles, plastic etc. that you would be swiping at.
 * They need to keep track of what kind of recyclable they are, and where state they are in.
 * <p/>
 * Created with IntelliJ IDEA.
 * User: jzeimen
 * Date: 10/20/12
 * Time: 9:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Recyclable implements Displayable {
    private static final Logger logger = Logger.getLogger(Recyclable.class);    
    
    private Sprite sprite;
    private RecyclableType type;
    private MotionState currentMotion;
    private Path path;

    public Recyclable(RecyclableType type, Path path, String imagePath) {
        this.type = type;
        this.path = path;
        currentMotion = MotionState.CHUTE;
        sprite = new Sprite(imagePath, (int)path.initialPosition().getX(), (int)path.initialPosition().getY());
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    public RecyclableType getType() {
        return type;
    }

    public void setMotionState(MotionState motion) {
        this.currentMotion = motion;
    }

    public MotionState getMotionState() {
        return currentMotion;
    }
    
    public boolean isTouchable(){
        return currentMotion.isTouchable();
    }
    
    public Path getPath(){
    	return path;
    }
    
    public void setPath(Path path){
    	this.path = path;
    }

    /**
     * checks for a collision with the given point.
     * Does *not* check if the item is touchable.
     *
     * @param point
     * @return
     */
    public boolean collidesWithPoint(Coordinate point) {
    	return sprite.isPointInside((int)point.getX(), (int)point.getY());
    }

	public Coordinate getPosition() {
		return sprite.getPosition();
	}

	public void setPosition(Coordinate location) {
		sprite.setPosition(location);
	}
	
	@Override
	public String toString(){
		return type + ", moving along path " + path + ", and in current motion state " + currentMotion;
	}


}
