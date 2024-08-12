public abstract class Conta implements IConta{

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private Cliente cliente;
    protected int agencia;
    protected int id;
    protected double saldo;

    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.id = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.id));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public int getAgencia() {
        return agencia;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }
}
