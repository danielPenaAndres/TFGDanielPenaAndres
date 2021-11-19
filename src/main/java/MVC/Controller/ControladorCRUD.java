package MVC.Controller;


import MVC.Entity.Cita;
import MVC.Entity.Cliente;
import MVC.Entity.Episodio;
import MVC.Entity.Usuario;
import MVC.repo.ICitaRepo;
import MVC.repo.IClienteRepo;
import MVC.repo.IEpisodioRepo;
import MVC.repo.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/paciente")
public class ControladorCRUD {

    @RequestMapping("/lista")
    public String muestraFormulario(Model modelo){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        boolean hasUserRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ADMIN"));

        if (hasUserRole){
            System.out.println("/////////////////USUARIO ADMIN//////////////////////////");
        //Obtener los clientes desde el DAO
        List<Cliente> losClientes=repoPaciente.findAll();
        //Agregar clientes desde al modelo
        modelo.addAttribute("clientes",losClientes);
        return "lista-clientes";}
        else{
            System.out.println("/////////////////USUARIO NORMAL//////////////////////////");
            //Obtener los clientes desde el DAO
            List<Cliente> losClientes=repoPaciente.findAllByDNI(username);
            //Agregar clientes desde al modelo
            modelo.addAttribute("clientes",losClientes);
            return "lista-clientes-usuario";}

        }

    @RequestMapping("/usuario")
    public String creaUsuario(){
        Usuario us=new Usuario();
        us.setClave(encoder.encode("123"));
        us.setApellidos("pena");
        us.setDNI("01940400M");
        us.setNombre("Daniel");
        us.setTipo("A");
        repoUsuario.save(us);
        return "Se ha creado el usuario con DNI " + us.getDNI();
    }
    @RequestMapping("/episodios")
    public String muestraEpisodios(@RequestParam("clienteId") int Id,Model modelo){
        //Obtener los clientes desde el DAO
        this.idepi=Id;
        List<Episodio> losEpisodios=repoEpisodio.findAllByid_Id(Id);
        //Agregar clientes desde al modelo
        modelo.addAttribute("episodios",losEpisodios);
        return "lista-episodios";
    }
    @RequestMapping("/citas")
    public String muestraCitas(@RequestParam("clienteId") int Id,Model modelo){
        //Obtener los clientes desde el DAO
        this.idepi=Id;
        List<Cita> lasCitas=repoCitas.findAllByid_Id(Id);
        //Agregar clientes desde al modelo
        modelo.addAttribute("citas",lasCitas);
        return "lista-citas";
    }
    @RequestMapping("/episodiosUsuario")
    public String muestraEpisodiosUsuario(@RequestParam("clienteId") int Id,Model modelo){
        //Obtener los clientes desde el DAO
        this.idepi=Id;
        List<Episodio> losEpisodios=repoEpisodio.findAllByid_Id(Id);
        //Agregar clientes desde al modelo
        modelo.addAttribute("episodios",losEpisodios);
        return "lista-episodios-usuario";
    }
    @RequestMapping("/citasUsuario")
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

    @RequestMapping("/muestraFormularioEpisodio")
    public String muestraFormularioEpisodio(Model modelo){
        //Bind de datos
        Episodio elEpisodio=new Episodio();
        modelo.addAttribute("episodio",elEpisodio);
        return "formularioEpisodios";
    }
    @RequestMapping("/muestraFormularioCita")
    public String muestraFormularioCita(Model modelo){
        //Bind de datos
        Cita laCita=new Cita();
        modelo.addAttribute("cita",laCita);
        return "formularioCitas";
    }
    @RequestMapping("/muestraFormularioAgregar")
    public String muestraFormularioAgregar(Model modelo){
        //Bind de datos
        Cliente elCliente=new Cliente();
        modelo.addAttribute("cliente",elCliente);
        return "formularioCliente";
    }


    @GetMapping("eliminar")
    public String eliminarCliente(@RequestParam("clienteId") int Id){
        //Eliminar cliente
        repoPaciente.deleteById(Id);
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

}