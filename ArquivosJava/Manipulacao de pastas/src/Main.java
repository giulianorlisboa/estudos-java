void main() {
    Scanner sc = new Scanner(System.in);

    IO.println("Digite o caminho de uma pasta: ");
    String strPath = sc.nextLine();

    File path = new File(strPath);

    File[] folders = path.listFiles(File::isDirectory);
    IO.println("Pastas: ");
    for (File f : folders) {
        IO.println(f);
    }

    File[] files = path.listFiles(File::isFile);
    for (File f : files) {
        IO.println(f);
    }

    boolean sucess = new File(strPath + "\\subdiretorio").mkdir();
    IO.println("Pasta criada com sucesso: " + sucess);


    sc.close();
}