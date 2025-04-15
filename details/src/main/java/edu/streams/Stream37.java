package edu.streams;

import java.util.Arrays;

public class Stream37 {

    public static void main(String... args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sollicitudin lectus dui, eu pretium quam feugiat a. Duis sollicitudin eu tortor at ornare. Suspendisse mollis vulputate purus vel imperdiet. Pellentesque in dictum velit, ac ultrices augue. Phasellus eu nulla dolor. Fusce non malesuada nisl. Duis sit amet nulla ac ipsum ultricies malesuada interdum pellentesque justo. Nulla venenatis turpis sit amet purus tempus faucibus. Duis quis mi mi. Praesent a ultricies tellus. Nulla facilisi. Praesent posuere lorem nec mauris aliquam, quis aliquam nibh sodales. Pellentesque ornare egestas risus, sed efficitur augue scelerisque quis. Vestibulum a massa risus";

        // вот так длинее 3
        long wordCount = Arrays.stream(text.split("\\s+"))
                .filter(word -> word.length() > 3)
                .count();
            System.out.println("Кол слов >3 " + wordCount);

        // необычн слова
        long uniqueWordCount = Arrays.stream(text.split("\\s+"))
                .filter(word -> word.length() > 3)
                .map(String::toLowerCase)
                .distinct()
                .count();
        System.out.println("Кол необыч слов " + uniqueWordCount);

        // duis
        long duisCount = Arrays.stream(text.split("\\s+"))
                .filter(word -> word.equalsIgnoreCase("duis"))
                .count();
        System.out.println("Слово Duis " + duisCount + " раз(а)");
    }
}