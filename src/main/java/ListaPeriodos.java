import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by raphael on 22/11/16.
 */
public class ListaPeriodos {

    private List<Periodo> periodos;

    public ListaPeriodos(List<Periodo> lista){
        setPeriodos(validarListaOrdenada(ordenarLista(filtrarPeriodosValidos(lista))));
    }

    private List<Periodo> ordenarLista(List<Periodo> lista){
        Collections.sort(lista, (o1, o2) -> o1.ehAntes(o2) ? -1 : 1);
        return lista;
    }

    private List<Periodo> filtrarPeriodosValidos(List<Periodo> lista){
        return lista.stream()
                .filter((p) -> p.valid())
                .collect(Collectors.toList());
    }

    private Periodo intecalarPeriodos(Periodo p1, Periodo p2){
        return new Periodo(p1.getDataInicial(), p2.getDataFinal());
    }

    private boolean validarPeriodoCobreOutro( Periodo p1, Periodo p2){
        return p1.getDataFinal().isAfter(p2.getDataInicial())
                && p1.getDataFinal().isAfter(p2.getDataFinal());
    }

    private boolean validarPeriodosIntercalados( Periodo p1, Periodo p2){
        return p1.getDataFinal().isAfter(p2.getDataInicial()) && !validarPeriodoCobreOutro(p1, p2);
    }

    private void preencherListaPeriodosValidos(List<Periodo> lista, Periodo p1, Periodo p2){
        if(validarPeriodoCobreOutro(p1,p2)){
            if( lista.indexOf(p1) == -1 ) lista.add(p1);
        }
        else if(validarPeriodosIntercalados(p1, p2)){
            if( lista.indexOf(p1) > -1) lista.remove(p1);
            lista.add(intecalarPeriodos(p1, p2));
        }else{
            if( lista.indexOf(p1) == -1 )lista.add(p1);
            lista.add(p2);
        }
    }

    private List<Periodo> validarListaOrdenada( List<Periodo> listaOrdenada ){
        List<Periodo> listaValida = new ArrayList<>();
        for (int i = 0; i < listaOrdenada.size() - 1; i++) {
            Periodo p1 = i == 0 ? listaOrdenada.get(i) : listaValida.get(listaValida.size() - 1);
            Periodo p2 = listaOrdenada.get(i+1);
            preencherListaPeriodosValidos(listaValida, p1, p2);
        }
        return listaValida;
    }

    public List<Periodo> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<Periodo> periodos) {
        this.periodos = periodos;
    }
}

