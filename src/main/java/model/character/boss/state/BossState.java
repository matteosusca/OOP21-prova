package model.character.boss.state;

import java.util.Collection;

import model.character.boss.specialAttack.SpecialAttack;

public interface BossState {

	boolean doSpecialAttack(Collection<SpecialAttack> specialAttacks);
}
