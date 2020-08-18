package io.javabrains.springsecurityjpa;

import io.javabrains.springsecurityjpa.models.MyUserDetails;

import io.javabrains.springsecurityjpa.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    
    //UserDetails is an inbuilt methods that UserDetailsService has. It will take the userDetails from the input given by the user.
    //loadUserByUsername is also method in UserDetailsService.
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	//checks if the user is present from using findByUserName method from UserRepository.
        Optional<User> user = userRepository.findByUserName(userName);
        
        //if the user is not found it throws an error
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        
        //Otherwise it returns the userNmae to MyUserDetails class.
        return user.map(MyUserDetails::new).get();
    }
}
