package MVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Tu usuario o contraseña son invalidos.");

        if (logout != null)
            model.addAttribute("message", "Se ha salido correctamente de la aplicacion.");

        return "login";
    }
}
