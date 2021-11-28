package MVC.Controller;


import MVC.Entity.Cita;
import MVC.Entity.Cliente;
import MVC.Entity.Episodio;
import MVC.Entity.Usuario;
import MVC.Service.ClienteService;
import MVC.Service.EpisodioService;
import MVC.repo.ICitaRepo;
import MVC.repo.IClienteRepo;
import MVC.repo.IEpisodioRepo;
import MVC.repo.IUsuarioRepo;
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
        //Obtener los clientes desde el DAO
            List<Cliente> losClientes= servicePaciente.listAll(DNI);
            //Agregar clientes desde al modelo
            modelo.addAttribute("clientes",losClientes);
            return paginaPaciente(modelo,1,DNI);

        }


        else if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))){

            System.out.println("/////////////////USUARIO ADMIN//////////////////////////");
            List<Usuario> losUsuarios=repoUsuario.findAll();
            //Agregar clientes desde al modelo
            modelo.addAttribute("usuarios",losUsuarios);
            return "lista-usuarios";}
        else{
            System.out.println("/////////////////USUARIO NORMAL//////////////////////////");
            //Obtener los clientes desde el DAO
            List<Cliente> losClientes=repoPaciente.findAllByDNI(username);
            //Agregar clientes desde al modelo
            modelo.addAttribute("clientes",losClientes);
            return "lista-clientes-usuario";}
    }
    @RequestMapping("/paginaPaciente={pageNumber}")
    public String paginaPaciente(Model modelo, @PathVariable("pageNumber") int pageNumber,@Param("DNI") String DNI){

            if (DNI==null || DNI.isEmpty() ){

                Page<Cliente> pages=servicePaciente.listAll(pageNumber,DNI);
                long totalElements= pages.getTotalElements();
                int totalPages=pages.getTotalPages();
                List<Cliente> clientes=pages.getContent();
                modelo.addAttribute("number", pages.getNumber());
                modelo.addAttribute("totalPages", totalPages);
                modelo.addAttribute("totalElements", totalElements);
                modelo.addAttribute("size", pages.getSize());
                modelo.addAttribute("clientes",clientes);
                return "lista-clientes";
            }
            else {
                Page<Cliente> pages=servicePaciente.listAll(pageNumber,DNI);
                long totalElements= pages.getTotalElements();
                int totalPages=pages.getTotalPages();
                List<Cliente> clientes=servicePaciente.listAll(DNI);
                modelo.addAttribute("number", pages.getNumber());
                modelo.addAttribute("totalPages", totalPages);
                modelo.addAttribute("totalElements", totalElements);
                modelo.addAttribute("size", pages.getSize());
                modelo.addAttribute("clientes",clientes);
                return "lista-clientes";
            }

    }
    @RequestMapping("/paginaEpisodio={pageNumber}")
    public String paginaEpisodio(Model modelo, @PathVariable("pageNumber") int pageNumber,@Param("servicio") String servicio){

        if (servicio==null || servicio.isEmpty() ){

            Page<Episodio> pages=serviceEpisodio.listAll(pageNumber,servicio);
            long totalElements= pages.getTotalElements();
            int totalPages=pages.getTotalPages();
            List<Episodio> episodios=pages.getContent();
            modelo.addAttribute("number", pages.getNumber());
            modelo.addAttribute("totalPages", totalPages);
            modelo.addAttribute("totalElements", totalElements);
            modelo.addAttribute("size", pages.getSize());
            modelo.addAttribute("episodios",episodios);
            return "lista-episodios";
        }
        else {
            Page<Episodio> pages=serviceEpisodio.listAll(pageNumber,servicio);
            long totalElements= pages.getTotalElements();
            int totalPages=pages.getTotalPages();
            List<Episodio> episodios=serviceEpisodio.listAll(servicio);
            modelo.addAttribute("number", pages.getNumber());
            modelo.addAttribute("totalPages", totalPages);
            modelo.addAttribute("totalElements", totalElements);
            modelo.addAttribute("size", pages.getSize());
            modelo.addAttribute("episodios",episodios);
            return "lista-episodios";
        }

    }
    @RequestMapping("episodios")
    public String muestraEpisodios(@RequestParam("clienteId") int Id,Model modelo, @Param("servicio") String servicio){
        //Obtener los clientes desde el DAO
        this.idepi=Id;
        List<Episodio> losEpisodios=repoEpisodio.findAllByid_Id(Id);
        //Agregar clientes desde al modelo
        modelo.addAttribute("episodios",losEpisodios);
        return "lista-episodios";
    }
    @RequestMapping("citas")
    public String muestraCitas(@RequestParam("clienteId") int Id,Model modelo){
        //Obtener los clientes desde el DAO
        this.idepi=Id;
        List<Cita> lasCitas=repoCitas.findAllByid_Id(Id);
        //Agregar clientes desde al modelo
        modelo.addAttribute("citas",lasCitas);
        return "lista-citas";
    }
    @RequestMapping("episodiosUsuario")
    public String muestraEpisodiosUsuario(@RequestParam("clienteId") int Id,Model modelo){
        //Obtener los clientes desde el DAO
        this.idepi=Id;
        List<Episodio> losEpisodios=repoEpisodio.findAllByid_Id(Id);
        //Agregar clientes desde al modelo
        modelo.addAttribute("episodios",losEpisodios);
        return "lista-episodios-usuario";
    }
    @RequestMapping("citasUsuario")
    public String muestraCitasUsuario(@RequestParam("clienteId") int Id,Model modelo){
        //Obtener los clientes desde el DAO
        this.idepi=Id;
        List<Cita> lasCitas=repoCitas.findAllByid_Id(Id);
        //Agregar clientes desde al modelo
        modelo.addAttribute("citas",lasCitas);
        return "lista-citas-usuario";
    }
    @PostMapping("insertarCliente")
    public String insertarCliente(@ModelAttribute("cliente") Cliente elCliente){
        repoPaciente.save(elCliente);
        return "redirect:/paciente/lista";
    }
    @PostMapping("insertarEpisodio")
    public String insertarEpisodio(@ModelAttribute("episodio") Episodio elEpisodio){
        Cliente clie=new Cliente();
        clie.setId(this.idepi);
        elEpisodio.setId(clie);
        repoEpisodio.save(elEpisodio);
        return "redirect:/paciente/episodios?clienteId="+this.idepi;
    }

    @PostMapping("insertarCitas")
    public String insertarCita(@ModelAttribute("cita") Cita laCita){
        Cliente clie=new Cliente();
        clie.setId(this.idepi);
        laCita.setId(clie);
        repoCitas.save(laCita);
        return "redirect:/paciente/citas?clienteId="+this.idepi;
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
        return "formularioEpisodios";
    }
    @RequestMapping("muestraFormularioCita")
    public String muestraFormularioCita(Model modelo){
        //Bind de datos
        Cita laCita=new Cita();
        modelo.addAttribute("cita",laCita);
        return "formularioCitas";
    }
    @RequestMapping("muestraFormularioAgregar")
    public String muestraFormularioAgregar(Model modelo){
        //Bind de datos
        Cliente elCliente=new Cliente();
        modelo.addAttribute("cliente",elCliente);
        return "formularioCliente";
    }
    @RequestMapping("muestraFormularioUsuario")
    public String muestraFormularioUsuario(Model modelo){
        //Bind de datos
        Usuario elUsuario=new Usuario();
        modelo.addAttribute("usuario",elUsuario);
        return "formularioUsuario";
    }
    @GetMapping("eliminar")
    public String eliminarCliente(@RequestParam("clienteId") int Id){
        //Eliminar cliente
        repoPaciente.deleteById(Id);
        //Reddirecionnar a lista clientes
        return "redirect:/paciente/lista";
    }
    @GetMapping("eliminarUsuario")
    public String eliminarUsuario(@RequestParam("usuarioId") int Id){
        //Eliminar cliente
        repoUsuario.deleteById(Id);
        //Reddirecionnar a lista clientes
        return "redirect:/paciente/lista";
    }


    @GetMapping("eliminarEpisodio")
    public String eliminarEpisodio(@RequestParam("episodioId") int Id){
        //Eliminar cliente
        repoEpisodio.deleteById(Id);
        //Reddirecionnar a lista clientes
        return "redirect:/paciente/episodios?clienteId="+this.idepi;
    }
    @GetMapping("eliminarCita")
    public String eliminarCita(@RequestParam("citaId") int Id){
        //Eliminar cliente
        repoCitas.deleteById(Id);
        //Reddirecionnar a lista clientes
        return "redirect:/paciente/citas?clienteId="+this.idepi;
    }

    @GetMapping("muestraFormularioActualizar")
    public String muestraFormularioActualizar(@RequestParam("clienteId") int Id,Model modelo){
        //Obtener cliente
        Cliente elCliente=repoPaciente.getById(Id);
        //Obtener el cliente como atributo del modelo
        modelo.addAttribute("cliente",elCliente);
        //enviar al formulario
        return "formularioCliente";
    }
    @GetMapping("muestraEpisodioActualizar")
    public String muestraEpisodioActualizar(@RequestParam("episodioId") int Id,Model modelo){
        //Obtener cliente
        Episodio elEpisodio=repoEpisodio.getById(Id);
        //Obtener el cliente como atributo del modelo
        modelo.addAttribute("episodio",elEpisodio);
        //enviar al formulario
        return "formularioEpisodios";
    }
    @GetMapping("muestraCitaActualizar")
    public String muestraCitaActualizar(@RequestParam("citaId") int Id,Model modelo){
        //Obtener cliente
        Cita laCita=repoCitas.getById(Id);
        //Obtener el cliente como atributo del modelo
        modelo.addAttribute("cita",laCita);
        //enviar al formulario
        return "formularioCitas";
    }
    @GetMapping("muestraUsuarioActualizar")
    public String muestraUsuarioActualizar(@RequestParam("usuarioId") int Id,Model modelo){
        //Obtener cliente
        Usuario elUsuario=repoUsuario.getById(Id);
        //Obtener el cliente como atributo del modelo
        modelo.addAttribute("usuario",elUsuario);
        //enviar al formulario
        return "formularioUsuario";
    }

    private int idepi;

    @Autowired
    private IClienteRepo repoPaciente;

    @Autowired
    private IEpisodioRepo repoEpisodio;

    @Autowired
    private ICitaRepo repoCitas;

    @Autowired
    private IUsuarioRepo repoUsuario;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private ClienteService servicePaciente;

    @Autowired
    private EpisodioService serviceEpisodio;

    @Autowired
    private UserValidator userValidator;
}