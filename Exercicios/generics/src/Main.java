import services.PrintService;

void main() {
    Scanner sc = new Scanner(System.in);

    PrintService<String> ps = new PrintService<>();


    IO.print("How many values? ");
    int n = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < n; i++) {
        IO.print("value " + (i + 1) + ": ");
        String value = sc.nextLine();
        ps.addValue(value);
    }

    ps.print();
    IO.println("First number: " + ps.first());

    sc.close();
}