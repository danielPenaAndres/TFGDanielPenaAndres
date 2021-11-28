package MVC.validacionesPersonalizadas;


import MVC.Entity.Paciente;
import MVC.repo.IPacienteRepo;

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
    private IPacienteRepo repo;

    @Override
    public boolean supports(Class<?> aClass) {
        return Paciente.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Pattern patron = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
        Paciente paciente = (Paciente) o;
        Matcher mat = patron.matcher(paciente.getDNI());

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "DNI", "NotEmpty");
        if (paciente.getDNI().length() < 6 || paciente.getDNI().length() > 32) {
            errors.rejectValue("DNI", "Patron.Paciente.DNI");
        }
        if (!mat.matches()) {
            errors.rejectValue("DNI", "Size.Paciente.DNI");
        }
        if (repo.findByDNI(paciente.getDNI()) != null && paciente.getId()==0) {
            errors.rejectValue("DNI", "Duplicate.Paciente.DNI");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NotEmpty");
        if (paciente.getNombre().length() < 1 || paciente.getNombre().length() > 32) {
            errors.rejectValue("nombre", "Size.Paciente.nombre");
        }
        if (paciente.getNombre().matches(".*\\d.*")) {
            errors.rejectValue("nombre", "Numeros.Paciente.nombre");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "NotEmpty");
        if (paciente.getApellidos().length() < 1 || paciente.getApellidos().length() > 32) {
            errors.rejectValue("apellidos", "Size.Paciente.apellidos");
        }
        if (paciente.getApellidos().matches(".*\\d.*")) {
            errors.rejectValue("apellidos", "Numeros.Paciente.apellidos");
        }

    }
}