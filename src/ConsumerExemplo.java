
import java.util.Arrays;
import java.util.List;


public class ConsumerExemplo {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1,2,35,5,7,34,21,35,765,6,7,8,88231,24,46);


        numeros.stream().forEach(numero -> {if(numero % 2 ==0){
        System.out.println(numero);}
        });
}}
