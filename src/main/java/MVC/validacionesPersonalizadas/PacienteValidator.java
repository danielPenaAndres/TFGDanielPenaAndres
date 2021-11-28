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
        Pattern patronDNI = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
        Paciente paciente = (Paciente) o;
        Matcher matDNI = patronDNI.matcher(paciente.getDNI());

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "DNI", "NotEmpty");
        if (paciente.getDNI().length() < 6 || paciente.getDNI().length() > 32) {
            errors.rejectValue("DNI", "Size.paciente.DNI");
        }
        if (!matDNI.matches()) {
            errors.rejectValue("DNI", "Patron.paciente.DNI");
        }
        if (repo.findByDNI(paciente.getDNI()) != null && paciente.getId()==0) {
            errors.rejectValue("DNI", "Duplicate.paciente.DNI");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NotEmpty");
        if (paciente.getNombre().length() < 1 || paciente.getNombre().length() > 32) {
            errors.rejectValue("nombre", "Size.paciente.nombre");
        }
        if (paciente.getNombre().matches(".*\\d.*")) {
            errors.rejectValue("nombre", "Numeros.paciente.nombre");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "NotEmpty");
        if (paciente.getApellidos().length() < 1 || paciente.getApellidos().length() > 32) {
            errors.rejectValue("apellidos", "Size.paciente.apellidos");
        }
        if (paciente.getApellidos().matches(".*\\d.*")) {
            errors.rejectValue("apellidos", "Numeros.paciente.apellidos");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fechaDeNacimiento", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nacionalidad", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sexo", "NotEmpty");
    }
}