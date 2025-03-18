package edu.patterns.builder;

public class BuilderDemo {
    public static void main(String... args) {


        String name = obtainName();
        Integer age = obtainAge();

        PersonBuilder b = new PersonBuilder();

        if (name != null) {
            b.setName(name);
        }

        if (age != null) {
            b.setAge(age);
        }
        System.out.println(b.build());

        onelinerDemo();
        strBuilder();
    }

    public static String obtainName() {
        return null;
    }

    public static Integer obtainAge() {
        return 11;
    }

    public static void onelinerDemo() {

        System.out.println("creating in one line:" + new PersonBuilder()
                .setAge(11).setName("Taras")
                .setCity("Kyiv").build());
    }

    public static void strBuilder(){
        StringBuilder a = new StringBuilder("something");
        String res = a.append("and something").append(" and once more").append(" and more")
                .reverse().toString();
    System.out.println(res);
    }

}
