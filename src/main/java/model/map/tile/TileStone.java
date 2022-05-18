package model.map.tile;

import util.Vector2D;
/**
 * 
 * @author filippo.gurioli
 *
 */
public class TileStone extends AbstractTile {

	public TileStone(final Vector2D position) {
		super(position, "src\\main\\resources\\DesertTilesetCompact.png");
	}

	@Override
	public boolean isCollidable() {
		return true;
	}

	@Override
	public boolean isTileable() {
		return true;
	}
}
