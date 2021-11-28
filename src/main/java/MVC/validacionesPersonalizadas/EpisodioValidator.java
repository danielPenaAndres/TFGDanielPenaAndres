package MVC.validacionesPersonalizadas;


import MVC.Entity.Paciente;
import MVC.repo.IEpisodioRepo;
import MVC.repo.IPacienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EpisodioValidator implements Validator {
    @Autowired
    private IEpisodioRepo repo;

    @Override
    public boolean supports(Class<?> aClass) {
        return Paciente.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fechaDelEpisodio", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "observaciones", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "servicio", "NotEmpty");
    }
}