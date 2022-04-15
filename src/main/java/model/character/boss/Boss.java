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

	private final Collection<SpecialAttack> specialAttacks;
	private BossState bossState;
	
	public Boss(final Vector hitbox, final Vector position, final Health health) {
		super(hitbox, position, health);
		this.specialAttacks = new LinkedList<>();
		this.specialAttacks.add(new Bomb());
		this.specialAttacks.add(new Missile());
		this.bossState = new FirstPhase();
	}
	
	public boolean doSpecialAttack() {
		return bossState.doSpecialAttack(this.specialAttacks);
	}
	
	public BossState getBossState() {
		return this.bossState;
	}
	
	public void changeState(final BossState bossState) {
		this.bossState = bossState;
	}

}
