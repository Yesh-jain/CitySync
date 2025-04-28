package com.IOE.cs.city_sync.Security.Service;

import com.IOE.cs.city_sync.Entities.CSUser;
import com.IOE.cs.city_sync.Repos.CSUserRepo;
import com.IOE.cs.city_sync.Security.User.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CSUserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CSUser user = userRepo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Username not Found");
        }
        return new CustomUserDetails(user);
    }
}
