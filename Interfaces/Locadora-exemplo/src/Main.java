import entities.CarRental;
import entities.Vehicle;
import services.BrazilTaxService;
import services.RentalService;

void main(){
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    IO.println("Entre com os dados do aluguel");
    IO.print("Modelo do carro: ");
    String carName = sc.nextLine();
    IO.print("Retirada (DD/MM/YYYY HH:SS): ");
    LocalDateTime startDate =  LocalDateTime.parse(sc.nextLine(), dtf);
    IO.print("Devolução (DD/MM/YYYY HH:SS): ");
    LocalDateTime finishDate = LocalDateTime.parse(sc.nextLine(), dtf);
    IO.print("Insira o preço por hora: ");
    double priceHour = sc.nextDouble();
    IO.print("Insira o preço por dia: ");
    double priceDay = sc.nextDouble();

    CarRental cr = new CarRental( startDate, finishDate, new Vehicle(carName));

    RentalService rentalService = new RentalService(priceDay, priceHour, new BrazilTaxService());

    rentalService.processInvoice(cr);

    IO.println("Fatura:");
    IO.println("Pagamento básico: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
    IO.println("Imposto: " + String.format("%.2f", cr.getInvoice().getTax()));
    IO.println("Pagamento total: " + String.format("%.2f", cr.getInvoice().getTotal()));

    sc.close();
}