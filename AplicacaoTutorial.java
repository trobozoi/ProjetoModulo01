package ProjetoModulo01;

import java.math.BigDecimal;

public class AplicacaoTutorial {
    public static void main(String[] args) throws Exception {
        //Criando produtos de investimentos
        //Tesouro Direto Selic
        ProdutoInvestimentos tesouroDiretoSelic = new ProdutoInvestimentos("Tesouro Direto Selic", BigDecimal.valueOf(100L), BigDecimal.valueOf(1.53f), 10);
        //CDB
        ProdutoInvestimentos CDB = new ProdutoInvestimentos("CDB", BigDecimal.valueOf(100L), BigDecimal.valueOf(2.78f), 1);
        //FII
        ProdutoInvestimentos FII = new ProdutoInvestimentos("FII", BigDecimal.valueOf(50L), BigDecimal.valueOf(8.79f), 60);
        //BitCoin
        ProdutoInvestimentos BitCoin = new ProdutoInvestimentos("BitCoin", BigDecimal.valueOf(5000L), BigDecimal.valueOf(20.12f), 1);
        //Criando Clientes
        Cliente cliente01 = new Cliente(Pessoa.TipoPessoa.pessoa_fisica, "Conta 01");
        Cliente cliente02 = new Cliente(Pessoa.TipoPessoa.pessoa_juridica, "Conta 02");
        //Criando conta de corrente
        cliente01.AbrirConta(Conta.TipoConta.conta_corrente, BigDecimal.valueOf(12345L), BigDecimal.valueOf(100L));
        cliente02.AbrirConta(Conta.TipoConta.conta_corrente, BigDecimal.valueOf(12345L), BigDecimal.valueOf(100L));
        //Criando conta de poupança
        cliente01.AbrirConta(Conta.TipoConta.conta_poupanca, BigDecimal.valueOf(10000L), BigDecimal.valueOf(0L));
        cliente02.AbrirConta(Conta.TipoConta.conta_poupanca, BigDecimal.valueOf(10000L), BigDecimal.valueOf(0L));
        //Criando conta de investimento
        cliente01.AbrirConta(Conta.TipoConta.conta_investimento, BigDecimal.valueOf(200000L), BigDecimal.valueOf(0L));
        cliente02.AbrirConta(Conta.TipoConta.conta_investimento, BigDecimal.valueOf(200000L), BigDecimal.valueOf(0L));
        //Sacar
        cliente01.Sacar(cliente01.getContas().get(0), BigDecimal.valueOf(100l));
        cliente02.Sacar(cliente02.getContas().get(0), BigDecimal.valueOf(100l));
        // Depositar
        cliente01.Depositar(cliente01.getContas().get(0), BigDecimal.valueOf(100l));
        cliente02.Depositar(cliente02.getContas().get(0), BigDecimal.valueOf(100l));
        // Transferência
        cliente01.Transferencia(cliente01.getContas().get(0), cliente01.getContas().get(1), BigDecimal.valueOf(100l));
        cliente02.Transferencia(cliente02.getContas().get(0), cliente02.getContas().get(1), BigDecimal.valueOf(100l));
        // Investir
        cliente01.Investir(cliente01.getContas().get(2), CDB, BigDecimal.valueOf(100l));
        cliente02.Investir(cliente02.getContas().get(1), FII, BigDecimal.valueOf(100l));
        // Consultar saldo (poupança e corrente).
        cliente01.ConsultarSaldo(cliente01.getContas().get(0));
        cliente02.ConsultarSaldo(cliente02.getContas().get(0));
        // Consultar Rendimento
        cliente01.ConsultarRendimento(cliente01.getContas().get(2));
        cliente02.ConsultarRendimento(cliente02.getContas().get(1));
    }
}
