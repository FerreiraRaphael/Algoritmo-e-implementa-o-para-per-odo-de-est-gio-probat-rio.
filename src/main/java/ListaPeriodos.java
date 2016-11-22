import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by raphael on 22/11/16.
 */
public class ListaPeriodos {

    private List<Periodo> periodos;

    public ListaPeriodos(List<Periodo> lista){

        this.setPeriodos(this.ordenarLista(this.validarLista(lista)));

    }

    private List<Periodo> ordenarLista(List<Periodo> lista){
        Collections.sort(lista, (o1, o2) -> o1.ehAntes(o2) ? -1 : 1);
        return lista;
    }

    private List<Periodo> validarLista(List<Periodo> lista){
        return lista.stream()
                .filter((p) -> p.valid())
                .collect(Collectors.toList());
    }

    public List<Periodo> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<Periodo> periodos) {
        this.periodos = periodos;
    }
}

