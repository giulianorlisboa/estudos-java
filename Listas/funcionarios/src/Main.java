import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a quantidade de funcionarios a serem cadastrados: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<Funcionario> funcionarios = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Funcionario N" + i + "º : ");
            System.out.print("Id: ");
            int idFuncionario = sc.nextInt();
            sc.nextLine();

            boolean idExiste = funcionarios.stream().anyMatch(f -> f.getId() == idFuncionario);
            if (idExiste) {
                System.out.println("Erro: ID já cadastrado. Tente novamente.");
                i--;
                continue;
            }

            System.out.print("Nome: ");
            String nomeFuncionario = sc.nextLine();
            System.out.print("Salario: ");
            double salarioFuncionario = sc.nextDouble();
            sc.nextLine();

            Funcionario funcionario = new Funcionario(idFuncionario, nomeFuncionario, salarioFuncionario);
            funcionarios.add(funcionario);
        }

        System.out.println("Insira o ID do funcionario que recebera um aumento de salário: ");
        int idAumento = sc.nextInt();

        System.out.println("Insira a porcentagem que será acrescida: ");
        double porcentagem = sc.nextDouble();

        Funcionario funcReceberaAumento = funcionarios.stream()
                .filter(f -> f.getId()==idAumento)
                .findFirst()
                .orElse(null);

        if (funcReceberaAumento == null){
            System.out.println("Funcionario não encontrado!!!");
            return;
        }

        System.out.println("Lista de funcionários antes do aumento: ");
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }

        System.out.println("--------------------------------------------------");
        System.out.println();
        funcReceberaAumento.aumentarSalario(porcentagem);

        System.out.println("Lista de funcionários após o aumento: ");
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }
        sc.close();
    }
}