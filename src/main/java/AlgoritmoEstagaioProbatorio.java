import java.time.LocalDate;
import java.util.List;

/**
 * Created by raphael on 22/11/16.
 */
public class AlgoritmoEstagaioProbatorio {
    private List<Periodo> periodos;
    private LocalDate dataInicial;

    public AlgoritmoEstagaioProbatorio(LocalDate dataInicial, List<Periodo> periodos){
        this.periodos= periodos;
        this.dataInicial = dataInicial;
    }

    public LocalDate calcular(){
        LocalDate result = this.dataInicial;
        result = result.plusMonths(36);
        for (Periodo p : this.periodos){
            if(p.validarComDataInicial(this.dataInicial))
                result = result.plusDays(p.dias());
        };
        return result;
    }

}
