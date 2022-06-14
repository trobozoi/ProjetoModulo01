package ProjetoModulo01;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class ProdutoInvestimentos {
    private String produto;
    private BigDecimal valor;
    private BigDecimal rendimento;
    private int ciclo;

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal getRendimento() {
        return rendimento;
    }

    public int getCiclo() {
        return ciclo;
    }

    public String getProduto() {
        return produto;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public void setRendimento(BigDecimal rendimento) {
        this.rendimento = rendimento;
    }

    public ProdutoInvestimentos(String produto, BigDecimal valor, BigDecimal rendimento, int ciclo) {
        this.produto = produto;
        this.valor = valor;
        this.rendimento = rendimento;
        this.ciclo = ciclo;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(2);
        return "ProdutoInvestimentos:" +
                "\n\tproduto='" + produto + '\'' +
                "\n\tvalor=" + NumberFormat.getCurrencyInstance().format(valor) +
                "\n\trendimento=" + nf.format(rendimento) +
                "\n\tciclo=" + ciclo;
    }
}
