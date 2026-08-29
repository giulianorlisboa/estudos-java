void main(){

    String path = "c:\\temp\\in.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        String line = br.readLine();

        while (line != null) {
            IO.println(line);
            line = br.readLine();
        }
    } catch (IOException e) {
        IO.println("error: " + e.getMessage());
    }
}