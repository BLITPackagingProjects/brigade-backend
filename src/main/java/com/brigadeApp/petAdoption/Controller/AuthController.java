package com.brigadeApp.petAdoption.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brigadeApp.petAdoption.Entity.User_Role;
import com.brigadeApp.petAdoption.Entity.User;
import com.brigadeApp.petAdoption.dto.LoginDto;
import com.brigadeApp.petAdoption.repository.RoleRepository;
import com.brigadeApp.petAdoption.repository.UserRepository;

@CrossOrigin(origins = {"http://localhost:5173"})
@RestController
//@RequestMapping("/api")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository repository;

	@Autowired
	private RoleRepository roleRepo;
	 
	@PostMapping("/login")
	public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                loginDto.getUsername(), loginDto.getPassword()));
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        return new ResponseEntity<>("User login successfully!.", HttpStatus.OK);
	        /*
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("X-Get-Header", "ExampleHeader");
	        return ResponseEntity.ok().headers(headers).body("User login successfully");
	    */
	    }
	
	@GetMapping("/home")
	public String home() {	

		return "Say my name";
	}
	
	@GetMapping("/pet")
	public String getAllPet() {
		return "All pet here";
		}
	
	@PostMapping("/register")
	public void empRegister(@RequestBody User emp) {
		
		final int logRounds = 12;
		Optional<User_Role> op = roleRepo.findById(1);
		emp.setPassword(BCrypt.hashpw(emp.getPassword(), BCrypt.gensalt(logRounds)));
		
		emp.setRole(op.get());
		repository.save(emp);
		
	}
}