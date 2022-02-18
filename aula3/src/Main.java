public class Main {
    public static void main(String[] args) {
        Pessoa luiz = new Pessoa();
        luiz.idade = 19;
        luiz.nome = "Luiz Souza";
        luiz.telefone = new Telefone();
        luiz.telefone.descricao = "whatsapp";
        luiz.telefone.tipo = 2;
        luiz.telefone.numero = "123456789";

        Pessoa nicolas = new Pessoa();
        nicolas.idade = 18;
        nicolas.nome = "Nicolas";
        nicolas.telefone = new Telefone();
        nicolas.telefone.descricao = "whatsapp";
        nicolas.telefone.tipo = 1;
        nicolas.telefone.numero = "987654321";

//
//        luiz.imprimirNome();
//
//        int idadeLuiz = luiz.retornarIdade();
//        System.out.println(idadeLuiz);

        luiz.conversar("Adoro musica!" , nicolas);

        System.out.println(luiz);
        System.out.println(nicolas);
        System.out.println(luiz.diferenciarIdade(nicolas));
        luiz.mandarWhatsApp("Olá nicolas", nicolas.telefone);
    }
}
