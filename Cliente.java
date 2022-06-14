package ProjetoModulo01;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private List<Conta> contas;

    public Cliente(TipoPessoa tipoPessoa, String nome){
        super(tipoPessoa, nome);
        contas = new ArrayList<>();
    }

    public List<Conta> getContas() {
        return contas;
    }

    public Conta getConta(String numeroConta) {
        return contas.stream().filter(conta -> numeroConta.equals(conta.getNumero())).findAny().orElse(null);
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void AbrirConta(Conta.TipoConta tipoConta, BigDecimal saldo, BigDecimal limite){
        try {
            Conta conta = Conta.AbrirConta(tipoConta, this, saldo, limite);
            contas.add(conta);
            System.out.println("Número da Conta Criada: " + conta.getNumero());
            System.out.println("Conta Criada com Sucesso!");
        }
        catch (Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    public void Sacar(String numeroConta, BigDecimal valor) {
        Conta conta = this.getConta(numeroConta);
        if(conta == null){
            System.out.println("Conta inexistente!");
            return;
        }
        Sacar(conta, valor);
    }

    public void Sacar(Conta conta, BigDecimal valor) {
        conta.Sacar(valor);
    }

    public void Depositar(String numeroConta, BigDecimal valor) {
        Conta conta = this.getConta(numeroConta);
        if(conta == null){
            System.out.println("Conta inexistente!");
            return;
        }
        Depositar(conta, valor);
    }

    public void Depositar(Conta conta, BigDecimal valor) {
        conta.Depositar(valor);
    }

    public void Transferencia(String numeroContaOrigem, String numeroContaDestino, BigDecimal valor){
        Conta contaOrigem = this.getConta(numeroContaOrigem);
        if(contaOrigem == null){
            System.out.println("Conta inexistente!");
            return;
        }
        Conta contaDestino = this.getConta(numeroContaDestino);
        if(contaDestino == null){
            System.out.println("Conta inexistente!");
            return;
        }
        contaOrigem.Sacar(valor);
        contaDestino.Depositar(valor);
        System.out.println("Tranferência realizado com sucesso!");
    }

    public void Transferencia(Conta contaOrigem, Conta contaDestino, BigDecimal valor){
        contaOrigem.Sacar(valor);
        contaDestino.Depositar(valor);
    }
    public void Investir(String numeroConta, ProdutoInvestimentos produtoInvestimentos, BigDecimal valor){
        Conta conta = this.getConta(numeroConta);
        if(conta == null){
            System.out.println("Conta inexistente!");
            return;
        }
        Investir(conta, produtoInvestimentos, valor);
    }
    public void Investir(Conta conta, ProdutoInvestimentos produtoInvestimentos, BigDecimal valor){
        try {
            conta.Investir(valor, produtoInvestimentos);
        }
        catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    public void ConsultarSaldo(String numeroConta) {
        Conta conta = this.getConta(numeroConta);
        if(conta == null){
            System.out.println("Conta inexistente!");
            return;
        }
        try {
            ConsultarSaldo(conta);
        }
        catch (Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    public void ConsultarSaldo(Conta conta) throws Exception {
        conta.ConsultarSaldo();
        /*if(conta.getTipoConta() != Conta.TipoConta.conta_investimento) {
            conta.ConsultarSaldo();
        }
        else {
            throw new Exception("Não é possível consultar o saldo para conta de investimento");
        }
        */
    }

    public void ConsultarRendimento(String numeroConta) {
        Conta conta = this.getConta(numeroConta);
        try {
            ConsultarRendimento(conta);
        }
        catch (Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    public void ConsultarRendimento(Conta conta) throws Exception {
        if(conta.getTipoConta() == Conta.TipoConta.conta_investimento) {
            conta.ConsultarRendimento();
        }
        else {
            throw new Exception("Não é possível consultar o rendimento para contas que não são de investimento");
        }
    }
}
