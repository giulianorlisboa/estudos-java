void main() {
    File file = new File("c:\\temp\\in.txt");
    Scanner sc = null;
    try {
        sc = new Scanner(file);
        while (sc.hasNextLine()) {
            IO.println(sc.nextLine());
        }
    } catch (IOException e) {
        IO.println("Erro: " + e.getMessage());
    } finally {
        if (sc != null) {
            sc.close();
        }
    }

}