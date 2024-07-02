import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        //3.1 - Aqui estou inserindo todos os funcionários
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));


        // 3.2 - Removendo o funcionário "João"
        Iterator<Funcionario> iterator = funcionarios.iterator();
        while (iterator.hasNext()) {
            Funcionario f = iterator.next();
            if (f.getNome().equals("João")) {
                iterator.remove();
            }
        }

        // 3.3 - Imprimindo todos os funcionários
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }

        //3.4 - Aumentando o salário em 10%
        for (Funcionario f : funcionarios) {
            f.setSalario(f.getSalario().multiply(new BigDecimal("1.1")));
        }

        //3.5 - Agrupando os funcionários por função
        // Não sei fazer ainda, mas vou aprender!


        //3.6 - Imprindo os funcionários agrupados por função
        // Não sei fazer ainda, mas vou aprender!

        //3.7 - Não havia nada para ser executado no Teste

        // 3.8 - Imprindo funcionários com aniversário em outubro e dezembro
        for (Funcionario f : funcionarios) {
            Month mes = f.getDataNascimento().getMonth();
            if (mes == Month.OCTOBER || mes == Month.DECEMBER) {
                System.out.println(f);
            }
        }

        // 3.9 - Imprindo os funcionários com a maior idade
        Funcionario maisVelho = null;
        for (Funcionario f : funcionarios) {
            if (maisVelho == null || f.getDataNascimento().isBefore(maisVelho.getDataNascimento())) {
                maisVelho = f;
            }
        }
        if (maisVelho != null) {
            int idade = LocalDate.now().getYear() - maisVelho.getDataNascimento().getYear();
            System.out.println("Funcionário com maior idade: " + maisVelho.getNome() + ", Idade: " + idade);
        }


        // 3.10 - Imprimindo a lista de funcionários por ordem alfabética
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }


        // 3.11 - Imprimindo o total dos salários dos funcionários
        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (Funcionario f : funcionarios) {
            totalSalarios = totalSalarios.add(f.getSalario());
        }
        System.out.println("Total dos salários dos funcionários: " + totalSalarios);


        //3.12 - Imprimindo quantos salários mínimos ganha cada funcionário
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        for (Funcionario f : funcionarios) {
            BigDecimal salariosMinimos = f.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(f.getNome() + " ganha " + salariosMinimos + " salários mínimos.");
        }
    }
}