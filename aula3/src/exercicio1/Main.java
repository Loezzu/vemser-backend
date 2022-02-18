package exercicio1;

public class Main {
    public static void main(String[] args) {

        Pessoa guilherme = new Pessoa();
        guilherme.nome = "Guilherme";
        guilherme.sobrenome = "Cidade";
        guilherme.idade = 20;
        guilherme.whatsApp = 666666666;

        Pessoa gabriel = new Pessoa();
        gabriel.nome = "Gabriel";
        gabriel.sobrenome = "Poersch";
        gabriel.idade = 25;
        gabriel.whatsApp = 77777777;

        guilherme.conversar(gabriel);
        System.out.println(guilherme.retornarNomeCompleto());

        System.out.println("é maior de idade? " + gabriel.ehMaiorDeIdade());
        gabriel.mandarWhatsApp(guilherme, "olá meu amigo!");



    }
}
