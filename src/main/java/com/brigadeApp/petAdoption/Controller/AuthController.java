package com.brigadeApp.petAdoption.Controller;

import java.util.List;
import java.util.ArrayList;
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
	public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginDto){
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                loginDto.getUsername(), loginDto.getPassword()));
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        
	        String [] ctxArray = SecurityContextHolder.getContext().toString().split(" ");
	        String Role = ctxArray[10].substring(0, ctxArray[10].length()-3);
	        Role = Role.replace("[", "");
	        Role = Role.split("=")[1];
	        System.out.println(SecurityContextHolder.getContext().toString());
	        /*
	        List<String> ctx = new ArrayList<>(); 
	        ctx.add(ctxArray[3].substring(1, ctxArray[3].length()-1)); 
	        ctx.add(ctxArray[5].substring(0, ctxArray[5].length()-1));
	        ctx.add(ctxArray[6].substring(0, ctxArray[6].length()-1));
	        ctx.add(ctxArray[7].substring(0, ctxArray[7].length()-1));
	        ctx.add(ctxArray[8].substring(0, ctxArray[8].length()-1));
	        ctx.add(ctxArray[12].substring(0, ctxArray[12].length()-1));
	        ctx.add(temp);
	         //System.out.println(ctx);
	         */
	        String uname = loginDto.getUsername();
	        return new ResponseEntity<>(repository.findByUsername(uname), HttpStatus.OK);
	        
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