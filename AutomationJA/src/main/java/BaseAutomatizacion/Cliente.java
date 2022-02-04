package BaseAutomatizacion;

public class Cliente {

    public String primerNombre;
    public String apellido;
    public String email;
    public String telefono;
    public String direccion;

    public String ciudad;
    public String pais;
    public String region;
    public String password;


    public Cliente(String email, String password) {
        this.primerNombre = "Jesus";
        this.apellido = "Perez";
        this.email = email;
        this.telefono = "994811454";
        this.direccion = "Las parcelas 22";
        this.ciudad = "sanda";
        this.pais = "Albania";
        this.region = "Berat";
        this.password = password;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public String getRegion() {
        return region;
    }

    public String getPassword() {
        return password;
    }
}
