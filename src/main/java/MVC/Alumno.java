package MVC;


import MVC.validacionesPersonalizadas.cPostalMadrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.DataBinder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.InitBinder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Alumno {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOptativas() {
        return optativas;
    }

    public void setOptativas(String optativa) {
        this.optativas = optativa;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @NotNull
    @Size(min = 1, max =150, message = "La edad no es correcta")
    private int edad;
    @Email
    private String email;
    private String apellido;
    private String optativas;
    private String centro;
    private String idioma;
    @NotNull
    @Size(min = 3, max =20,message = "El nombre no es correcto")
    private String nombre;

    //@Pattern(regexp = "[0-9]{5}",message = "Solo 5 valores numericos")
    @cPostalMadrid
    private String codigoPostal;
}
