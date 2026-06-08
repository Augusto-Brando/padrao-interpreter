package padroescomportamentais.interpreter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteUnitarioInterpreter {

    @Test
    public void testNumero() {
        Numero numero = new Numero(5.0);
        assertEquals(5.0, numero.interpretar());
    }

    @Test
    public void testAdicao() {
        Numero num1 = new Numero(10.0);
        Numero num2 = new Numero(5.0);
        Adicao adicao = new Adicao(num1, num2);
        assertEquals(15.0, adicao.interpretar());
    }

    @Test
    public void testSubtracao() {
        Numero num1 = new Numero(10.0);
        Numero num2 = new Numero(3.0);
        Subtracao subtracao = new Subtracao(num1, num2);
        assertEquals(7.0, subtracao.interpretar());
    }

    @Test
    public void testMultiplicacao() {
        Numero num1 = new Numero(4.0);
        Numero num2 = new Numero(5.0);
        Multiplicacao multiplicacao = new Multiplicacao(num1, num2);
        assertEquals(20.0, multiplicacao.interpretar());
    }

    @Test
    public void testDivisao() {
        Numero num1 = new Numero(20.0);
        Numero num2 = new Numero(4.0);
        Divisao divisao = new Divisao(num1, num2);
        assertEquals(5.0, divisao.interpretar());
    }

    @Test
    public void testInterpretadorExpressaoSimples() {
        InterpretadorExpressao interpretador = new InterpretadorExpressoesAritmeticas("10 + 5");
        assertEquals(15.0, interpretador.interpretar());
    }

    @Test
    public void testInterpretadorExpressaoComMultiplicacao() {
        InterpretadorExpressao interpretador = new InterpretadorExpressoesAritmeticas("10 * 2");
        assertEquals(20.0, interpretador.interpretar());
    }

    @Test
    public void testInterpretadorExpressaoCompleta() {
        // Sequencial: 100 - 50 = 50, depois 50 * 0.1 = 5
        InterpretadorExpressao interpretador = new InterpretadorExpressoesAritmeticas("100 - 50 * 0.1");
        assertEquals(5.0, interpretador.interpretar());
    }

    @Test
    public void testProdutoComDesconto() {
        Produto produto = new Produto();
        produto.setPreco(100.0);
        produto.setDesconto(50.0);
        // Sequencial: 100 - 50 = 50, depois 50 * 0.1 = 5
        assertEquals(5.0, produto.calcularPrecoFinal());
    }

    @Test
    public void testLojaCalcularPrecoFinal() {
        // Sequencial: 200 - 100 = 100, depois 100 * 0.1 = 10
        double precoFinal = Loja.calcularPrecoFinal(200.0, 100.0);
        assertEquals(10.0, precoFinal);
    }

    @Test
    public void testExpressaoInvalidaSemOperando() {
        assertThrows(IllegalArgumentException.class, () -> {
            new InterpretadorExpressoesAritmeticas("10 +");
        });
    }
}