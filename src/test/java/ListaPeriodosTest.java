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

    @Before
    public void initialize() {
        this.lista = new ListaPeriodos(this.gerarLista());
    }

    @Test
    public void testeListaValida() {
        assertEquals(this.lista.getPeriodos().size(), 3);
    }

    /*@Test
    public void testeOrdem() {
        List<Periodo> l = this.lista.getPeriodos();
        List<Periodo> le = this.listaEsperada();
        assertEquals(l, le);
    }*/
}