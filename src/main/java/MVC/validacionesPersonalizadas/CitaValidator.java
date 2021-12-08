package MVC.validacionesPersonalizadas;


import MVC.Entity.Cita;
import MVC.Entity.Paciente;
import MVC.Entity.Usuario;
import MVC.repo.ICitaRepo;
import MVC.repo.IEpisodioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CitaValidator implements Validator {
    @Autowired
    private ICitaRepo repo;

    @Override
    public boolean supports(Class<?> aClass) {
        return Paciente.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Cita cita = (Cita) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fechaDeCita", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "observaciones", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "servicio", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prestacion", "NotEmpty");

        if (cita.getPrestacion().equals("NONE")){
            errors.rejectValue("prestacion", "NotEmpty");
        }
        if (cita.getServicio().equals("NONE")){
            errors.rejectValue("servicio", "NotEmpty");
        }
        if (cita.getMedico().equals("NONE")){
            errors.rejectValue("medico", "NotEmpty");
        }
    }
}