package edu.patterns.iterator;

import edu.patterns.factory.GameCharacter;
import edu.patterns.factory.Team;
import edu.patterns.factory.abs.FireWarrior;
import edu.patterns.factory.abs.FireWizard;
import edu.patterns.factory.abs.WaterWizard;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class IteratorDemo {
//  Iterable

    public static void main(String... args) {
        Team ourTeam = buildTeam();

        /*
        Iterator<GameCharacter> i1 = ourTeam.getWarriors().iterator();
        while (i1.hasNext()){
            i1.next().attack();
        }
        i1= ourTeam.getWizzards().iterator();
        while (i1.hasNext()){
            i1.next().attack();
        }
         */

        Iterator<GameCharacter> i1 = ourTeam.getCharactersIterator();
        while (i1.hasNext()){
            i1.next().attack();
        }
    }

    private static Team buildTeam(){
        Team result = new Team();
        result.getWarriors().add(new FireWarrior());
        result.getWarriors().add(new FireWarrior());
        result.getWarriors().add(new FireWarrior());
        result.getWarriors().add(new FireWarrior());
        result.getWarriors().add(new FireWarrior());

        result.getWizzards().add(new FireWizard());
        result.getWizzards().add(new FireWizard());
        result.getWizzards().add(new FireWizard());
        result.getWizzards().add(new FireWizard());

        result.getWaterWizards().add(new WaterWizard());
        result.getWaterWizards().add(new WaterWizard());
        return result;
    }
    public static void simepleDemo(String... args) {
        Set<Integer> ints = new TreeSet<>();
        ints.add(2);
        ints.add(15);
        ints.add(122);
        ints.add(4);
        ints.add(19);
        ints.add(4);
        ints.add(5);

        System.out.println(ints.size());

        System.out.println("iteration:");
        Iterator<Integer> r = ints.iterator();
        while(r.hasNext()){
            int n = r.next();
            System.out.println(n);

            if (n == 19 ){
                r.remove();
            }
        }
        System.out.println("end");
    }
}
