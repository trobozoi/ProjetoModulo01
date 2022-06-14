package ProjetoModulo01;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Investimento {
    private BigDecimal valor;
    private Date dataInvest;
    private ProdutoInvestimentos produtoInvestimentos;

    private BigDecimal adicional;

    public BigDecimal getAdicional() {
        return adicional;
    }

    public void setAdicional(BigDecimal adicional) {
        this.adicional = adicional;
    }

    public ProdutoInvestimentos getProdutoInvestimentos() {
        return produtoInvestimentos;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal getValorRende() {
        Date agora = Calendar.getInstance().getTime();
        long dif = agora.getTime() - dataInvest.getTime();
        int numCliclos = (int)(dif / produtoInvestimentos.getCiclo() / 1000);
        BigDecimal percentual = produtoInvestimentos.getRendimento().add(this.getAdicional());
        percentual = percentual.add(new BigDecimal(1));
        percentual = percentual.pow(numCliclos);
        return valor.multiply(percentual);
    }

    public Date getDataInvest() {
        return dataInvest;
    }

    public void setDataInvest(Date dataInvest) {
        this.dataInvest = dataInvest;
    }

    public void setProdutoInvestimentos(ProdutoInvestimentos produtoInvestimentos) {
        this.produtoInvestimentos = produtoInvestimentos;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Investimento(BigDecimal valor, Date dataInvest, ProdutoInvestimentos produtoInvestimentos, BigDecimal adicional){
        this.dataInvest = dataInvest;
        this.produtoInvestimentos = produtoInvestimentos;
        this.valor = valor;
        this.adicional = adicional;
    }

    public Investimento(BigDecimal valor, ProdutoInvestimentos produtoInvestimentos, BigDecimal adicional){
        this.dataInvest = Calendar.getInstance().getTime();
        this.produtoInvestimentos = produtoInvestimentos;
        this.valor = valor;
        this.adicional = adicional;
    }

    public Investimento(BigDecimal valor, Date dataInvest, ProdutoInvestimentos produtoInvestimentos){
        this.dataInvest = dataInvest;
        this.produtoInvestimentos = produtoInvestimentos;
        this.valor = valor;
        this.adicional = new BigDecimal(0);
    }

    public Investimento(BigDecimal valor, ProdutoInvestimentos produtoInvestimentos) {
        this.dataInvest = Calendar.getInstance().getTime();
        this.produtoInvestimentos = produtoInvestimentos;
        this.valor = valor;
        this.adicional = new BigDecimal(0);
    }
}
