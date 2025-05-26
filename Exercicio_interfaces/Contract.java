import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    private Integer number;
    private LocalDate date;
    private Double totalvalue;


    private List<Installment> installments = new ArrayList<>(); //Cria uma array para guarda os contratos que seram criados

    public Contract(LocalDate date, Integer number, Double totalValue){

        this.number = number;
        this.date = date;
        this.totalvalue = totalValue;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getTotalvalue() {
        return totalvalue;
    }

    public void setTotalvalue(Double totalvalue) {
        this.totalvalue = totalvalue;
    }

    public List<Installment> getInstallments() { // serve para acessar a lista de parcelas que é privada.
        return installments;
    }
}
