public class Usuario {

    private String name;
    private String password;
    private String email;
    private int id;

    public Usuario (String name, String password, String email, int id){
        this.name = name;
        this.password = password;
        this.email = email;
        this.id = id;
    }

    // -- ID -- //
    public Integer getID() { return id;}
    public void setID(int id){}
    
   // -- Name -- //
    public void setName(String name){this.name = name;}
    public String getName(){return name;}
    
    
    // -- PassWord -- //
    public void setPassWord(String password){this.password = password;}
    public String getPassWord(){return password;}
    
    
    // -- Email -- //
    public String getEmail () {return email;}
    public void setEmail(String email){this.email = email;}
    
    public String toTxtLine(){
        return id + ';' + name + ";" + email + ";" + password;
    }

    @Override
    public String toString(){
        return "ID:" + id + " | Nome:" + name + " | Email: " + email;
    }
    
}
