/*
Fazer um programa para ler os dados de uma conta bancária e depois realizar um
saque nesta conta bancária, mostrando o novo saldo. Um saque não pode ocorrer
ou se não houver saldo na conta, ou se o valor do saque for superior ao limite de
saque da conta.
 */



import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

            try {
                System.out.println("Enter Enter account data");
                System.out.print("Number: ");
                int number = sc.nextInt();
                System.out.print("Holder: ");
                sc.nextLine();
                String holder = sc.nextLine();
                System.out.print("Initial Balance: ");
                Double balance = sc.nextDouble();
                System.out.print("Withdraw limit: ");
                Double withdrawLimit = sc.nextDouble();

                Account accounts = new Account(number, holder, balance, withdrawLimit);

                //Deposit
                System.out.print("Enter amount to deposit: ");
                Double depositAmount = sc.nextDouble();
                accounts.deposit(depositAmount);
                System.out.println("Updated balance after deposit: " + accounts.getBalance());


                //Withdraw
                System.out.println();
                System.out.println("Enter amount for withdraw: ");
                Double amount = sc.nextDouble();
                accounts.withdraw(amount);

                sc.close();
                System.out.print("New balance: " + accounts.getBalance());
            }catch(InputMismatchException i) {
                System.out.println("Invalid character error ");
            }catch(WithdrawLimitException w){
                System.out.println("Error: "+ w.getMessage());
            }


    }
}
