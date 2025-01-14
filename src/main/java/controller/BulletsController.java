package controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.character.Character;
import model.weapons.Bullet;

/**
 * TODO: write javadoc.
 *
 */
public class BulletsController {
	private Controller controllerReference;
	private List<Bullet> bullets;
	
	public BulletsController(final Controller controllerReference) {
		this.controllerReference = controllerReference;
		this.bullets = new LinkedList<>();
	}
	
	public void controllerTick() {
		bullets.forEach(b -> {
			final var characterColliding = this.checkCharactersColliding(b);
			final var tileColliding = this.checkTilesColliding(b);
			if (characterColliding.isPresent()) {
				b.hitSomething();
				characterColliding.get().getHealth().hurt(b.getDamage());
			} else if (this.controllerReference.getMapController().hasSingleCollidable(b.getPosition())) {
				b.hitSomething();
				// TODO: if the tile is breakable, tileColliding brakes here
			} else {
				b.tick();
			}
		});
		/*
		 * This line removes from this.bullets bullets that have hit something
		 */
		this.bullets = this.bullets.stream().filter(b -> b.hasHit() == false).collect(Collectors.toList());
	}
	
	public void addBullet(final Character owner) {
		this.bullets.add(new Bullet(owner));
	}
	
	/*
	 * This method checks if Bullet b is colliding with
	 * any of the current Characters in game
	 */
	private Optional<Character> checkCharactersColliding(final Bullet b) {
		for (final var c : this.controllerReference.getAllCharacters()) {
			if (b.isColliding(c)) {
				return Optional.of(c);
			}
		}
		return Optional.empty();
	}
	
	/*
	 * This method checks if Bullet b
	 * is colliding with any tile
	 */
	private Optional<Character> checkTilesColliding(final Bullet b) {
		// TODO: implementation based on Map implementation
		return Optional.empty();
	}
	
	public List<Bullet> getBullets() {
		return List.copyOf(this.bullets);
	}
}
