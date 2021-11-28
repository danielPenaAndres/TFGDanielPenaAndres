package MVC.validacionesPersonalizadas;


import MVC.Entity.Cliente;
import MVC.repo.IClienteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PacienteValidator implements Validator {
    @Autowired
    private IClienteRepo repo;

    @Override
    public boolean supports(Class<?> aClass) {
        return Cliente.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Pattern patron = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
        Cliente paciente = (Cliente) o;
        Matcher mat = patron.matcher(paciente.getDNI());

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "DNI", "NotEmpty");
        if (paciente.getDNI().length() < 6 || paciente.getDNI().length() > 32) {
            errors.rejectValue("DNI", "Patron.Cliente.DNI");
        }
        if (!mat.matches()) {
            errors.rejectValue("DNI", "Size.Cliente.DNI");
        }
        if (repo.findByDNI(paciente.getDNI()) != null && paciente.getId()==0) {
            errors.rejectValue("DNI", "Duplicate.Cliente.DNI");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NotEmpty");
        if (paciente.getNombre().length() < 1 || paciente.getNombre().length() > 32) {
            errors.rejectValue("nombre", "Size.Cliente.nombre");
        }
        if (paciente.getNombre().matches(".*\\d.*")) {
            errors.rejectValue("nombre", "Numeros.Cliente.nombre");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "NotEmpty");
        if (paciente.getApellidos().length() < 1 || paciente.getApellidos().length() > 32) {
            errors.rejectValue("apellidos", "Size.Cliente.apellidos");
        }
        if (paciente.getApellidos().matches(".*\\d.*")) {
            errors.rejectValue("apellidos", "Numeros.Cliente.apellidos");
        }

    }
}