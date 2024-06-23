import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExemplo {
    public static void main(String[] args) {
        List<String> listaDeLinguagens = Arrays.asList("Kotlin","Python","JavaScript","Java","Ruby","Php");

        Predicate<String> menosDeCincoPalavras = palavra->palavra.length()>5;

        listaDeLinguagens.stream().filter(menosDeCincoPalavras).forEach(System.out::println);
    }

}
