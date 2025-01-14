package view.map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

import controller.map.MapController;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import util.Vector2D;
import util.map.MapConstants;
/**
 * 
 * @author filippo.gurioli
 *
 */
public class MapView {

	private final List<Node> nodes = new LinkedList<>();

	public MapView(final MapController mapController, final double tileSize) throws FileNotFoundException {
		final List<Vector2D> list = mapController.getTileables();
		final AutotileManager autotileManager = new AutotileManager(list);
		for (final var position : list) {
			//Group tileImage = null; // Will never be null, map is composed of solely PASSABLE or NON-PASSABLE tiles,
									// and as such will never evade the if construct.

			final Group tileImage = autotileManager.autotile(position, tileSize*MapConstants.getTilesize(),
					new Image(new FileInputStream(mapController.getTile(position).get().getPath())).getPixelReader());

			tileImage.setScaleX(tileSize);
			tileImage.setScaleY(tileSize);

			nodes.add(tileImage);
		}
	}

	public List<Node> getNodes() {
		return this.nodes;
	}

}
