import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
    
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    private List<String> historico;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.historico = new ArrayList<>();
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            historico.add("Saque de R$ " + valor);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido!");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            historico.add("Depósito de R$ " + valor);
        } else {
            System.out.println("Valor de depósito inválido!");
        }
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (valor > 0 && saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            historico.add("Transferência de R$ " + valor + " para conta " + ((Conta) contaDestino).getNumero());
        } else {
            System.out.println("Transferência inválida! Verifique o saldo.");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public void imprimirExtrato() {
        System.out.println("\nExtrato da Conta:");
        for (String transacao : historico) {
            System.out.println(transacao);
        }
        System.out.println("-----------------------------");
    }
}
