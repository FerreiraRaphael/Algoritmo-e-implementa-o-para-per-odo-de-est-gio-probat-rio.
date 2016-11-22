import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by raphael on 22/11/16.
 */
public class AlgoritmoEstagaioProbatorioTest {
    private AlgoritmoEstagaioProbatorio algoritmoEstagaioProbatorio;

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

    @Test
    public void testeCalculoSemPeriodos(){
        algoritmoEstagaioProbatorio = new AlgoritmoEstagaioProbatorio(LocalDate.now(), new ArrayList<>());
        LocalDate l = LocalDate.now();
        assertEquals(algoritmoEstagaioProbatorio.calcular(), l.plusMonths(36));
    }

    @Test
    public void testeCalculoComPeriodos(){
        algoritmoEstagaioProbatorio = new AlgoritmoEstagaioProbatorio(LocalDate.now(), this.mockListaPeriodos());
        LocalDate l = LocalDate.now();
        assertEquals(algoritmoEstagaioProbatorio.calcular(), l.plusMonths(36).plusDays(60));
    }

    @Test
    public void testeCalculoComPeriodoInvalido(){
        List<Periodo> lista = this.mockListaPeriodos();
        lista.add(new Periodo(LocalDate.now().minusDays(10),
                LocalDate.now().minusDays(30)));
        algoritmoEstagaioProbatorio = new AlgoritmoEstagaioProbatorio(LocalDate.now(), lista);
        LocalDate l = LocalDate.now();
        assertEquals(algoritmoEstagaioProbatorio.calcular(), l.plusMonths(36).plusDays(60));
    }
}