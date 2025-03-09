import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        if (conta != null) {
            contas.add(conta);
            System.out.println("Conta adicionada com sucesso!");
        } else {
            System.out.println("Erro: Conta inválida!");
        }
    }

    public void listarContas() {
        System.out.println("\nLista de Contas no Banco " + nome + ":");
        for (Conta conta : contas) {
            System.out.println("Número: " + conta.getNumero() + " | Titular: " + conta.cliente.getNome() + " | Saldo: R$ " + conta.getSaldo());
        }
    }

    public Conta buscarContaPorNumero(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        System.out.println("Conta não encontrada!");
        return null;
    }
}
