package edu.patterns.factory.abs;

import edu.patterns.factory.GameCharacter;

public interface AbstractCharacterFactory {

    GameCharacter createWizard();

    GameCharacter createWarrior();

}
