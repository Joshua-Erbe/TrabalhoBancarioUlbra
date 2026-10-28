package Contas;

public class Conta {
    private final int numero;
    private final String titular;
    protected double saldo;

    public Conta(int numero, String nome) {
        this.numero = numero;
        this.titular = nome;
        this.saldo = 0.00;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular(){
        return titular;
    }

    public void depositar(double Deposito) {
        if (Deposito > 0) {
            this.saldo += Deposito;
        } else {
            System.out.print("Deposito Recusado! \n");
        }
    }

    public boolean sacar(double Saque) {
        if (saldo >= Saque && Saque > 0) {
            this.saldo -= Saque;
            return true;
        } else {
            System.out.printf("Saque de %s Recusado! \n", titular);
            return false;
        }
    }

    public void exibir(){
        System.out.print("\n");
        System.out.println("Dados da Conta!");
        System.out.format("Numero: %d \n", numero);
        System.out.format("Titular: %s \n", titular);
        System.out.format("Saldo: %.2f \n", saldo);
    }

    @Override
    public String toString() {
        return String.format("Dados da Conta - Nome do Titular: %s || Numero da Conta: %d || Saldo Atual: %.2f", titular, numero, saldo);
    }
}
