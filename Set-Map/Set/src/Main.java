void main() {
    Set<Integer> alunos = new HashSet<>();
    Scanner scan = new Scanner(System.in);

    IO.print("Quantos estudantes para o curso A? ");

    lerCurso(scan, alunos);

    IO.print("Quantos estudantes para o curso B? ");
    lerCurso(scan, alunos);

    IO.print("Quantos estudantes para o curso C? ");
    lerCurso(scan, alunos);

    IO.println("Total de alunos: " + alunos.size());
}
void lerCurso(Scanner scan, Set<Integer> alunos) {
    int qtd = scan.nextInt();
    for (int i = 0; i < qtd; i++) {
        IO.print("Matricula do aluno: ");
        int matricula = scan.nextInt();
        alunos.add(matricula);
    }
}