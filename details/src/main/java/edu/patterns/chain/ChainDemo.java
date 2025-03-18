package edu.patterns.chain;

public class ChainDemo {


    public static void oneFilterNodeDemo(String... args){
        StringFilter trimFilter = new TrimFilter();
        String input = "     lllllllll     ";

        String result = trimFilter.process(input);

        System.out.println("Вхідний рядок: |" + input + "|");
        System.out.println("Оброблений рядок: |" + result + "|");
    }
    public static void main(String[] args) {

        StringFilter digitFilter = new DigitFilter();
        StringFilter trimFilter = new TrimFilter();

        digitFilter.setNext(trimFilter);


        String input = "  123 Hello  456  ";

        String result = digitFilter.process(input);


        System.out.println("Вхідний рядок: |" + input + "|");
        System.out.println("Оброблений рядок: |" + result + "|");
    }
}
