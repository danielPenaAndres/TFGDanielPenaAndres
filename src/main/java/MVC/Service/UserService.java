package MVC.Service;

import MVC.Entity.Usuario;
import MVC.repo.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario us=repo.findByDNI(username);
        if(us.getTipo().equals("A")){
        List<GrantedAuthority> roles=new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ADMIN"));
        UserDetails userDet=new User(us.getDNI(),us.getClave(),roles);
        return userDet;}
        else{
            List<GrantedAuthority> roles=new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("USER"));
            UserDetails userDet=new User(us.getDNI(),us.getClave(),roles);
            return userDet;
        }

    }

    @Autowired
    private IUsuarioRepo repo;
}
