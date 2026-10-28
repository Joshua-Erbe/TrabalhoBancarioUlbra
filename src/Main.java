import Contas.*;

public class Main {
    public static void main(String[] args) {
        //Passo 1
        Banco bancoUnidos = new Banco("BancoUnidos");

        //Passo 2
        Conta contaAnna = new Conta(1000, "Anna");
        ContaPoupança contaJoshua = new ContaPoupança(2000, "Joshua", 0.10);
        ContaCorrente contaDaniel = new ContaCorrente(3000, "Daniel", 5000);

        //Passo 3
        bancoUnidos.adicionarConta(contaAnna);
        bancoUnidos.adicionarConta(contaJoshua);
        bancoUnidos.adicionarConta(contaDaniel);

        //Passo 4
        contaAnna.depositar(400);
        contaDaniel.depositar(10000);
        contaDaniel.sacar(3000);
        contaJoshua.depositar(1000);

        //Passo 5
        System.out.printf("Ana consegue sacar 200: %b \n", contaAnna.sacar(500));
        System.out.printf("Ana efetua um saque de 100: %b \n", contaAnna.sacar(100));

        //Passo 6
        System.out.printf("O Saldo atual do %s é %.2f \n", contaJoshua.getTitular(), contaJoshua.getSaldo());
        contaJoshua.aplicarRendimento();
        System.out.printf("O Saldo do %s apos o rendimento é de: %.2f \n", contaJoshua.getTitular(), contaJoshua.getSaldo());

        //Passo 7
        System.out.printf("Saldo do Daniel antes do saque: %.2f \n", contaDaniel.getSaldo());
        System.out.printf("Daniel consegue sacar 13.000: %b \n", contaDaniel.sacarComLimite(12000.00));
        System.out.printf("Saldo do Daniel depois do saque: %.2f \n", contaDaniel.getSaldo());

        //Passo Extra
        System.out.print("\n");
        System.out.printf("Mostre a Conta de numero 1000");
        Conta Conta1000 = bancoUnidos.buscarPorNumero(1000);
        Conta1000.exibir();
        System.out.printf("Mostre a Conta de numero 2 \n");
        Conta Conta2 = bancoUnidos.buscarPorNumero(2);
        System.out.println(Conta2);

        //Passo 8
        bancoUnidos.listarContas();
        System.out.print("\n");
        System.out.printf("O Saldo total do banco %s é de %.2f", bancoUnidos.getNome(), bancoUnidos.saldoTotal());
    }
}