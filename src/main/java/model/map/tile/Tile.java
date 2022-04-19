package model.map.tile;

import util.Vector;

public interface Tile {

    TileType getTileType();
    
    Vector getHitbox();
    
    Vector getPosition();

}