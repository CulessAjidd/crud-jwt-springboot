package altera.pelatihan.tugasspringboot.service.implemntasi;

import altera.pelatihan.tugasspringboot.model.UserModel;
import altera.pelatihan.tugasspringboot.repository.UserRepository;
import altera.pelatihan.tugasspringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService, UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    @Override
    public String save(UserModel userModel) {
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        return userRepository.save(userModel).getId();
    }

    @Override
    public UserModel findOne(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteOne(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByUsername(username);
        Collection<SimpleGrantedAuthority> autorities = new ArrayList<>();
        autorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), autorities);
    }
}
