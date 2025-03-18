package edu.patterns.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Team {
    List<GameCharacter> warriors = new ArrayList<>();
    List<GameCharacter> wizzards = new ArrayList<>();
    List<GameCharacter> waterWizards = new ArrayList<>();

    public List<GameCharacter> getWaterWizards() {
        return waterWizards;
    }

    public void setWaterWizards(List<GameCharacter> waterWizards) {
        this.waterWizards = waterWizards;
    }

    public Iterator<GameCharacter> getCharactersIterator(){
        List<GameCharacter> allGuys = new ArrayList<>();
        allGuys.addAll(warriors);
        allGuys.addAll(wizzards);
        allGuys.addAll(waterWizards);
        return allGuys.iterator();
    }

    public List<GameCharacter> getWarriors() {
        return warriors;
    }

    public void setWarriors(List<GameCharacter> warriors) {
        this.warriors = warriors;
    }

    public List<GameCharacter> getWizzards() {
        return wizzards;
    }

    public void setWizzards(List<GameCharacter> wizzards) {
        this.wizzards = wizzards;
    }
}
