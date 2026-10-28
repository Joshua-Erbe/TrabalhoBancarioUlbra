package Contas;

public class ContaCorrente extends Conta{
    private final double limite;

    public ContaCorrente(int numero, String nome, double limite) {
        super(numero, nome);
        this.limite = limite;
    }

    public boolean sacarComLimite(Double valor) {
        double valortotal = limite + saldo;
        if (valortotal >= valor && valor > 0) {
            this.saldo -= valor;
            return true;
        } else {
            System.out.print("Saque não autorizado!");
            return false;
        }
    };

    public double getLimite () {
        return this.limite;
    }
}
