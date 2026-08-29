void main(){

    String[] lines = new String[] { "Good morning", "Good afternoon", "Good night"};

    String path = "c:\\temp\\out.txt";

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
        for (String line : lines) {
            bw.write(line);
            bw.newLine();
        }
    }
    catch (IOException e) {
        e.printStackTrace();
    }

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        String line = br.readLine();
        while (line != null) {
            IO.println(line);
            line = br.readLine();
        }
    }catch (IOException e) {
        e.printStackTrace();
    }
}