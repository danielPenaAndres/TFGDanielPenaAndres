package MVC.Controller;


import MVC.Entity.*;
import MVC.Service.PacienteService;
import MVC.Service.EpisodioService;
import MVC.Service.UserService;
import MVC.repo.*;
import MVC.validacionesPersonalizadas.CitaValidator;
import MVC.validacionesPersonalizadas.EpisodioValidator;
import MVC.validacionesPersonalizadas.PacienteValidator;
import MVC.validacionesPersonalizadas.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/paciente")
public class ControladorCRUD {

    @RequestMapping("lista")
    public String muestraFormulario(Model modelo, @Param("DNI") String DNI){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();


        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("MEDICO"))){
            System.out.println("/////////////////USUARIO MEDICO//////////////////////////");
        //Obtener los pacientes desde el DAO
            List<Paciente> losPacientes= servicePaciente.listAll(DNI);
            //Agregar pacientes desde al modelo
            modelo.addAttribute("pacientes",losPacientes);
            return paginaPaciente(modelo,1,DNI);

        }


        else if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))){

            System.out.println("/////////////////USUARIO ADMIN//////////////////////////");
            List<Usuario> losUsuarios=serviceUsuario.listAll(DNI);
            //Agregar pacientes desde al modelo
            modelo.addAttribute("usuarios",losUsuarios);

            return paginaUsuario(modelo,1,DNI);
        }
        else{
            System.out.println("/////////////////USUARIO NORMAL//////////////////////////");
            //Obtener los pacientes desde el DAO
            List<Paciente> losPacientes=repoPaciente.findAllByDNI(username);
            //Agregar pacientes desde al modelo
            modelo.addAttribute("pacientes",losPacientes);
            return "lista-pacientes-usuario";}
    }
    @RequestMapping("/paginaPaciente={pageNumber}")
    public String paginaPaciente(Model modelo, @PathVariable("pageNumber") int pageNumber,@Param("DNI") String DNI){

            if (DNI==null || DNI.isEmpty() ){

                Page<Paciente> pages=servicePaciente.listAll(pageNumber,DNI);
                long totalElements= pages.getTotalElements();
                int totalPages=pages.getTotalPages();
                List<Paciente> pacientes=pages.getContent();
                modelo.addAttribute("number", pages.getNumber());
                modelo.addAttribute("totalPages", totalPages);
                modelo.addAttribute("totalElements", totalElements);
                modelo.addAttribute("size", pages.getSize());
                modelo.addAttribute("pacientes",pacientes);
                return "lista-pacientes";
            }
            else {
                Page<Paciente> pages=servicePaciente.listAll(pageNumber,DNI);
                long totalElements= pages.getTotalElements();
                int totalPages=pages.getTotalPages();
                List<Paciente> pacientes=servicePaciente.listAll(DNI);
                modelo.addAttribute("number", pages.getNumber());
                modelo.addAttribute("totalPages", totalPages);
                modelo.addAttribute("totalElements", totalElements);
                modelo.addAttribute("size", pages.getSize());
                modelo.addAttribute("pacientes",pacientes);
                return "lista-pacientes";
            }

    }
    @RequestMapping("/paginaUsuario={pageNumber}")
    public String paginaUsuario(Model modelo, @PathVariable("pageNumber") int pageNumber,@Param("DNI") String DNI){

        if (DNI==null || DNI.isEmpty() ){

            Page<Usuario> pages=serviceUsuario.listAll(pageNumber,DNI);
            long totalElements= pages.getTotalElements();
            int totalPages=pages.getTotalPages();
            List<Usuario> usuarios=pages.getContent();
            modelo.addAttribute("number", pages.getNumber());
            modelo.addAttribute("totalPages", totalPages);
            modelo.addAttribute("totalElements", totalElements);
            modelo.addAttribute("size", pages.getSize());
            modelo.addAttribute("usuarios",usuarios);
            return "lista-usuarios";
        }
        else {
            Page<Usuario> pages=serviceUsuario.listAll(pageNumber,DNI);
            long totalElements= pages.getTotalElements();
            int totalPages=pages.getTotalPages();
            List<Usuario> usuarios=serviceUsuario.listAll(DNI);
            modelo.addAttribute("number", pages.getNumber());
            modelo.addAttribute("totalPages", totalPages);
            modelo.addAttribute("totalElements", totalElements);
            modelo.addAttribute("size", pages.getSize());
            modelo.addAttribute("usuarios",usuarios);
            return "lista-usuarios";
        }

    }
    @RequestMapping("episodios")
    public String muestraEpisodios(@RequestParam("pacienteId") int Id,Model modelo, @Param("servicio") String servicio){
        //Obtener los pacientes desde el DAO
        this.idepi=Id;
        List<Episodio> losEpisodios=repoEpisodio.findAllByid_Id(Id);
        //Agregar pacientes desde al modelo
        modelo.addAttribute("episodios",losEpisodios);
        return "lista-episodios";
    }
    @RequestMapping("citas")
    public String muestraCitas(@RequestParam("pacienteId") int Id,Model modelo){
        //Obtener los pacientes desde el DAO
        this.idepi=Id;
        List<Cita> lasCitas=repoCitas.findAllByid_Id(Id);
        //Agregar pacientes desde al modelo
        modelo.addAttribute("citas",lasCitas);
        return "lista-citas";
    }
    @RequestMapping("episodiosUsuario")
    public String muestraEpisodiosUsuario(@RequestParam("pacienteId") int Id,Model modelo){
        //Obtener los pacientes desde el DAO
        this.idepi=Id;
        List<Episodio> losEpisodios=repoEpisodio.findAllByid_Id(Id);
        //Agregar pacientes desde al modelo
        modelo.addAttribute("episodios",losEpisodios);
        return "lista-episodios-usuario";
    }
    @RequestMapping("citasUsuario")
    public String muestraCitasUsuario(@RequestParam("pacienteId") int Id,Model modelo){
        //Obtener los pacientes desde el DAO
        this.idepi=Id;
        List<Cita> lasCitas=repoCitas.findAllByid_Id(Id);
        //Agregar pacientes desde al modelo
        modelo.addAttribute("citas",lasCitas);
        return "lista-citas-usuario";
    }
    @PostMapping("insertarPaciente")
    public String insertarPaciente(@ModelAttribute("paciente") Paciente elPaciente, BindingResult bindingResult){
        pacienteValidator.validate(elPaciente, bindingResult);
        if (bindingResult.hasErrors()) {
            return "formularioPaciente";
        }
        repoPaciente.save(elPaciente);
        return "redirect:/paciente/lista";
    }
    @PostMapping("insertarEpisodio")
    public String insertarEpisodio(@ModelAttribute("episodio") Episodio elEpisodio,BindingResult bindingResult){
        Paciente clie=new Paciente();
        clie.setId(this.idepi);
        elEpisodio.setId(clie);
        episodioValidator.validate(elEpisodio, bindingResult);
        if (bindingResult.hasErrors()) {
            return "formularioEpisodios";
        }
        repoEpisodio.save(elEpisodio);
        return "redirect:/paciente/episodios?pacienteId="+this.idepi;
    }

    @PostMapping("insertarCitas")
    public String insertarCita(@ModelAttribute("cita") Cita laCita, BindingResult bindingResult){
        Paciente clie=new Paciente();
        clie.setId(this.idepi);
        laCita.setId(clie);
        citaValidator.validate(laCita, bindingResult);
        if (bindingResult.hasErrors()) {
            return "formularioCitas";
        }
        repoCitas.save(laCita);
        return "redirect:/paciente/citas?pacienteId="+this.idepi;
    }
    @PostMapping("insertarUsuario")
    public String insertarUsuario(@ModelAttribute("usuario") Usuario elUsuario, BindingResult bindingResult){
        userValidator.validate(elUsuario, bindingResult);
        if (bindingResult.hasErrors()) {
            return "formularioUsuario";
        }
        String claveCrypt=encoder.encode(elUsuario.getClave());
        elUsuario.setClave(claveCrypt);
        System.out.println(elUsuario.getDNI()+"////////////////////////////////////////");
        repoUsuario.save(elUsuario);
        return "redirect:/paciente/lista";
    }
    @RequestMapping("muestraFormularioEpisodio")
    public String muestraFormularioEpisodio(Model modelo){
        //Bind de datos
        Episodio elEpisodio=new Episodio();
        modelo.addAttribute("episodio",elEpisodio);
        List<String> losServicios=repoServicio.findAllServicios();
        modelo.addAttribute("servicio",losServicios);
        return "formularioEpisodios";
    }
    @RequestMapping("muestraFormularioCita")
    public String muestraFormularioCita(Model modelo){
        //Bind de datos
        Cita laCita=new Cita();
        modelo.addAttribute("cita",laCita);
        List<String> lasPrestaciones=repoPrestacion.findAllPrestaciones();
        modelo.addAttribute("prestacion",lasPrestaciones);
        List<String> losServicios=repoServicio.findAllServicios();
        modelo.addAttribute("servicio",losServicios);
        return "formularioCitas";
    }
    @RequestMapping("muestraFormularioAgregar")
    public String muestraFormularioAgregar(Model modelo){
        //Bind de datos
        Paciente elPaciente=new Paciente();
        modelo.addAttribute("paciente",elPaciente);
        List<String> losPaises=repoPais.findAllPaises();
        modelo.addAttribute("pais",losPaises);
        return "formularioPaciente";
    }
    @RequestMapping("muestraFormularioUsuario")
    public String muestraFormularioUsuario(Model modelo){
        //Bind de datos
        Usuario elUsuario=new Usuario();
        modelo.addAttribute("usuario",elUsuario);
        return "formularioUsuario";
    }
    @GetMapping("eliminar")
    public String eliminarPaciente(@RequestParam("pacienteId") int Id){
        //Eliminar paciente
        repoPaciente.deleteById(Id);
        //Reddirecionnar a lista pacientes
        return "redirect:/paciente/lista";
    }
    @GetMapping("eliminarUsuario")
    public String eliminarUsuario(@RequestParam("usuarioId") int Id){
        //Eliminar paciente
        repoUsuario.deleteById(Id);
        //Reddirecionnar a lista pacientes
        return "redirect:/paciente/lista";
    }


    @GetMapping("eliminarEpisodio")
    public String eliminarEpisodio(@RequestParam("episodioId") int Id){
        //Eliminar paciente
        repoEpisodio.deleteById(Id);
        //Reddirecionnar a lista pacientes
        return "redirect:/paciente/episodios?pacienteId="+this.idepi;
    }
    @GetMapping("eliminarCita")
    public String eliminarCita(@RequestParam("citaId") int Id){
        //Eliminar paciente
        repoCitas.deleteById(Id);
        //Reddirecionnar a lista pacientes
        return "redirect:/paciente/citas?pacienteId="+this.idepi;
    }

    @GetMapping("muestraFormularioActualizar")
    public String muestraFormularioActualizar(@RequestParam("pacienteId") int Id,Model modelo){
        //Obtener paciente
        Paciente elPaciente=repoPaciente.getById(Id);
        //Obtener el paciente como atributo del modelo
        modelo.addAttribute("paciente",elPaciente);
        List<String> losPaises=repoPais.findAllPaises();
        modelo.addAttribute("pais",losPaises);
        //enviar al formulario
        return "formularioPaciente";
    }
    @GetMapping("muestraEpisodioActualizar")
    public String muestraEpisodioActualizar(@RequestParam("episodioId") int Id,Model modelo){
        //Obtener paciente
        Episodio elEpisodio=repoEpisodio.getById(Id);
        //Obtener el paciente como atributo del modelo
        modelo.addAttribute("episodio",elEpisodio);
        List<String> losServicios=repoServicio.findAllServicios();
        modelo.addAttribute("servicio",losServicios);
        //enviar al formulario
        return "formularioEpisodios";
    }
    @GetMapping("muestraCitaActualizar")
    public String muestraCitaActualizar(@RequestParam("citaId") int Id,Model modelo){
        //Obtener paciente
        Cita laCita=repoCitas.getById(Id);
        //Obtener el paciente como atributo del modelo
        modelo.addAttribute("cita",laCita);
        List<String> lasPrestaciones=repoPrestacion.findAllPrestaciones();
        modelo.addAttribute("prestacion",lasPrestaciones);
        List<String> losServicios=repoServicio.findAllServicios();
        modelo.addAttribute("servicio",losServicios);
        //enviar al formulario
        return "formularioCitas";
    }
    @GetMapping("muestraUsuarioActualizar")
    public String muestraUsuarioActualizar(@RequestParam("usuarioId") int Id,Model modelo){
        //Obtener paciente
        Usuario elUsuario=repoUsuario.getById(Id);
        //Obtener el paciente como atributo del modelo
        modelo.addAttribute("usuario",elUsuario);
        //enviar al formulario
        return "formularioUsuario";
    }

    private int idepi;

    @Autowired
    private IPacienteRepo repoPaciente;

    @Autowired
    private IEpisodioRepo repoEpisodio;

    @Autowired
    private ICitaRepo repoCitas;

    @Autowired
    private IUsuarioRepo repoUsuario;

    @Autowired
    private IPaisRepo repoPais;

    @Autowired
    private IServicioRepo repoServicio;

    @Autowired
    private IPrestacionRepo repoPrestacion;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private PacienteService servicePaciente;

    @Autowired
    private UserService serviceUsuario;

    @Autowired
    private EpisodioService serviceEpisodio;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private PacienteValidator pacienteValidator;

    @Autowired
    private EpisodioValidator episodioValidator;

    @Autowired
    private CitaValidator citaValidator;
}