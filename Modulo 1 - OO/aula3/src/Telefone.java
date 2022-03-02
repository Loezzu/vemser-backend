public class Telefone {
    String descricao;
    String numero;
    int tipo; // 1 comercial / 2 - residencial

    @Override
    public String toString() {
     return numero;
    }
}
