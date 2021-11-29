package MVC.validacionesPersonalizadas;


import MVC.Entity.Usuario;
import MVC.Service.UserService;
import MVC.repo.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {
    @Autowired
    private IUsuarioRepo repo;

    @Override
    public boolean supports(Class<?> aClass) {
        return Usuario.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Pattern patron = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
        Usuario user = (Usuario) o;
        Matcher mat = patron.matcher(user.getDNI());

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "DNI", "NotEmpty");
        if (user.getDNI().length() < 6 || user.getDNI().length() > 32) {
            errors.rejectValue("DNI", "Patron.usuario.DNI");
        }
        if (!mat.matches()) {
            errors.rejectValue("DNI", "Size.usuario.DNI");
        }
        if (repo.findByDNI(user.getDNI()) != null && user.getId()==0) {
            errors.rejectValue("DNI", "Duplicate.usuario.DNI");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clave", "NotEmpty");
        if (user.getClave().length() < 3 || user.getClave().length() > 32) {
            errors.rejectValue("clave", "Size.usuario.clave");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Tipo", "NotEmpty");
        if (user.getTipo().length() < 3 || user.getTipo().length() > 32) {
            errors.rejectValue("Tipo", "Size.usuario.Tipo");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NotEmpty");
        if (user.getNombre().length() < 1 || user.getNombre().length() > 32) {
            errors.rejectValue("nombre", "Size.usuario.nombre");
        }
        if (user.getNombre().matches(".*\\d.*")) {
            errors.rejectValue("nombre", "Numeros.usuario.nombre");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "NotEmpty");
        if (user.getApellidos().length() < 1 || user.getApellidos().length() > 32) {
            errors.rejectValue("apellidos", "Size.usuario.apellidos");
        }
        if (user.getApellidos().matches(".*\\d.*")) {
            errors.rejectValue("apellidos", "Numeros.usuario.apellidos");
        }
        if (user.getTipo().equals("NONE")){
            errors.rejectValue("Tipo", "NotEmpty");
        }
    }
}