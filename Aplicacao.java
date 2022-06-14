package ProjetoModulo01;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    static Scanner scanner = new Scanner(System.in);
    static List<ProdutoInvestimentos> produtoInvestimentos = Produtos();
    public static void main(String[] args) {
        System.out.println("Seja Bem-Vindo ao Banco AJ");
        System.out.println("Qual é o seu nome?");
        String nome = scanner.next();
        int tipoPessoa = 0;
        Pessoa.TipoPessoa tipoPessoa1 = Pessoa.TipoPessoa.pessoa_juridica;
        while (true) {
            try {
                System.out.println("Que tipo de pessoa você é? ");
                System.out.println("Digite 1 para Pessoa Física");
                System.out.println("Digite 2 para Pessoa Jurídica");
                tipoPessoa = scanner.nextInt();
                switch (tipoPessoa) {
                    case 1:
                        tipoPessoa1 = Pessoa.TipoPessoa.pessoa_fisica;
                        break;
                    case 2:
                        tipoPessoa1 = Pessoa.TipoPessoa.pessoa_juridica;
                        break;
                    default:
                        System.out.println("Selecione um tipo de pessoa válida.");
                        break;
                }
                if(tipoPessoa == 1 || tipoPessoa == 2){
                    break;
                }
            }
            catch (Exception ex){
                System.out.println("Selecione um tipo de pessoa válida.");
                scanner.next();
            }
        }
        Cliente cliente = new Cliente(tipoPessoa1, nome);
        int opcao = 0;
        while (true)
        {
            try {
                System.out.println("Seja Bem-Vindo " + cliente.getNome() + " ao Banco AJ");
                System.out.println("O que você deseja fazer?");
                System.out.println("01. Abrir Uma Conta");
                System.out.println("02. Realizar um Saque");
                System.out.println("03. Realizar um Deposito");
                System.out.println("04. Realizar uma transferência");
                System.out.println("05. Investir");
                System.out.println("06. Consultar Saldo");
                System.out.println("07. Consultar Rendimento");
                System.out.println("08. Listar Todas as suas Contas");
                //System.out.println("09. Abrir Uma Conta");
                //System.out.println("10. Abrir Uma Conta");
                System.out.println("00. Para Sair");
                opcao = scanner.nextInt();
                switch (opcao){
                    case 1:
                        AbrirConta(cliente);
                        break;
                    case 2:
                        RealizarSaque(cliente);
                        break;
                    case 3:
                        RealizarDeposito(cliente);
                        break;
                    case 4:
                        RealizarTransferencia(cliente);
                        break;
                    case 5:
                        Investir(cliente);
                        break;
                    case 6:
                        ConsultarSaldo(cliente);
                        break;
                    case 7:
                        ConsultarRendimento(cliente);
                        break;
                    case 8:
                        ListarContas(cliente);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Selecione uma opção válida.");
                        break;
                }
                if(opcao == 0)
                {
                    System.out.println("Volte Sempre ao Banco AJ!");
                    break;
                }
            }
            catch (Exception ex){
                System.out.println("Selecione uma opção válida.");
                scanner.next();
            }
        }
    }

    public static void RealizarSaque(Cliente cliente) {
        if(cliente.getContas().stream().count() == 0){
            System.out.println("Você não possui nenhum conta.");
            return;
        }
        System.out.println("As suas Contas são as seguintes:");
        for (Conta conta :
                cliente.getContas()) {
            System.out.println(conta.toString());
        }
        System.out.println("De qual conta você deseja resalizar um saque?");
        String numeroConta = scanner.next();
        System.out.println("Qual o valor que você deseja sacar?");
        BigDecimal valor = scanner.nextBigDecimal();
        cliente.Sacar(numeroConta, valor);
    }

    public static void ListarContas(Cliente cliente) {
        if(cliente.getContas().stream().count() == 0){
            System.out.println("Você não possui nenhum conta.");
            return;
        }
        System.out.println("As suas Contas são as seguintes:");
        for (Conta conta :
                cliente.getContas()) {
            System.out.println(conta.toString());
        }
    }

    public static void AbrirConta(Cliente cliente){
        Conta.TipoConta contaTipo = Conta.TipoConta.conta_investimento;
        while (true) {
            try {
                System.out.println("Qual tipo de conta você gostaria de abrir?");
                int count = 1;
                for (Conta.TipoConta tipoConta :
                        Conta.TipoConta.values()) {
                    System.out.println(count + ". " + tipoConta.toString());
                    count++;
                }
                int tipoConta = scanner.nextInt();
                switch (tipoConta) {
                    case 1:
                        contaTipo = Conta.TipoConta.conta_corrente;
                        break;
                    case 2:
                        contaTipo = Conta.TipoConta.conta_poupanca;
                        break;
                    case 3:
                        contaTipo = Conta.TipoConta.conta_investimento;
                        break;
                    default:
                        System.out.println("Selecione uma opção válida.");
                        break;
                }
                if (!(tipoConta != 1 && tipoConta != 2 && tipoConta != 3)) {
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Selecione um tipo de conta válida.");
                scanner.next();
            }
        }
        cliente.AbrirConta(contaTipo, new BigDecimal(0), new BigDecimal(0));
    }

    public static void RealizarDeposito(Cliente cliente){
        if(cliente.getContas().stream().count() == 0){
            System.out.println("Você não possui nenhum conta.");
            return;
        }
        System.out.println("As suas Contas são as seguintes:");
        for (Conta conta :
                cliente.getContas()) {
            System.out.println(conta.toString());
        }
        System.out.println("Para qual conta você deseja resalizar um deposito?");
        String numeroConta = scanner.next();
        System.out.println("Qual o valor que você deseja depositar?");
        BigDecimal valor = scanner.nextBigDecimal();
        cliente.Depositar(numeroConta, valor);
    }

    public static void RealizarTransferencia(Cliente cliente){
        if(cliente.getContas().stream().count() == 0){
            System.out.println("Você não possui nenhum conta.");
            return;
        }
        System.out.println("As suas Contas são as seguintes:");
        for (Conta conta :
                cliente.getContas()) {
            System.out.println(conta.toString());
        }
        System.out.println("De qual conta você deseja resalizar uma transferência?");
        String numeroContaOrigem = scanner.next();
        System.out.println("Para qual conta você deseja resalizar uma transferência?");
        String numeroContaDestino = scanner.next();
        System.out.println("Qual o valor que você deseja transferir?");
        BigDecimal valor = scanner.nextBigDecimal();
        cliente.Transferencia(numeroContaOrigem, numeroContaDestino, valor);
    }

    public static void Investir(Cliente cliente){
        if(cliente.getContas().stream().count() == 0){
            System.out.println("Você não possui nenhum conta.");
            return;
        }
        System.out.println("As suas Contas são as seguintes:");
        for (Conta conta :
                cliente.getContas()) {
            System.out.println(conta.toString());
        }
        System.out.println("De qual conta você deseja resalizar um investimento?");
        String numeroConta = scanner.next();
        System.out.println("Para qual produto você deseja resalizar um investimento?");
        ListarProdutos();
        String nomeProduto = scanner.next();
        ProdutoInvestimentos produtoInvestimentos1 = produtoInvestimentos.stream().filter(p -> p.getProduto().equals(nomeProduto)).findAny().get();
        System.out.println("Qual o valor que você deseja Investir?");
        BigDecimal valor = scanner.nextBigDecimal();
        cliente.Investir(numeroConta, produtoInvestimentos1, valor);
    }

    public static void ConsultarSaldo(Cliente cliente){
        if(cliente.getContas().stream().count() == 0){
            System.out.println("Você não possui nenhum conta.");
            return;
        }
        System.out.println("As suas Contas são as seguintes:");
        for (Conta conta :
                cliente.getContas()) {
            System.out.println(conta.toString());
        }
        System.out.println("Para qual conta você deseja Consultar o Saldo?");
        String numeroConta = scanner.next();
        cliente.ConsultarSaldo(numeroConta);
    }

    public static void ConsultarRendimento(Cliente cliente){
        if(cliente.getContas().stream().count() == 0){
            System.out.println("Você não possui nenhum conta.");
            return;
        }
        System.out.println("As suas Contas são as seguintes:");
        for (Conta conta :
                cliente.getContas()) {
            System.out.println(conta.toString());
        }
        System.out.println("De qual conta você deseja consultar o Rendimento?");
        String numeroConta = scanner.next();
        cliente.ConsultarRendimento(numeroConta);
    }

    public static List<ProdutoInvestimentos> Produtos(){
        List<ProdutoInvestimentos> produtoInvestimentos = new ArrayList<>();
        //Tesouro Direto Selic
        produtoInvestimentos.add(new ProdutoInvestimentos("Tesouro Direto Selic", BigDecimal.valueOf(100L), BigDecimal.valueOf(0.0153f), 10));
        //CDB
        produtoInvestimentos.add(new ProdutoInvestimentos("CDB", BigDecimal.valueOf(100L), BigDecimal.valueOf(0.0278f), 1));
        //FII
        produtoInvestimentos.add(new ProdutoInvestimentos("FII", BigDecimal.valueOf(50L), BigDecimal.valueOf(0.0879f), 20));
        //BitCoin
        produtoInvestimentos.add(new ProdutoInvestimentos("BitCoin", BigDecimal.valueOf(5000L), BigDecimal.valueOf(0.02012f), 1));

        return produtoInvestimentos;
    }

    public static void ListarProdutos() {
        System.out.println("Os produtos disposniveus são os seguintes:");
        for (ProdutoInvestimentos produtoInvestimentos1 :
                produtoInvestimentos) {
            System.out.println(produtoInvestimentos1.toString());
        }
    }
}
