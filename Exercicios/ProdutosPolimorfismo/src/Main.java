import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

void main() {
    Scanner sc = new Scanner(System.in);
    List<Product> products = new ArrayList<>();

    IO.print("Enter the number of products: ");
    int n = sc.nextInt();
    sc.nextLine();


    for (int i = 1; i <= n; i++) {
        IO.print("Common, used or imported (c/u/i)? ");
        String type = sc.nextLine();
        IO.println("Product #" + i + " data:");
        if (type.equalsIgnoreCase("c")) {
            IO.print("name: ");
            String name = sc.nextLine();
            IO.print("price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            Product product = new Product(name, price);
            products.add(product);
        } else if (type.equalsIgnoreCase("i")) {
            IO.print("name: ");
            String name = sc.nextLine();
            IO.print("price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            IO.print("Customs fee: ");
            double customsFee = sc.nextDouble();
            sc.nextLine();
            Product importedProduct = new ImportedProduct(name, price, customsFee);
            products.add(importedProduct);
        } else if (type.equalsIgnoreCase("u")) {
            IO.print("name: ");
            String name = sc.nextLine();
            IO.print("price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            IO.print("Manufacture date (DD/MM/YYYY): ");
            String date = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(date, formatter);
            Product usedProduct = new UsedProduct(name, price, localDate);
            products.add(usedProduct);
        } else {
            IO.println("Invalid type. Product skipped.");
        }
    }

    for (Product p : products) {
        System.out.println(p.priceTag());
    }
}
