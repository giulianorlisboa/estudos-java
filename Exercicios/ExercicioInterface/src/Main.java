import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

void main(){
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    IO.println("Entre os dados do contrato:");
    IO.print("Número: ");
    int contractNumber = sc.nextInt();
    sc.nextLine();
    IO.print("Data (dd/MM/yyyy): ");
    LocalDate contractDate = LocalDate.parse(sc.nextLine(), dtf);
    IO.print("Valor do contrato: ");
    double contractValue = sc.nextDouble();
    sc.nextLine();
    IO.print("Entre com a quantidade de parcelas: ");
    int quantity = sc.nextInt();
    sc.nextLine();

    Contract contract = new Contract(contractNumber, contractDate, contractValue);

    ContractService cs = new ContractService(new PaypalService());

    cs.processContract(contract, quantity);

    for (Installment i : contract.getInstallments()) {
        IO.println(i.getDate().format(dtf) + " - " + String.format("%.2f", i.getAmount()));
    }



}