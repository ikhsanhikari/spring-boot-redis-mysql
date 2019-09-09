package id.hikari.hikari.test.config;


import id.hikari.hikari.test.dao.AuthUserDAO;
import id.hikari.hikari.test.data.model.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthUserDAO authUserDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AuthUser authUser = authUserDAO.findByUsername(s);
        if(authUser == null){
            throw  new UsernameNotFoundException("User -404");
        }
        return new AuthUserPrincipal(authUser);
    }
}
