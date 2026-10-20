void main() {
    Map<String, Integer> votos = new LinkedHashMap<>();

    String path = "C:\\Users\\giuli\\OneDrive\\Desktop\\votos.csv";

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        String line = br.readLine();
        while (line != null) {
            if (!line.isBlank()) {
                String[] row = line.split(",");
                String nome = row[0].trim();
                int qtdVotos = Integer.parseInt(row[1].trim());
                int total = votos.getOrDefault(nome, 0) + qtdVotos;
                votos.put(nome, total);

            }
            line = br.readLine();
        }
    } catch (IOException e) {
        IO.println("Error: " + e.getMessage());
    }

    for (String s : votos.keySet()) {
        IO.println(s + ": " + votos.get(s));
    }
}