import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaBancariaTest {
    @Test
    void deveArmazenarEstados() {
        ContaBancaria conta = new ContaBancaria();
        conta.setEstado(ContaEstadoAtiva.getInstance());
        conta.setEstado(ContaEstadoEncerrada.getInstance());
        assertEquals(2, conta.getEstados().size());
    }

    @Test
    void deveRetornarEstadoInicial() {
        ContaBancaria conta = new ContaBancaria();
        conta.setEstado(ContaEstadoAtiva.getInstance());
        conta.setEstado(ContaEstadoEncerrada.getInstance());
        conta.restauraEstado(0);
        assertEquals(ContaEstadoAtiva.getInstance(), conta.getEstado());
    }

    @Test
    void deveRetornarEstadoAnterior() {
        ContaBancaria conta = new ContaBancaria();
        conta.setEstado(ContaEstadoAtiva.getInstance());
        conta.setEstado(ContaEstadoBloqueada.getInstance());
        conta.setEstado(ContaEstadoAtiva.getInstance());
        conta.setEstado(ContaEstadoEncerrada.getInstance());
        conta.restauraEstado(2);
        assertEquals(ContaEstadoAtiva.getInstance(), conta.getEstado());
    }

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            ContaBancaria conta = new ContaBancaria();
            conta.restauraEstado(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }
}
