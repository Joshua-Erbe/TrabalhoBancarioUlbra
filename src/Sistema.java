import Contas.*;
import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco bancoUnidos = new Banco("Banco Unidos");
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Aplicar rendimento");
            System.out.println("5 - Listar Contas do Banco");
            System.out.println("6 - Saldo total");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Número da conta: ");
                    int numero = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome do titular: ");
                    String nome = sc.nextLine();

                    System.out.print("Qual conta deseja: [1] Corrente || [2] Poupança ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("Insira o Limite: ");
                        double limite = sc.nextDouble();
                        sc.nextLine();
                        ContaCorrente contaCriada = new ContaCorrente(numero, nome, limite);
                        bancoUnidos.adicionarConta(contaCriada);
                    } else {
                        System.out.print("Insira a Taxa de Rendimento: ");
                        double taxa = sc.nextDouble();
                        sc.nextLine();
                        ContaPoupança contaCriada = new ContaPoupança(numero, nome, taxa);
                        bancoUnidos.adicionarConta(contaCriada);
                    }
                    System.out.println("Conta criada com Sucesso!");
                    break;

                case 2:
                    System.out.print("Número da conta: ");
                    int numDep = sc.nextInt();
                    sc.nextLine();

                    Conta contaDeposito = bancoUnidos.buscarPorNumero(numDep);
                    if (contaDeposito == null) {
                        System.out.println("Conta não encontrada!");
                    } else {
                        System.out.print("Valor do depósito: ");
                        double valorDep = sc.nextDouble();
                        sc.nextLine();
                        contaDeposito.depositar(valorDep);
                        System.out.println("Deposito feito com sucesso!");
                    }
                    break;
                case 3:
                    System.out.print("Insira o Número da conta: ");
                    int numSaq = sc.nextInt();
                    sc.nextLine();

                    Conta contaSaq = bancoUnidos.buscarPorNumero(numSaq);
                    if (contaSaq == null) {
                        System.out.println("Conta não encontrada!");
                    } else {
                        System.out.print("Insira o Valor do saque: ");
                        double valorSaq = sc.nextDouble();
                        sc.nextLine();

                        if (contaSaq instanceof ContaCorrente) { //Obs: essa parte foi feita com ajuda de IA
                            ((ContaCorrente) contaSaq).sacarComLimite(valorSaq);
                        } else {
                            contaSaq.sacar(valorSaq);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Insira o Número da conta: ");
                    int numRend = sc.nextInt();
                    sc.nextLine();

                    Conta contaRend = bancoUnidos.buscarPorNumero(numRend);
                    if (contaRend == null) {
                        System.out.println("Conta não encontrada!");
                    } else if (contaRend instanceof ContaPoupança) { //Obs: essa parte foi feita com ajuda da IA
                        ((ContaPoupança) contaRend).aplicarRendimento();
                    } else {
                        System.out.println("Essa conta não é poupança!");
                    }
                    break;

                case 5:
                    bancoUnidos.listarContas();
                    break;

                case 6:
                    System.out.printf("Saldo total do banco: %.2f%n", bancoUnidos.saldoTotal());
                    break;

                case 0:
                    System.out.println("Bye bye :)");
                    break;

                default:
                    System.out.println("Opção incorreta, tente novamente!");
                    break;
            }
        }

        sc.close();
    }
}