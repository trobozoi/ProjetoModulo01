package ProjetoModulo01;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

public class Conta {
    public enum TipoConta{
        conta_corrente,
        conta_poupanca,
        conta_investimento
    }
    private TipoConta tipoConta;
    private String numero;
    private Cliente cliente;
    private BigDecimal saldo;
    private BigDecimal limite;
    private Date dataInvestimento;
    private List<Investimento> investimentoList;

    public List<Investimento> getInvestimentoList() {
        return investimentoList;
    }

    public void setInvestimentoList(List<Investimento> investimentoList) {
        this.investimentoList = investimentoList;
    }

    public String getNumero() {
        return numero;
    }

    public Date getDataInvestimento() {
        return dataInvestimento;
    }

    public void setDataInvestimento(Date dataInvestimento) {
        this.dataInvestimento = dataInvestimento;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoConta getTipoConta(){
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta){
        this.tipoConta = tipoConta;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal consultarSaldo(){
        if(this.tipoConta == TipoConta.conta_investimento) {
            return null;
        }
        return this.saldo;
    }

    public static Conta AbrirConta(TipoConta tipoConta, Cliente cliente, BigDecimal saldo, BigDecimal limite) throws Exception {
        if(cliente.getTipoPessoa() == Pessoa.TipoPessoa.pessoa_juridica && tipoConta == TipoConta.conta_poupanca){
            throw new Exception("Não é possível criar conta do tipo poupança para pessoa jurídica");
        }
        Conta conta = new Conta();
        conta.tipoConta = tipoConta;
        conta.cliente = cliente;
        conta.saldo = saldo;
        conta.limite = limite;
        if(tipoConta == TipoConta.conta_investimento){
            conta.investimentoList = new ArrayList<>();
        }
        Random gerador = new Random();
        conta.numero = String.format("%1$15s", String.valueOf(Math.abs(gerador.nextInt()))).replace(' ', '0');
        return conta;
    }

    public void Sacar(BigDecimal valor){
        if(this.cliente.getTipoPessoa() == Pessoa.TipoPessoa.pessoa_fisica){
            //Pessoa Física
            if(this.saldo.compareTo(valor) < 0){
                System.out.println("Saldo insuficiente!");
                return;
            }
        }
        else {
            //Pessoa Jurídica
            valor = valor.add(valor.multiply(BigDecimal.valueOf(0.005f)));
            if(this.saldo.compareTo(valor) < 0){
                System.out.println("Saldo insuficiente!");
                return;
            }
        }
        this.saldo = this.saldo.subtract(valor);
        System.out.println("Saque Realizado com sucesso!");
    }

    public void Depositar(BigDecimal valor){
        this.saldo = this.saldo.add(valor);
        System.out.println("Deposito Realizado com sucesso!");
    }

    public void Investir(BigDecimal valor, ProdutoInvestimentos produtoInvestimentos) throws Exception {
        if(this.getSaldo().compareTo(valor)< 0)
        {
            System.out.println("Saldo insuficiente!");
            return;
        }
        if(produtoInvestimentos.getValor().compareTo(valor) > 0){
            System.out.println("Valor insuficiente para comprar esse produto!");
            return;
        }
        BigDecimal adicional = new BigDecimal(0);
        if (this.getCliente().getTipoPessoa() == Pessoa.TipoPessoa.pessoa_juridica) {
            adicional = new BigDecimal(0.02);
        }
        if (this.tipoConta == TipoConta.conta_investimento) {
            this.investimentoList.add(new Investimento(valor, Calendar.getInstance().getTime(), produtoInvestimentos, adicional));
            this.Sacar(valor);
        } else {
            throw new Exception("Não é possível fazer investimento nessa conta");
        }
        System.out.println("Investimento realizado com sucesso!");
    }

    @Override
    public String toString() {
        return "Conta:\n\t"
                + "Número da Conta: " + getNumero()
                + "\n\t"
                + "Tipo de conta: " + getTipoConta();
    }

    public void ConsultarSaldo(){
        System.out.println(NumberFormat.getCurrencyInstance().format(this.saldo));
    }

    public void ConsultarRendimento(){
        for (Investimento investimento :
                investimentoList) {
            System.out.println(investimento.getProdutoInvestimentos().getProduto() + " -> " + NumberFormat.getCurrencyInstance().format(investimento.getValorRende()));
        }
    }
}
