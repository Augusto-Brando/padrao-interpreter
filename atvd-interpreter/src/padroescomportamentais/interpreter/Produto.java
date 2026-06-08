package padroescomportamentais.interpreter;

public class Produto {
    private double preco;
    private double desconto;

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double calcularPrecoFinal() {
        return Loja.calcularPrecoFinal(this.preco, this.desconto);
    }
}