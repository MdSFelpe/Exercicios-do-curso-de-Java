import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        double p = sc.nextDouble();

        for (int i = 1; i <= p; i++){
            System.out.print("Tax payer #"+i+" data : ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Anual income: ");
            Double AnualIncome = sc.nextDouble();

            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);

            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                Double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name, AnualIncome, healthExpenditures));
            }else if (ch == 'c') { // Verifica se é empresa
                    System.out.print("Number of employees: ");
                    int numberOfEmployees = sc.nextInt();
                    list.add(new Company(name, AnualIncome, numberOfEmployees)); // Adiciona à lista
            } else {
                System.out.println("Invalid type. Skipping this tax payer.");
            }
        }
        sc.close();
        System.out.println("TOTAL PAID:");
        double totalTaxes = 0.0;

            for (TaxPayer tp : list) {
                double tax = tp.tax(); // Chama o metodo tax() de cada contribuinte
                System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
                totalTaxes += tax; // Soma os impostos
            }
            System.out.print("TOTAL TAXES: $ " + String.format("%.2f", totalTaxes));
        }
    }
