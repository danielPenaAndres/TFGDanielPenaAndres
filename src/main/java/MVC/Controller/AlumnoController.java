package MVC.Controller;

import MVC.Alumno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @RequestMapping("/muestraFormulario")
    public String muestraFormulario(Model modelo){
    Alumno elAlumno=new Alumno();
    modelo.addAttribute("elAlumno",elAlumno);
    return "alumnoRegistroFormulario";
    }

    @RequestMapping("/procesarFormulario")
    public String procesarFormulario(@Valid @ModelAttribute("elAlumno") Alumno elAlumno, BindingResult resultadoValidacion){
        System.out.println(resultadoValidacion);
        if (!resultadoValidacion.hasErrors()) {
            return "confirmacionRegistroAlumno";
        }
        else {
            return "alumnoRegistroFormulario";
    }
    }
}
