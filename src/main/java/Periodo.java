import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Created by raphael on 22/11/16.
 */
public class Periodo {

    private LocalDate dataInicial;
    private LocalDate dataFinal;

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Periodo(LocalDate dataInicial, LocalDate dataFinal){
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public long dias(){
        return DAYS.between(this.getDataInicial(), this.getDataFinal());
    }

    public boolean ehAntes(Periodo periodo){
        return this.getDataInicial()
                .isBefore(periodo.getDataInicial());
    }

    public boolean valid(){
        return dataInicial.isBefore(dataFinal);
    }

    public boolean validarComDataInicial(LocalDate data){
        return data.isBefore(dataInicial) && data.isBefore(dataFinal);
    }
}
