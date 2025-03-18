package edu.patterns.factory;

public class Warrior implements GameCharacter {
    private int characterLevel;

    public Warrior(int characterLevel) {
        this.characterLevel = characterLevel;
    }

    @Override
    public void attack() {
        System.out.println("Warrior swings a sword!" + characterLevel + " times");
    }
}