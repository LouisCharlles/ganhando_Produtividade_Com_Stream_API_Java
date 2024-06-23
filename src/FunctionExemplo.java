import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExemplo {
    public static void main(String[] args) {
        //Function<T,T> recebe dois tipos, um pra ser transformado e outro pra transformar.
        //É utilizado para transformar e mapear Streams em outros valores..

        List<Integer> numeros = Arrays.asList(1,2,3,4,5);

        Function<Integer,Integer> dobrar = numero -> numero * 2;

        List<Integer> numerosDobrados = numeros.stream().map(numero -> numero * 2)
                .toList();

        numerosDobrados.forEach(n ->System.out.println(n));
    }
}
