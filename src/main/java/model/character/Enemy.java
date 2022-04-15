package model.character;

import model.character.tools.health.Health;
import util.Vector;

public class Enemy extends Character {

	private Enemy(final EnemyBuilder builder) {
		super(builder.hitbox, builder.position, builder.health);
	}
	
	/**
	 * The enemy builder
	 * */
	public static class EnemyBuilder {
		private Vector hitbox;
		private Vector position;
		private Health health;
		//private Weapon weapon;
		
		/**
		 * The method that sets the enemy hitbox
		 * */
		public EnemyBuilder hitbox(final Vector hitbox) {
			this.hitbox = hitbox;
			return this;
		}
		
		/**
		 * The method that sets the enemy position
		 * */
		public EnemyBuilder position(final Vector position) {
			this.position = position;
			return this;
		}
		
		/**
		 * The method that sets the enemy health
		 * */
		public EnemyBuilder health(final Health health) {
			this.health = health;
			return this;
		}
		
		/**
		 * The method that sets the enemy weapon
		 * */
		/*public EnemyBuilder weapon(final Weapon weapon) {
		 *  this.weapon = weapon;
		 *  return this;*/
		
		/**
		 * The method that builds the player with the set up values
		 * @throws IllegalStateException if at least one is null or if the lives are a negative number
		 * */
		public Enemy build() {
		    this.consistencyCheck();
			return new Enemy(this);
		}

        private void consistencyCheck() {
            if (this.health == null || this.hitbox == null || this.position == null /*|| this.weapon == null*/) {
                throw new IllegalStateException();
            }
        }
	}
}
