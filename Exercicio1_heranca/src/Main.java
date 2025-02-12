import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        List<Product> list = new ArrayList<>();


        int np;
        System.out.print("Enter the number of products: ");
        np = sc.nextInt();


        for (int i = 1; i <= np; i++) {
            System.out.print("Product #" + i + " data: ");
            System.out.print("Common, used or imported (c/u/i) ?");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            if (ch == 'u') {
                System.out.print("Manufacture date: ");
                String dateString = sc.nextLine();  // Lê a data como String
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                list.add(new UsedProduct(name, price, date));
            } else if (ch == 'i') {
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customsFee));
            } else {
                list.add(new Product(name, price));
            }


        }
        sc.close();
        System.out.println("PRICE TAGS :");
        for (Product prod : list) {
            System.out.println(prod.priceTag());
        }
    }
}
