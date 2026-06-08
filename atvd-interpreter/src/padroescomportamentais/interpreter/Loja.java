package padroescomportamentais.interpreter;

public class Loja {
    public static String formula = "preco - desconto * 0.1";

    public static double calcularPrecoFinal(double preco, double desconto) {
        String expressao;
        expressao = formula.replace("preco", Double.toString(preco));
        expressao = expressao.replace("desconto", Double.toString(desconto));
        InterpretadorExpressao interpretador = new InterpretadorExpressoesAritmeticas(expressao);
        return interpretador.interpretar();
    }
}