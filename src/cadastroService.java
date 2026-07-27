import java.util.ArrayList;
import java.util.List;
import java.util.Random.*;

public class cadastroService {
    private List<Usuario> listaUsuarios = new ArrayList<>();

    public boolean cadastroUsuario(Usuario usuario){
        
        // -- Valid Name -- //
        if (!validName(usuario.getName())){return false;}

        // -- Valid PassWord -- //
        if(!validPassword(usuario.getPassWord())){return false;}

        // -- Valid Email -- //
        if (!validEmail(usuario.getEmail())){return false;}
        
        // -- Valid ID -- //
        if (!validId(usuario.getID())){return false;}

        listaUsuarios.add(usuario);

        System.out.printf("User registered successfully! Assigned ID: %d %n", usuario.getID());
        return true;
    }

        public List<Usuario> getListaUsuario(){
            return listaUsuarios;
        }

        // -- Validation Name -- //
        private boolean validName(String name){
            try {
                if(name == null || name.trim().isEmpty()){throw new IllegalArgumentException("Name is not Empty");}
                if (name.length()>20){throw new IllegalArgumentException(" Name must not exceed 20 characters.");}
                if (!name.matches("^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$")){throw new IllegalArgumentException("Name honly Letters");} 
                return true;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro in name "+ e.getMessage());
                return  false;
            }
        }
        
        // --  Validation Password -- //
        private boolean validPassword(String password){
            try{
                if (password == null || password.trim().isEmpty()){throw new IllegalArgumentException ("Password is not Empty");}
                if ( password.length() > 20){throw new IllegalArgumentException("Password must not exceed 20 characters.");}
                return true;
            }catch (IllegalArgumentException e){
                System.out.println("Erro PassWord: " + e.getMessage());
                return false;
                }
            }

        // -- Validation Email -- //
        private boolean validEmail(String email){
            try {
                if (email == null || email.trim().isEmpty()){throw new IllegalArgumentException("Email is not Empty");}
                if (!email.contains("@")|| !email.contains(".")){throw new IllegalArgumentException("Format email invalid !");}
                return true;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro Email: " + e.getMessage());
                return false;
            }
        }

        // -- Validation ID -- //
        private boolean validId(int id){
            try{
                if(id < 1000 || id > 9999){
                    throw new IllegalArgumentException ("ID must be a 4-digit number");
                }
                return true;
            }catch (IllegalArgumentException e){
                System.out.println("Error ID: " + e.getMessage());
                return false;
            }
        }
}
    
