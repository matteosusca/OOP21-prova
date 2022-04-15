package model.character.boss.state;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import model.character.boss.specialAttack.SpecialAttack;

public class SecondPhase extends FirstPhase implements BossState {

	private final Random random;
	private final static double HITPROBABILITY = 0.1;
	
	public SecondPhase() {
		this.random = new Random();
	}

	@Override
	public boolean doSpecialAttack(final Collection<SpecialAttack> specialAttacks) {
		if (specialAttacks.isEmpty()) {
			throw new IllegalStateException();
		}
		final double hit = random.nextDouble();
		if (hit <= HITPROBABILITY) {
			Iterator<SpecialAttack> i = specialAttacks.iterator();
			i.next();
			i.next().attack();
			return true;
		} else {
			super.doSpecialAttack(specialAttacks);
		}
		return false;
	}
	
	
}
