package MVC.Service;

import MVC.Entity.Usuario;

import MVC.repo.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
@Service
public class UserService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario us=repo.findByDNI(username);
        System.out.println("////////////////////////"+username+"////////////////////////");
        if(us.getTipo().equals("A")){
        List<GrantedAuthority> roles=new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ADMIN"));
        UserDetails userDet=new User(us.getDNI(),us.getClave(),roles);
        return userDet;}
        else if(us.getTipo().equals("M")){
            List<GrantedAuthority> roles=new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("MEDICO"));
            UserDetails userDet=new User(us.getDNI(),us.getClave(),roles);
            return userDet;
        }
        else {
            List<GrantedAuthority> roles=new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("USUARIO"));
            UserDetails userDet=new User(us.getDNI(),us.getClave(),roles);
            return userDet;
        }

    }

    @Autowired
    private IUsuarioRepo repo;
}*/

@Service("userDetailsService")
public class UserService implements UserDetailsService{
    @Autowired
    private IUsuarioRepo repo;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String DNI) {
        Usuario us = repo.findByDNI(DNI);
        if (us == null) throw new UsernameNotFoundException(DNI);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        /*
        for (Rol rol : us.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(rol.getName()));
        }*/
        if (us.getTipo().equalsIgnoreCase("ADMIN"))grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
        else if (us.getTipo().equalsIgnoreCase("MEDICO"))grantedAuthorities.add(new SimpleGrantedAuthority("MEDICO"));
        else if (us.getTipo().equalsIgnoreCase("USUARIO"))grantedAuthorities.add(new SimpleGrantedAuthority("USUARIO"));

        return new org.springframework.security.core.userdetails.User(us.getDNI(), us.getClave(), grantedAuthorities);
    }
}
