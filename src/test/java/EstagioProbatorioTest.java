import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by raphael on 06/12/16.
 */
public class EstagioProbatorioTest {
    private EstagioProbatorio estagioPropatorio;

    private List<Periodo> mockListaPeriodos(){
        Periodo periodo = new Periodo(LocalDate.now().plusDays(10),
                LocalDate.now().plusDays(30));
        Periodo periodo2 = new Periodo(LocalDate.now().plusDays(50),
                LocalDate.now().plusDays(70));
        Periodo periodo3 = new Periodo(LocalDate.now().plusDays(90),
                LocalDate.now().plusDays(110));
        List<Periodo> list = new ArrayList();
        list.add(periodo);
        list.add(periodo2);
        list.add(periodo3);
        return (list);
    }

    private List<Periodo> listaIntercalada(){
        Periodo periodo = new Periodo(LocalDate.now().plusDays(10),
                LocalDate.now().plusDays(20));
        Periodo periodo2 = new Periodo(LocalDate.now().plusDays(15),
                LocalDate.now().plusDays(30));
        Periodo periodo3 = new Periodo(LocalDate.now().plusDays(50),
                LocalDate.now().plusDays(60));
        Periodo periodo4 = new Periodo(LocalDate.now().plusDays(55),
                LocalDate.now().plusDays(70));
        List<Periodo> list = new ArrayList();
        list.add(periodo);
        list.add(periodo2);
        list.add(periodo3);
        list.add(periodo4);
        return list;
    }

    private List<Periodo> listaCobreOutro(){
        Periodo periodo = new Periodo(LocalDate.now().plusDays(10),
                LocalDate.now().plusDays(40));
        Periodo periodo2 = new Periodo(LocalDate.now().plusDays(15),
                LocalDate.now().plusDays(30));
        Periodo periodo3 = new Periodo(LocalDate.now().plusDays(50),
                LocalDate.now().plusDays(80));
        Periodo periodo4 = new Periodo(LocalDate.now().plusDays(55),
                LocalDate.now().plusDays(70));
        List<Periodo> list = new ArrayList();
        list.add(periodo);
        list.add(periodo2);
        list.add(periodo3);
        list.add(periodo4);
        return list;
    }

    @Test
    public void testeCalculoSemPeriodos(){
        estagioPropatorio = new EstagioProbatorio(new ArrayList<>(), LocalDate.now());
        LocalDate l = LocalDate.now();
        assertEquals(estagioPropatorio.getDataFinal(), l.plusMonths(36));
    }

    @Test
    public void testeCalculoComPeriodos(){
        estagioPropatorio = new EstagioProbatorio(this.mockListaPeriodos(), LocalDate.now());
        LocalDate l = LocalDate.now();
        assertEquals(estagioPropatorio.getDataFinal(), l.plusMonths(36).plusDays(60));
    }

    @Test
    public void testeCalculoComPeriodoInvalido(){
        List<Periodo> lista = this.mockListaPeriodos();
        lista.add(new Periodo(LocalDate.now().minusDays(10),
                LocalDate.now().minusDays(30)));
        estagioPropatorio = new EstagioProbatorio(lista, LocalDate.now());
        LocalDate l = LocalDate.now();
        assertEquals(estagioPropatorio.getDataFinal(), l.plusMonths(36).plusDays(60));
    }

    @Test
    public void testeCalculoComPeriodoIntercalado(){
        estagioPropatorio = new EstagioProbatorio(this.listaIntercalada(), LocalDate.now());
        LocalDate l = LocalDate.now();
        assertEquals(estagioPropatorio.getDataFinal(), l.plusMonths(36).plusDays(40));
    }

    @Test
    public void testeCalculoComPeriodoCobreOutro(){
        estagioPropatorio = new EstagioProbatorio(this.listaCobreOutro(), LocalDate.now());
        LocalDate l = LocalDate.now();
        assertEquals(estagioPropatorio.getDataFinal(), l.plusMonths(36).plusDays(60));
    }
}