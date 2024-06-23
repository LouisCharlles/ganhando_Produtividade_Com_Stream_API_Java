import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorExemplo {
    //BinaryOperator recebe dois tipos dentro de si,mas pode ser simplificado a um só caso for usado apenas um.
    //BinaryOperator serve para reduzir numeros a um só nivel.
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1,2,3,4,6);

        BinaryOperator<Integer> somar = (x, y)-> x + y;

        int resultado = numeros.stream().reduce(0,Integer::sum );

        System.out.println(resultado);
    }
}
