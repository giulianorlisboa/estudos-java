void main(String[] args) {
    List<String> linhasSaida = new ArrayList<>();
    String path = "C:\\temp\\subdiretorio\\arquivo.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        String line = br.readLine();
        while (line != null) {
            String[] parts = line.split(",");
            String nome = parts[0].trim();
            Double preco = Double.parseDouble(parts[1].trim());
            int quantidade = Integer.parseInt(parts[2].trim());
            double total = preco * quantidade;

            linhasSaida.add(nome + ", " + total);
            line = br.readLine();
        }
    } catch (IOException e) {
        IO.println("Erro: " + e.getMessage());
    }

    File arquivoOrigem = new File(path);
    File pastaOut = new File(arquivoOrigem.getParent(), "out");
    pastaOut.mkdir();

    File arquivoSaida = new File(pastaOut, "summary.csv");

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSaida))) {
        for (String linha : linhasSaida) {
            bw.write(linha);
            bw.newLine();
        }
    }catch (Exception e){
        IO.println("Erro: " + e.getMessage());
    }

}