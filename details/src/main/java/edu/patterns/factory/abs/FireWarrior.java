package edu.patterns.factory.abs;

import edu.patterns.factory.GameCharacter;

public class FireWarrior implements GameCharacter {
    @Override
    public void attack() {
        System.out.println("🔥 Fire Warrior swings a flaming sword! 🔥");
        System.out.println("  \\|||||/  ");
        System.out.println("   (o_o)🔥===>");
        System.out.println("  / ||||| \\ ");
    }
}
