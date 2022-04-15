package model.character.boss.state;

import java.util.Collection;
import java.util.Random;

import model.character.boss.specialAttack.SpecialAttack;

public class FirstPhase implements BossState {

	private final Random random;
	private final static double HITPROBABILITY = 0.3;
	
	public FirstPhase() {
		this.random = new Random();
	}

	@Override
	public boolean doSpecialAttack(final Collection<SpecialAttack> specialAttacks) {
		if (specialAttacks.isEmpty()) {
			throw new IllegalArgumentException();
		}
		if (random.nextDouble() <= HITPROBABILITY) {
			//it does not need to check if iterator hasNext() since it would have thrown the exception
			specialAttacks.iterator().next().attack();
			return true;
		}
		return false;
	}

}
