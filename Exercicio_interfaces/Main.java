import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner (System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Area para colocar o numero do contrato
        System.out.println("Enter the contract data: ");
        System.out.print("Contract number: ");
        Integer number = sc.nextInt();
        //----------------------------------------------------------------------//


        //Area para colocaadata do contrato
        System.out.print("Contract Date (dd/MM/yyyy): ");
        sc.nextLine(); // serve para limpar o buffer se houver um nextInt(), nextDouble(), etc.
        LocalDate date = LocalDate.parse(sc.nextLine(), fmt); //Formatar a data no estilo do formatter fmt
        //------------------------------------------------------------------------------------------------//

        //Area do valor do contrato
        System.out.print("Contract Value: ");
        Double totalValue = sc.nextDouble();
        sc.nextLine();
        //-------------------------------------//

        //Número de parcelas
        System.out.print("Enter the number of installments: ");
        int months = sc.nextInt();

        //-------------------------------------//



        //Cria um contrato com os dados passados anteriormente
        Contract contract = new Contract(date, number, totalValue);

        //Cria um contractService que usa o PaypalService como forma de pagamento
        ContractService contractService = new ContractService(new PaypalService());


        //Utiliza o medo do contractService chamando processContract usando como informações ''contract'' criando anteriormente e ''months''
        contractService.processContract(contract, months);

        System.out.println("Parcelas:");
        for (Installment installment : contract.getInstallments()) { //Para cada objeto do tipo Installment dentro dessa lista, guarde ele na variável installment e execute o bloco de código abaixo
            System.out.println(installment); //Usa o String toString() do Installment
        }

        sc.close();
    }
}