import entities.Department;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Insira o nome do departamento: ");
        String departmentName = sc.nextLine();
        System.out.println("Insira os dados do funcionario");
        System.out.print("Nome: ");
        String workerName = sc.nextLine();
        System.out.print("Nível (JUNIOR, MID_LEVEL, SENIOR): ");
        String workerLevel = sc.nextLine();
        System.out.print("Insira o salário base do funcionario: ");
        double baseSalary = sc.nextDouble();
        sc.nextLine();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

        System.out.print("Quantos contratos tem o funcionario? ");
        int contractCount = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= contractCount; i++) {
            System.out.println("Insira os dados do " + i + "º contrato");
            System.out.print("Data (dd/mm/yyyy): ");
            String data = sc.nextLine();
            LocalDate dt = LocalDate.parse(data, dtf);
            System.out.print("Valor por hora do contrato: ");
            double valuePerHour = sc.nextDouble();
            sc.nextLine();
            System.out.print("Quantidade de horas trabalhadas: ");
            int duration = sc.nextInt();
            sc.nextLine();
            HourContract contract = new HourContract(dt, valuePerHour, duration);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Entre com mês e ano para calcular o salario (MM/YYYY): ");
        String monthYearStr = sc.next();

//        String monthAndYear = sc.next();
//        int month = Integer.parseInt(monthAndYear.substring(0, 2));
//        int year = Integer.parseInt(monthAndYear.substring(3));  outro metodo de capturar a data inserida pelo usuario
//        caso o padrao da data seja MM/YYYY...


        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("MM/yyyy");
        YearMonth monthYear = YearMonth.parse(monthYearStr, myFormatter);
        int month = monthYear.getMonthValue();
        int year = monthYear.getYear();

        System.out.println("Nome do funcionário: " + worker.getName());
        System.out.println("Departamento: " + worker.getDepartment().getName());
        System.out.println("Salário de " + monthYearStr + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();

    }
}