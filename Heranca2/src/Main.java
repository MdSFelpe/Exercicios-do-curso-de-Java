/*
Fazer um programa para ler os dados de N contribuintes (N fornecido pelo usuário), os quais
podem ser pessoa física ou pessoa jurídica, e depois mostrar o valor do imposto pago por cada um,
bem como o total de imposto arrecadado.
Os dados de pessoa física são: nome, renda anual e gastos com saúde. Os dados de pessoa jurídica
são nome, renda anual e número de funcionários. As regras para cálculo de imposto são as
seguintes:

Pessoa física: pessoas cuja renda foi abaixo de 20000.00 pagam 15% de imposto. Pessoas com
renda de 20000.00 em diante pagam 25% de imposto. Se a pessoa teve gastos com saúde, 50%
destes gastos são abatidos no imposto.
Exemplo: uma pessoa cuja renda foi 50000.00 e teve 2000.00 em gastos com saúde, o imposto
fica: (50000 * 25%) - (2000 * 50%) = 11500.00

Pessoa jurídica: pessoas jurídicas pagam 16% de imposto. Porém, se a empresa possuir mais de 10
funcionários, ela paga 14% de imposto.
Exemplo: uma empresa cuja renda foi 400000.00 e possui 25 funcionários, o imposto fica:
400000 * 14% = 56000.00



OBS: Imagem do UML no SRC
*/
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
            System.out.print("Tax payer #"+i+" data (Name) : ");
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
