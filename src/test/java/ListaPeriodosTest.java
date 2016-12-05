import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by raphael on 22/11/16.
 */
public class ListaPeriodosTest {

    ListaPeriodos lista;

    private List<Periodo> listaIntercalada(){
        Periodo periodo = new Periodo(LocalDate.of(2016, 2, 21),
                LocalDate.of(2016, 3, 22));
        Periodo periodo2 = new Periodo(LocalDate.of(2016, 3, 21),
                LocalDate.of(2016, 3, 28));
        Periodo periodo3 = new Periodo(LocalDate.of(2016, 4, 21),
                LocalDate.of(2016, 5, 22));
        Periodo periodo4 = new Periodo(LocalDate.of(2016, 5, 21),
                LocalDate.of(2016, 5, 28));
        List<Periodo> list = new ArrayList();
        list.add(periodo);
        list.add(periodo2);
        list.add(periodo3);
        list.add(periodo4);
        return list;
    }

    private List<Periodo> listaCobreOutro(){
        Periodo periodo = new Periodo(LocalDate.of(2016, 2, 21),
                LocalDate.of(2016, 4, 28));
        Periodo periodo2 = new Periodo(LocalDate.of(2016, 3, 21),
                LocalDate.of(2016, 3, 28));
        Periodo periodo3 = new Periodo(LocalDate.of(2016, 5, 21),
                LocalDate.of(2016, 7, 28));
        Periodo periodo4 = new Periodo(LocalDate.of(2016, 6, 21),
                LocalDate.of(2016, 6, 28));
        List<Periodo> list = new ArrayList();
        list.add(periodo);
        list.add(periodo2);
        list.add(periodo3);
        list.add(periodo4);
        return list;
    }

    private List<Periodo> listaEsperada(){
        Periodo periodo = new Periodo(LocalDate.of(2016, 2, 21),
                LocalDate.of(2016, 2, 28));
        Periodo periodo2 = new Periodo(LocalDate.of(2016, 3, 21),
                LocalDate.of(2016, 3, 28));
        Periodo periodo3 = new Periodo(LocalDate.of(2016, 4, 21),
                LocalDate.of(2016, 4, 28));
        List<Periodo> list = new ArrayList();
        list.add(periodo);
        list.add(periodo2);
        list.add(periodo3);
        return list;
    }

    private List<Periodo> gerarLista(){
        List<Periodo> listaEsperada = this.listaEsperada();
        Periodo periodoInvalido = new Periodo(LocalDate.of(2016, 3, 21),
                LocalDate.of(2016, 2, 28));
        List<Periodo> list = new ArrayList<Periodo>();
        list.add(listaEsperada.get(1));
        list.add(listaEsperada.get(2));
        list.add(periodoInvalido);
        list.add(listaEsperada.get(0));
        return list;
    }

    @Test
    public void testeListaValida() {
        this.lista = new ListaPeriodos(this.gerarLista());
        assertEquals(this.lista.getPeriodos().size(), 3);
    }

    @Test
    public void testeListaIntercalada(){
        this.lista = new ListaPeriodos(this.listaIntercalada());
        assertEquals(this.lista.getPeriodos().size(), 2);
    }

    @Test
    public void testeListaPeriodoCobreOutro(){
        this.lista = new ListaPeriodos(this.listaCobreOutro());
        assertEquals(this.lista.getPeriodos().size(), 2);
    }

    private boolean igualarListas( List<Periodo> l1, List<Periodo> l2){
        boolean valido = true;
        if(l1.size() != l2.size()) return false;
        for (int i = 0; i < l1.size(); i++) {
            if(!l1.get(i).getDataInicial().isEqual(l2.get(i).getDataInicial())) valido = false;
            if(!l1.get(i).getDataFinal().isEqual(l2.get(i).getDataFinal())) valido = false;
        }
        return valido;
    }

    @Test
    public void testeOrdem() {
        this.lista = new ListaPeriodos(this.gerarLista());
        List<Periodo> l = this.lista.getPeriodos();
        List<Periodo> le = this.listaEsperada();
        assertEquals(igualarListas(l, le), true);
    }
}