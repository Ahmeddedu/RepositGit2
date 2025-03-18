package edu.patterns.factory;

public class FactoryDemo {
    public static void main(String... args) {

        CharacterFactory factory = new CharacterFactory(3);

        GameCharacter wizard = factory.createCharacter("wizard");
        GameCharacter wizard2 = factory.createCharacter("wizard");
        GameCharacter warrior = factory.createCharacter("warrior");
        wizard.attack();
        wizard2.attack();
        warrior.attack();
        new CharacterFactory(10).createCharacter("wizard").attack();
    }
}