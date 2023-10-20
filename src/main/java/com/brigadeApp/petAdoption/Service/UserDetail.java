package com.brigadeApp.petAdoption.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brigadeApp.petAdoption.Entity.User;
import com.brigadeApp.petAdoption.repository.UserRepository;
import java.util.*;
@Service
public class UserDetail implements UserDetailsService {
@Autowired    
UserRepository userRepo;
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Optional<User> userOptional = userRepo.findByUsername(username);
	User user = userOptional.get();
	if(user==null){
		throw new UsernameNotFoundException("User not exists by Username");
	}
	
	Set<GrantedAuthority> authorities = new HashSet<>();
	authorities.add(new SimpleGrantedAuthority(user.getRole().getName()) );//.stream()
	                //.map((role) -> new SimpleGrantedAuthority(role.getName()))
	                //.collect(Collectors.toSet());
	 return new org.springframework.security.core.userdetails.User(username,user.getPassword(),authorities);
	}
}