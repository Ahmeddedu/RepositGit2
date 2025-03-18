package edu.patterns.factory.abs;

import edu.patterns.factory.GameCharacter;

public class WaterCharacterFactory implements AbstractCharacterFactory {
    @Override
    public GameCharacter createWizard() {
        return new WaterWizard();
    }

    @Override
    public GameCharacter createWarrior() {
        return new WaterWarrior();
    }
}