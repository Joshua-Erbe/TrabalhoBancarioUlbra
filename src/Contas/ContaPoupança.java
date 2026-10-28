package Contas;

public class ContaPoupança extends Conta{
    private final double taxaRendimento;

    public ContaPoupança(int numero, String nome, double taxa) {
        super(numero, nome);
        this.taxaRendimento = taxa;
    }

    public void aplicarRendimento() {
        if (taxaRendimento == 0) {
            System.out.print("Não é possivel aplicar com a taxa de Rendimento atual \n");
        } else {
            this.saldo += (taxaRendimento * saldo);
        }
    }

    /* Criei de maneira opcional por isso esta comentado
    public void alterarTaxaRendimento(double Taxa) {
        this.TaxaRendimento = Taxa;
    }
    */

    public double getTaxaRendimento() {
        return taxaRendimento;
    }
}
