import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService OnlinepaymentService;

    public ContractService(OnlinePaymentService OnlinepaymentService) {
        this.OnlinepaymentService = OnlinepaymentService;
    }


    public void processContract(Contract contract, int months){
        double basicQuota = contract.getTotalvalue() / months; //dividi o valor total pelo número de meses/parcelas que o usuário digitou

        for(int i=1; i<= months; i++){ //utilizado para fazer as parcelas do usuário

            LocalDate dueDate = contract.getDate().plusMonths(i); //Adiciona 1 mês a data digitada anteriormente pelo usuário
                                                                    //para simular as parcelas desde o momento que o usuário a digitou

            double interest = OnlinepaymentService.Interest(basicQuota, i); //utiliza o metodo Interest do Onlinepayment para simular o valor das parcelas
                                                                            // utilizando a taxa de serviços online

            double fee = OnlinepaymentService.paymentFee(basicQuota + interest);//utiliza o metodo paymentFee do Onlinepayment para simular o valor das parcelas
                                                                                            // utilizando os juros de 2% para cada parcela

            double quota = basicQuota + interest + fee; //cria o valor total dividido em parcelas adicionando as taxas de serviço online e juros por de 2% em cada parcela
            contract.getInstallments().add(new Installment(quota, dueDate)); //Cria uma parcela na lista de Installments
        }
    }
}
