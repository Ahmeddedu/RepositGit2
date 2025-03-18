package edu.patterns.factory.abs;

import edu.patterns.factory.GameCharacter;

public class FireCharacterFactory implements AbstractCharacterFactory {
    @Override
    public GameCharacter createWizard() {
        return new FireWizard();
    }

    @Override
    public GameCharacter createWarrior() {
        return new FireWarrior();
    }
}