public class ConversoresEWrappers {
    public static void main(String[] args) {

//        int meuInt = null;
        Integer meuWrapperInteger = null;
        Integer meuWrapperInteger2 = Integer.MAX_VALUE;

        System.out.println(meuWrapperInteger2);

        int meuInteger = 50;
        long meuLong = meuInteger;
        meuInteger = (int) meuLong;

        Integer valorInteger = 5;
        Long valorLongWrapper = valorInteger.longValue();
        valorInteger = valorLongWrapper.intValue();

//        String minhaStringNumero = "56";
//        int convertidaNumero = Integer.valueOf(minhaStringNumero);


        //string, int, bigdecimal... wrappers e primitivos, são passados por valor
        String nome = "Luiz";
        System.out.println(nome);
        passarPorValor(nome);
        System.out.println(nome);

        Pessoa pessoa = new Pessoa();
        pessoa.nome = "Francisco";
        System.out.println(pessoa);
        passarPorReferencia(pessoa);
        System.out.println(pessoa);

    }
    public static void passarPorValor(String valor) { //luiz
        valor = "teste";
    }

    public static void passarPorReferencia(Pessoa pessoa) {
        pessoa.nome = "batata";
    }
}
