package Desafios;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListaDeNumeros {
    public static boolean numeroPrimo(int num){
        if(num<=1){
            return false;
        }
        for(int i = 2;i<=Math.sqrt(num);i++){
            if(num % i ==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10,5,4,3);

        //Desafio 1:Organiza usando o sorted e encapsula os valores numa nova lista de Inteiros.
        System.out.println("A seguir a lista ordenada crescente:");
        List<Integer> ordemNumerica = numeros.stream().sorted().toList();

        System.out.println(ordemNumerica);

        System.out.println("---------------------------");

        //Desafio 2: Imprima a soma dos números pares da lista:
        System.out.println("A seguir a soma dos numeros pares:");
        int somaDosPares = numeros.stream().filter(numero->numero%2==0).mapToInt(Integer::intValue).sum();

        System.out.println(somaDosPares);

        System.out.println("---------------------------");

        //Desafio 3: Verifique se todos os números da lista são positivos:
        //All match confere se todos batem com a verificação lambda.
        System.out.println("A seguir, verifica se todos os numeros são positivos:");
        boolean todosPositivos = numeros.stream().allMatch(numero->numero>0);

        if(todosPositivos){
            System.out.println("Todos são positivos.");
        }
        else {
            System.out.println("Nem todos são positivos.");
        }
        System.out.println("---------------------------");

        //Desafio 4 - Remover valores impares da lista.
        System.out.println("A seguir, remove os valores impares e filtra apenas os pares:");

        List<Integer> removerValorImpar = numeros.stream().filter(numero->numero%2==0).toList();

        System.out.println(removerValorImpar);
        System.out.println("---------------------------");
        //Desafio 5:  Calcule a média dos números maiores que 5:
        System.out.println("A seguir, a média dos numeros maiores do que 5:");
        OptionalDouble mediaValorMaior5 = numeros.stream().filter(numero->numero>5).
                mapToInt(Integer::intValue).
                average();

        if(mediaValorMaior5.isPresent()){
            System.out.println(" O valor da sua média dos valores maiores que 5: "+mediaValorMaior5.getAsDouble());
        }
        else {
            System.out.println("Não há valores maiores que 5 na lista.");
        }
        System.out.println("---------------------------");
        //Desafio 6: Verificar se a lista contém algum número maior que 10:
        System.out.println("A seguir, verifica se a lista contém algum numero maior que 10:");
        boolean existeValorMaiorQueDez = numeros.stream().anyMatch(numero->numero>10);

        if(existeValorMaiorQueDez){
            System.out.println("Existe um valor maior que 10 na lista.");
        }
        else {
            System.out.println("Não existe valor algum maior que dez");
        }
        System.out.println("---------------------------");
        //Desafio 7: - Encontrar o segundo número maior da lista
        System.out.println("A seguir, encontra o segundo maior valor:");
         int maiorNumero = ordemNumerica.reversed().getFirst();

        List<Integer> listaMenoresMaiorNumero = numeros.stream()
                .filter(numero->numero<maiorNumero)
                .sorted()
                .toList();

        int segundoMaiorNumero = listaMenoresMaiorNumero.reversed().getFirst();

        System.out.println("Aqui está o segundo maior número: "+segundoMaiorNumero);

        //Segundo jeito de fazer:

        Optional<Integer> segundoMaiorValor = numeros.stream()
                .sorted((a,b)->b - a)
                .skip(1)
                .findFirst();

        if(segundoMaiorValor.isPresent()){
            //System.out.println("Aqui está o segundo maior valor: "+segundoMaiorValor.get());
        }
        else {
            //System.out.println("O segundo maior valor não está presente.");
        }
        System.out.println("---------------------------");
        //Desafio 8: Somar os dígitos de todos os números da lista
        System.out.println("A seguir, a soma de todos os digitos dos numeros da lista");
        BinaryOperator<Integer> somar = Integer::sum;

        int resultado = numeros.stream().reduce(0,somar);

        System.out.println(resultado);
        System.out.println("---------------------------");
        //Desafio 9: Verificar se todos os números da lista são distintos (não se repetem):
        System.out.println("Verifica se todos são distintos:");
        boolean todosDistintos = numeros.stream().distinct().count() == numeros.size();

        if(todosDistintos){
            System.out.println("Todos são distintos.");
        }
        else{
            System.out.println("Nem todos são distintos.");
        }
        System.out.println("---------------------------");
        //Desafio 10: Agrupar todos os multiplos de 3 ou 5.
        System.out.println("Agrupa todos os multiplos de 3 ou 5:");
        List<Integer> numerosMultiplosDeTresECinco = numeros.stream()
                .filter(numero->numero %3 ==0 || numero % 5 ==0)
                .toList();

        System.out.println(numerosMultiplosDeTresECinco);
        System.out.println("---------------------------");
        //Desafio 11:  Encontre a soma dos quadrados de todos os números da lista:
        System.out.println("A seguir, a soma dos quadrados de todos os numeros da lista:");
        Function<Integer,Integer> aoQuadrado = (numero)->numero*numero;

        List<Integer> valoresAoQuadrado = numeros.stream().map(aoQuadrado).toList();

        int resultadoFinal = valoresAoQuadrado.stream().reduce(0,Integer::sum);

        System.out.println(resultadoFinal);

        System.out.println("---------------------------");
        //Desafio 12:  Encontre o produto de todos os números da lista:
        System.out.println("A seguir, o produto de todos os números da lista:");
        BinaryOperator<Integer> produto = (numero1,numero2)->numero1*numero2;

        int produtoFinal = numeros.stream().reduce(1,produto);
        System.out.println(produtoFinal);
        System.out.println("---------------------------");

        //Desafio 13: Filtrar os números que estão num intervalo.
        System.out.println("A seguir, os números que estão num intervalo determinado:");
        List<Integer> intervalo = numeros.stream().filter(numero-> numero>5 && numero<10).toList();
        System.out.println(intervalo);
        System.out.println("---------------------------");

        //Desafio 14: Encontre o maior número primo da lista:
        System.out.println("A seguir, o maior numero primo da lista:");
        Optional<Integer> maiorPrimo = numeros.stream()
                .filter(ListaDeNumeros::numeroPrimo)
                .sorted()
                .max(Integer::compareTo);
        if(maiorPrimo.isPresent()){
            System.out.println(maiorPrimo.get());
        }
        else {
            System.out.println("Não o foi encontrado.");
        }
        System.out.println("---------------------------");

        //Desafio 15: Verifique se a lista contém pelo menos um número negativo:
        System.out.println("Verifica se a lista contém ao menos 1 numero negativo:");
        boolean verificaSeTemNegativo = numeros.stream().anyMatch(numero->numero<0);

        if(verificaSeTemNegativo){
            System.out.println("Existe um numero negativo na lista.");
        }
        else {
            System.out.println("Não há nenhum numero negativo na lista.");
        }
        System.out.println("---------------------------");

        //Desafio 16: Agrupe os números em pares e ímpares
        System.out.println("Agrupa os numeros em lista de pares e impares:");
        List<Integer> numerosPares = numeros.stream().filter(numero->numero%2==0).toList();

        List<Integer> numerosImpares = numeros.stream().filter(numero->numero%2!=0).toList();
        System.out.println("Impares :"+numerosImpares+" | Pares: :"+numerosPares);
        System.out.println("---------------------------");

        //Desafio 17:  Filtrar os números primos da lista
        System.out.println("A seguir, a lista de todos os números primos:");
        List<Integer> numerosPrimos = numeros.stream().filter(ListaDeNumeros::numeroPrimo).toList();

        System.out.println(numerosPrimos);
        System.out.println("---------------------------");

        //Desafio 18: Verifique se todos os números da lista são iguais:
        System.out.println("Verifica se todos os numeros são iguais:");
        boolean todosIguais = numeros.stream().allMatch(numero->numero.equals(numeros.getFirst()));

        if(todosIguais){
            System.out.println("Todos são iguais.");
        }
        else {
            System.out.println("Nem todos são iguais.");
        }
        System.out.println("---------------------------");
        //Desafio 19: Encontre a soma dos números divisíveis por 3 e 5:
        System.out.println("A seguir, a soma dos números divisiveis por 3 e 5:");
        Predicate<Integer> divisivelPorTresECinco = numero->numero %3 ==0 && numero %5 ==0;

        int listaDivisiveisPorTresECinco = numeros.stream()
                .filter(divisivelPorTresECinco).reduce(0,Integer::sum);

        System.out.println(listaDivisiveisPorTresECinco);




    }
}
