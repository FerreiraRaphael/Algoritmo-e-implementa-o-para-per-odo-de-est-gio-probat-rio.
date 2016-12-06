import java.time.LocalDate;
import java.util.List;

/**
 * Created by raphael on 22/11/16.
 */
public class EstagioProbatorio {

    private List<Periodo> periodos;
    private LocalDate dataInicial;
    private LocalDate dataFinal;

    public List<Periodo> getPeriodos() {
        return periodos;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public EstagioProbatorio(List<Periodo> periodos, LocalDate dataInicial){
        ListaPeriodos lista = new ListaPeriodos(periodos);
        AlgoritmoEstagaioProbatorio algoritmo = new AlgoritmoEstagaioProbatorio(dataInicial, lista.getPeriodos());
        this.periodos = lista.getPeriodos();
        this.dataInicial = dataInicial;
        this.dataFinal = algoritmo.calcular();
    }
}
