package controller.map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import util.map.TextMap;
import model.map.MapModel;
import model.map.tile.Tile;
import model.map.tile.TileAir;
import model.map.tile.TileMetal;
import model.map.tile.TileStone;
import util.Vector;

public class MapController {

	private final MapModel mapModel;
	private Vector playerSpawn;

	public MapController(final TextMap textMap, final int offset) throws IOException {
		mapModel = new MapModel();
		final File mapTxt = textMap.getFile();
		final BufferedReader mapTxtInput = new BufferedReader(new FileReader(mapTxt));
		for(int i = 0; i < textMap.getHeight(); i++) {
			int j = 0;
			while(j < textMap.getWidth()) {
				final int check = mapTxtInput.read();
				if(check == '0') {	
					mapModel.addTile(new TileAir(new Vector(j+offset, i)));
					j++;
				} else if(check == '1') {
					mapModel.addTile(new TileStone(new Vector(j+offset, i)));
					j++;
				} else if(check == '2') {
					mapModel.addTile(new TileMetal(new Vector(j+offset, i)));
					j++;
				} else if(check == 'p')	{
					mapModel.addTile(new TileAir(new Vector(j+offset, i)));
					playerSpawn = new Vector(j, i);
					j++;
				}
			}
		}
		mapTxtInput.close();
	}

	public List<Vector> getTileables(){
		return mapModel.getAllTiles().stream().filter(t -> t.isTileable()).map(t -> t.getPosition()).collect(Collectors.toList());
	}
	
	public List<Vector> getNonTileables() {
		return mapModel.getAllTiles().stream().filter(t -> t.isTileable() == false).map(t -> t.getPosition()).collect(Collectors.toList());
	}
	public List<Vector> getCollidables() {
	    return mapModel.getAllTiles().stream().filter(t -> t.isCollidable()).map(t -> t.getPosition()).collect(Collectors.toList());
	}
	
	public List<Vector> getAllTiles(){
		return mapModel.getAllTiles().stream().map(t -> t.getPosition()).collect(Collectors.toList());
	}
	
	public boolean hasSingleCollidable(final Vector position) {
	    final var tmp = mapModel.getAllTiles().stream().filter(t -> t.getPosition().getX() == 
                Math.floor(position.getX())).filter(t -> t.getPosition().getY() == 
                Math.floor(position.getY())).findFirst();
	    if (tmp.equals(Optional.empty())) {
	        return false;
	    }
		return tmp.get().isCollidable();
	}
	
	public Optional<Tile> getTile(final Vector position) {
		return mapModel.getAllTiles().stream().filter(t -> t.getPosition().equals(position)).findFirst();
	}
	
	public Optional<Tile> getTile(final Vector position, final List<Tile> tileList){
		return tileList.stream().filter(t -> t.getPosition().equals(position)).findFirst();
	}

	public Vector getPlayerSpawn() {
		return playerSpawn;
	}

}
