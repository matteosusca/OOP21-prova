package util;

import java.util.Date;

/**
 * 
 */
public class UserData {

    private final String name;
    private double points;
    private Date lastGame;
    
    public UserData(final String name) {
        this.name = name;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(final double points) {
        this.points = points;
    }

    public Date getLastGame() {
        return lastGame;
    }

    public void setLastGame(final Date lastGame) {
        this.lastGame = lastGame;
    }
    
    public String getName() {
        return this.name;
    }
}
