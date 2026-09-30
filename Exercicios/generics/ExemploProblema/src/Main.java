import entities.Product;
import services.CalculationService;

void main () {
    List<Product> list = new ArrayList<>();

    String path = "C:\\Users\\SnyX\\Desktop\\in.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(path))){
        String line = br.readLine();
        while (line != null) {
            String[] fields = line.split(",");
            list.add(new Product(fields[0], Double.parseDouble(fields[1])));
            line = br.readLine();
        }

        Product x = CalculationService.max(list);
        IO.println("Max: ");
        IO.println(x);
    }  catch (IOException e) {
        IO.println("Error: " + e.getMessage());
    }



}