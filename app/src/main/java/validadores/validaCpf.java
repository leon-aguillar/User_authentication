package validadores;

public class validaCpf {

    public static boolean ValidadorCpf(String cpf){


        int[] vetor;
        int mutiplicar = 10;
        int mutiplicar2 = 11;
        int soma = 0;                   // variaveis que usei
        int soma2 = 0;
        int digitovec1;
        int digitovec2;

        if (cpf.length() == 11) {


            vetor = new int[cpf.length()];// cria o vetor

            for (int i = 0; i < cpf.length(); i++) {
                vetor[i] = Integer.parseInt(cpf.substring(i, i + 1)); // transforma o texto em numero
            }

            boolean iguais = true;                                         // verifica se os numeros são iguais pois numeros iguais passam pela vec

            for (int i = 1; i < 11; i++) {
                if (vetor[i] != vetor[0]) {
                    iguais = false;
                    break;
                }
            }

            if (iguais == false) {

                for (int i = 0; i < 9; i++) {
                    soma = soma + (vetor[i] * mutiplicar); // primeiro digito verificador
                    mutiplicar--;
                }

                for (int i = 0; i < 10; i++) {
                    soma2 = soma2 + (vetor[i] * mutiplicar2); // segundo digito verificador
                    mutiplicar2--;
                }

                digitovec1 = 11 - (soma % 11); // os resultados finais
                digitovec2 = 11 - (soma2 % 11);


                if (digitovec1 > 9) {
                    digitovec1 = 0;
                }
                if (digitovec2 > 9) {
                    digitovec2 = 0;
                }

                if (vetor[9] == digitovec1 && vetor[10] == digitovec2) {
                    return true; // aqui valida que esta certo


                } else {
                    return false; // aqui valida que esta errado

                }



            } else {
                return false; // aqui valida que esta errado (valida se é numero iguais)
            }


        } else {
            return false; // aqui valida que esta errado (valida se o tamanho = 11)
        }

    }

}
