package model.character.boss.state;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import model.character.boss.specialAttack.SpecialAttack;

public class LastPhase implements BossState {

	private final static double HITPROBABILITY1 = 0.4;
	private final static double HITPROBABILITY2 = 0.2;
	private final Random random;
	
	public LastPhase() {
		this.random = new Random();
	}
	
	@Override
	public boolean doSpecialAttack(final Collection<SpecialAttack> specialAttacks) {
		if (specialAttacks.isEmpty()) {
			throw new IllegalArgumentException();
		}
		double value = random.nextDouble();
		if (value <= HITPROBABILITY2) {
			Iterator<SpecialAttack> i = specialAttacks.iterator();
			i.next();
			i.next().attack();
			return true;
		} else if (value <= HITPROBABILITY1) {
			specialAttacks.iterator().next().attack();
			return true;
		}
		return false;
	}

}
