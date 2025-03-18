package edu.patterns.factory;

public class CharacterFactory {
    private int factoryLevel;

    public CharacterFactory(int factoryLevel) {
        this.factoryLevel = factoryLevel;
    }

    public GameCharacter createCharacter(String type) {
        if ("wizard".equalsIgnoreCase(type)) {
            return new Wizard(factoryLevel);
        } else if ("warrior".equalsIgnoreCase(type)) {
            return new Warrior(factoryLevel);
        } else {
            throw new IllegalArgumentException("Unknown character type: " + type);
        }
    }
}