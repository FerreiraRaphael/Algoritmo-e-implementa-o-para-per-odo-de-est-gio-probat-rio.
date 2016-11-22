import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by raphael on 22/11/16.
 */
public class PeriodoTest {
    @Test
    public void testePeriodoValido(){
        Periodo periodo;
        LocalDate dataInicial = LocalDate.of(2016,2,21);
        LocalDate dataFinal = LocalDate.of(2016,2,28);
        periodo = new Periodo(dataInicial ,dataFinal);
        assertEquals(periodo.valid(), true);
    }
    @Test
    public void testePeriodoInvalido(){
        Periodo periodo;
        LocalDate dataFinal = LocalDate.of(2016,2,21);
        LocalDate dataInicial  = LocalDate.of(2016,2,28);
        periodo = new Periodo(dataInicial ,dataFinal);
        assertEquals(periodo.valid(), false);
    }
    @Test
    public void testeDias(){
        Periodo periodo;
        LocalDate dataFinal = LocalDate.of(2016,2,28);
        LocalDate dataInicial  = LocalDate.of(2016,2,21);
        periodo = new Periodo(dataInicial ,dataFinal);
        assertEquals(periodo.dias(), 7);
    }

    @Test
    public void testeValidarComDataInicialValida(){
        Periodo periodo;
        LocalDate dataInicial  = LocalDate.now().plusDays(10);
        LocalDate dataFinal = LocalDate.now().plusDays(30);
        LocalDate data = LocalDate.now();
        periodo = new Periodo(dataInicial ,dataFinal);
        assertEquals(periodo.validarComDataInicial(data), true);
    }

    @Test
    public void testeValidarComDataInicialInvalida(){
        Periodo periodo;
        LocalDate dataInicial  = LocalDate.now().plusDays(10);
        LocalDate dataFinal = LocalDate.now().plusDays(30);
        LocalDate data = LocalDate.now().plusDays(12);
        periodo = new Periodo(dataInicial ,dataFinal);
        assertEquals(periodo.validarComDataInicial(data), false);
    }
}