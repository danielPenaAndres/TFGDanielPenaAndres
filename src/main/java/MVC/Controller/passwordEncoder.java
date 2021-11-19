package MVC.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class passwordEncoder {
    @Bean
    public BCryptPasswordEncoder passwordEncode(){
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        return bCrypt;
    }
}
