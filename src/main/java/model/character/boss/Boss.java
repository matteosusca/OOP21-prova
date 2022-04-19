package model.character.boss;

import java.util.Collection;
import java.util.LinkedList;

import model.character.Character;
import model.character.boss.specialAttack.Bomb;
import model.character.boss.specialAttack.Missile;
import model.character.boss.specialAttack.SpecialAttack;
import model.character.boss.state.BossState;
import model.character.boss.state.FirstPhase;
import model.character.tools.health.Health;
import util.Vector;

public class Boss extends Character {

	/**
	 * The collection that stores all available special attacks
	 * */
	private final Collection<SpecialAttack> specialAttacks;
	/**
	 * The boss' state outlines the states the boss acquires by transitioning through them throughout the battle.
	 * */
	private BossState bossState;
	
	private Boss(final BossBuilder builder) {
		super(builder.position, builder.hitbox, builder.health/*, builder.weapon*/);
		this.specialAttacks = new LinkedList<>();
		this.specialAttacks.add(new Bomb());
		this.specialAttacks.add(new Missile());
		this.bossState = new FirstPhase();
	}
	
	/**
	 * Executes a special attack.
	 * @return false if miss the attack
	 * */
	public boolean doSpecialAttack() {
		return bossState.doSpecialAttack(this.specialAttacks);
	}
	
	/**
	 * @return the current boss'state
	 * */
	public BossState getBossState() {
		return this.bossState;
	}
	
	/**
	 * Sets the current state at bossState
	 * */
	public void changeState(final BossState bossState) {
		this.bossState = bossState;
	}

	/**
	 * The boss builder
	 * */
	public static class BossBuilder {
		private Vector hitbox;
		private Vector position;
		private Health health;
		//private Weapon weapon;
		
		/**
		 * The method that sets the boss hitbox
		 * */
		public BossBuilder hitbox(final Vector hitbox) {
			this.hitbox = hitbox;
			return this;
		}
		
		/**
		 * The method that sets the boss position
		 * */
		public BossBuilder position(final Vector position) {
			this.position = position;
			return this;
		}
		
		/**
		 * The method that sets the boss health
		 * */
		public BossBuilder health(final Health health) {
			this.health = health;
			return this;
		}
		
		/**
		 * The method that sets the player weapon
		 * */
		/*public PlayerBuilder weapon(final Weapon weapon) {
		 *  this.weapon = weapon;
		 *  return this;*/
		
		/**
		 * The method that builds the boss with the set up values
		 * @throws IllegalStateException if at least one is null
		 * */
		public Boss build() {
		    this.consistencyCheck();
			return new Boss(this);
		}

        private void consistencyCheck() {
            if (this.health == null || this.hitbox == null
                    || this.position == null /*|| this.weapon == null*/) {
                throw new IllegalStateException();
            }
        }
	}
}
