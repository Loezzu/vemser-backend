public class Pessoa {

    //atributos
    String nome;
    int idade;
    Telefone telefone;


    // luiz.mandarwhats( -> this.telefone = telefone do luiz
    //                   -> telefone... seria o passado por parametro
    public void mandarWhatsApp(String mensagem, Telefone telefone) {
        System.out.println("Telefone " + telefone + " recebeu " + mensagem + " de " + this.telefone);
    }

    //métodos / comportamento
    public void imprimirNome() {
        System.out.println(nome);
    }

    public int retornarIdade() {
        // ...
        return idade;
    }

    public void conversar(String mensagem, Pessoa pessoaQueEnviou){
        System.out.println("Pessoa " + this.nome + " enviou " + mensagem + " para " + pessoaQueEnviou.nome);
    }

    public int diferenciarIdade(Pessoa pessoa) {
        return idade - pessoa.idade;
    }

    @Override
    public String toString() {
        return "Objeto: nome: " + nome;
    }


}
