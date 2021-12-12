package MVC.validacionesPersonalizadas;


import MVC.Entity.Episodio;
import MVC.Entity.Paciente;
import MVC.repo.IEpisodioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

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
        Episodio episodio = (Episodio) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fechaInicioDelEpisodio", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "observaciones", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "servicio", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tipo", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "diagnostico", "NotEmpty");
        if (episodio.getServicio().equals("NONE")){
            errors.rejectValue("servicio", "NotEmpty");
        }
        if (episodio.getTipo().equals("NONE")){
            errors.rejectValue("tipo", "NotEmpty");
        }
        if (episodio.getTipo().equals("NONE")){
            errors.rejectValue("diagnostico", "NotEmpty");
        }
        if (episodio.getFechaInicioDelEpisodio().after(episodio.getFechaFinDelEpisodio())){
            errors.rejectValue("fechaInicioDelEpisodio", "badDate.episodio.fechaInicioDelEpisodio");
        }


    }
}