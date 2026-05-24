package validadores;

public class validaEmail {


    public static boolean ValidadorEmail(String email){

        String emailvalidaor = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

        if (email == null){
            return  false;
        }

        if (email.matches(emailvalidaor)){
            return true;
        }
        else{
            return false;
        }
    }
}
