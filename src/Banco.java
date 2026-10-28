import Contas.Conta;

import java.util.ArrayList;

public class Banco {
    private String nome;
    private ArrayList<Conta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public Conta buscarPorNumero(int numero) {
        return this.contas.stream()
                .filter(conta -> conta.getNumero() == numero)
                .findFirst()
                .orElse(null);

    }

    public void listarContas() {
        for (Conta conta : contas) {
            conta.exibir();
        }
    }

    public double saldoTotal() {
        double total = 0.0;

        for (int i = 0; i<contas.size(); i++) {
            total += contas.get(i).getSaldo();
        }
        return total;
    }

    public String getNome() {
        return this.nome;
    }
}