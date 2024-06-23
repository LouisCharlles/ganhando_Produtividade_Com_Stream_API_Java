import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierExemplo {
    public static void main(String[] args) {
        //Supplier<String> saudacao = () -> "Olá,prazer em te conhecer";

        List<String> saudacao5vezes = Stream.generate(()->  "Opa")
                .limit(5)
                .toList();

        saudacao5vezes.forEach(s -> System.out.println(s));
    }


}
