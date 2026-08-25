import entities.CadastroPessoas;
import entities.Fisica;
import entities.Juridica;
import entities.Pessoa;

void main() {
    Scanner sc = new Scanner(System.in);
    CadastroPessoas cp = new CadastroPessoas();

    boolean rodando = true;
    do {
        IO.println("Digite a opção desejada: ");
        IO.println("1 - Cadastro");
        IO.println("2 - Listar cadastros");
        IO.println("3 - Atualizar cadastro");
        IO.println("4 - Deletar cadastro");
        IO.println("0 - Sair");
        int opcao = sc.nextInt();
        sc.nextLine();
        switch (opcao) {
            case 1:
                IO.print("Qual o tipo de pessoa que deseja cadastrar (F - física / J - juridica) ");
                String tipo = sc.nextLine();
                if (tipo.equalsIgnoreCase("F")) {
                    IO.print("Digite o seu nome completo: ");
                    String nomeCompleto = sc.nextLine();
                    IO.print("Endereço: ");
                    String endereco = sc.nextLine();
                    IO.print("Telefone: ");
                    Long telefone = sc.nextLong();
                    sc.nextLine();
                    IO.print("Email: ");
                    String email = sc.nextLine();
                    IO.print("CPF: ");
                    String cpf = sc.nextLine();
                    IO.print("Data de Nascimento: ");
                    LocalDate dataNascimento = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    Pessoa p = new Fisica(nomeCompleto, endereco, telefone, email, cpf, dataNascimento);
                    cp.cadastrar(p);
                    cp.exibirPessoas();

                } else if (tipo.equalsIgnoreCase("j")) {
                    IO.print("Digite o seu nome completo: ");
                    String nomeCompleto = sc.nextLine();
                    IO.print("Endereço: ");
                    String endereco = sc.nextLine();
                    IO.print("Telefone: ");
                    Long telefone = sc.nextLong();
                    sc.nextLine();
                    IO.print("Email: ");
                    String email = sc.nextLine();
                    IO.print("CNPJ: ");
                    String cpf = sc.nextLine();
                    IO.print("Nome fantasia: ");
                    String nomeFantasia = sc.nextLine();

                    Pessoa p = new Juridica(nomeCompleto, endereco, telefone, email, cpf, nomeFantasia);
                    cp.cadastrar(p);
                    cp.exibirPessoas();


                } else {
                    IO.println("Opção inserida é inválida, tente novamente");
                }
                break;

            case 2:
                System.out.println("Cadastros encontrados: ");
                cp.exibirPessoas();
                break;
            case 3:
                System.out.print("Qual o CPF ou CNPJ que deseja fazer alteração ? ");
                String documento = sc.nextLine();
                System.out.println("Qual dado deseja alterar ?");
                System.out.println("1 - Nome");
                System.out.println("2 - Endereço");
                System.out.println("3 - Telefone");
                System.out.println("4 - Email");
                int opcao2 = sc.nextInt();
                sc.nextLine();
                switch (opcao2) {
                    case 1:
                        System.out.print("Insira o nome que deseja atualizar: ");
                        String novoNome = sc.nextLine();
                        cp.alterarNome(documento, novoNome);
                        break;
                }

            case 0:
                rodando = false;
                break;
        }
    } while (rodando);
}