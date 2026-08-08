import entities.Employee;
import entities.OutsourcedEmployee;

void main() {

    Scanner sc = new Scanner(System.in);

    IO.print("Enter the number of employess: ");
    int n = sc.nextInt();
    sc.nextLine();

    for (int i = 1; i <= n; i++) {
        IO.println("Employee #" + i + " data:");
        IO.print("Oursourced (y/n)? ");
        char c = sc.next().toLowerCase(Locale.ROOT).charAt(0);
        sc.nextLine();
        IO.print("Name: ");
        String name = sc.nextLine();
        IO.print("Hours: ");
        Integer hours = sc.nextInt();
        sc.nextLine();
        IO.print("Value per hour: ");
        Double valuePerHour = sc.nextDouble();
        sc.nextLine();
        if (c == 'n') {
            new Employee(name, hours, valuePerHour);
        } else {
            IO.print("Additional charge: ");
            double additionalCharge = sc.nextDouble();
            sc.nextLine();
            new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
        }

    }
    for (Employee e : Employee.getEmployees()) {
        IO.println(e);
    }
}

