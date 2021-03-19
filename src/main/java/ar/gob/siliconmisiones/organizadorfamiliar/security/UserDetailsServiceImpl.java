package ar.gob.siliconmisiones.organizadorfamiliar.security;

import ar.gob.siliconmisiones.organizadorfamiliar.dao.UsuarioRepository;
import ar.gob.siliconmisiones.organizadorfamiliar.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username)  {

        Usuario user = usuarioRepository.findByUser(username);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }
          return new MyModelUserDetails(user);
    }


}
