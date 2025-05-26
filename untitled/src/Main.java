import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner (System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


        System.out.println("Enter the information to rent a car ");
        System.out.print("Car model: ");
        String carModel = sc.nextLine();
        System.out.println("Pickup (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.println("Return (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

        System.out.print("Enter the price for hour:");
        double pricePerHour = sc.nextDouble();
        System.out.print("Enter the prince for day:");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

        rentalService.processInvoice(cr);

        System.out.println("Invoice: ");
        System.out.println("Basic payment: "+ String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("tax: "+ String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Total Payment: "+ String.format("%.2f", cr.getInvoice().getTotalPayment()));

        sc.close();
    }
}