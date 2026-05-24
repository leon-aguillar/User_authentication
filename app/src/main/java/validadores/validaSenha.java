package validadores;

public class validaSenha {
    public static boolean ValidadorSenha(String senha){

        if(senha == null){
            return  false;
        }

        if(senha.length() == 6){
            return true;
        }else {
            return false;

        }
    }
}
