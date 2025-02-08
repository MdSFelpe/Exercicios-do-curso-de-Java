import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;



/* Ler os dados de um pedido com N itens (N fornecido pelo usuário). Depois, mostrar um
sumário do pedido conforme exemplo (próxima página). Nota: o instante do pedido deve ser
o instante do sistema: new Date()

Esse aqui é o diagrama da atividade
 O arquivo com a imagem do digrama se encontra com o nome diagrama_da atividade


/*



No terminal tem que mostrar assim como no exemplo:
Enter cliente data:
Name: Alex Green
Email: alex@gmail.com
Birth date (DD/MM/YYYY): 15/03/1985
Enter order data:
Status: PROCESSING
How many items to this order? 2
Enter #1 item data:
Product name: TV
Product price: 1000.00
Quantity: 1
Enter #2 item data:
Product name: Mouse
Product price: 40.00
Quantity: 2
ORDER SUMMARY:
Order moment: 20/04/2018 11:25:09
Order status: PROCESSING
Client: Alex Green (15/03/1985) - alex@gmail.com
Order items:
TV, $1000.00, Quantity: 1, Subtotal: $1000.00
Mouse, $40.00, Quantity: 2, Subtotal: $80.00
Total price: $1080.00
*/


public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat cbD = new SimpleDateFormat("dd/mm/yyyy");


        //Informar nome, email, Data de nascimento e order status
        System.out.println("Enter client data: ");
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Birth date (DD/MM/YYYY): ");
        Date birthDate = cbD.parse(sc.next());
        sc.nextLine(); // Para limpar o buffer do Scanner
        System.out.println("Enter order status:    (PENDING_PAYMENT,PROCESSING, SHIPPED or DELIVERED");
        String statusInput = sc.nextLine();

        // Aqui, converta o status para o tipo do enum
        OrderStatus orderStatus = OrderStatus.valueOf(statusInput.toUpperCase());

        System.out.println("Status: " + orderStatus);

        // Crie a instância de Order
        Order order = new Order(new Date(), orderStatus, new Client(name, email, birthDate));

        System.out.println("How many items to this order?");
        int n = sc.nextInt();

        //Lógica para adiciona diversos produtos no pedido.
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter " + i + " item data: ");
            System.out.print("Product name: ");
            String productName = sc.next();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(productName, productPrice);
            OrderItem it = new OrderItem(quantity, productPrice, product);

            // Agora chama addItem usando a instância de order
            order.addItem(it);
        }

        System.out.println();
        System.out.println(order);

        sc.close();
    }
}






