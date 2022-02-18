package exercicio1;

public class Pessoa {
    String nome;
    String sobrenome;
    int idade;
    int whatsApp;

    public void conversar(Pessoa pessoa) {
        System.out.println(this.nome + " conversou com " + pessoa.nome);
    }

    public String retornarNomeCompleto() {
        return nome + " " + sobrenome;
    }

    public boolean ehMaiorDeIdade() {
        return idade >= 18;
    }

    public void mandarWhatsApp(Pessoa pessoa, String mensagem) {
        System.out.println(this.nome + " enviou: " + mensagem + " para " + pessoa.nome);
    }

}
