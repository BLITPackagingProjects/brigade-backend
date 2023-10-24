package com.brigadeApp.petAdoption.security;

//import java.beans.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {    
@Bean
public static PasswordEncoder passwordEncoder(){
	return new BCryptPasswordEncoder();
}
@Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
return configuration.getAuthenticationManager();
}
@Bean
SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	
	http.authorizeHttpRequests(
			configurer -> configurer
			.requestMatchers(HttpMethod.GET, "/login/**").permitAll()
			.requestMatchers(HttpMethod.POST, "/user").permitAll()
			.requestMatchers(HttpMethod.GET,"/pet/application").hasRole("EMPLOYEE")
			.requestMatchers(HttpMethod.POST,"/pet/application").hasRole("USER")
					.requestMatchers(HttpMethod.GET,"/home/**").permitAll()
					.requestMatchers(HttpMethod.GET, "pet/**").permitAll()
					.requestMatchers(HttpMethod.GET, "api/v1/pet/**").permitAll()
					.requestMatchers(HttpMethod.POST, "/application/**").permitAll()
					.requestMatchers(HttpMethod.GET, "/application/**").permitAll()
					.requestMatchers(HttpMethod.PUT, "/application/**").permitAll()

					.requestMatchers(HttpMethod.POST, "api/v1/pet/**").permitAll()

			.anyRequest().authenticated()
			); 
	
	http.httpBasic(Customizer.withDefaults());
	http.csrf(csrf -> csrf.disable());
	//http.cors(cors -> cors.disable());    // added
	return http.build();
	
//			http.csrf(csrf -> csrf.disable())
//			.authorizeRequests().antMatchers("/api/**").permitAll()
//			.anyRequest().authenticated();
//			 return http.build();
       }


/*
@Bean
public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
           			   
            registry.addMapping("/**").allowedMethods("*").allowedOriginPatterns("http://localhost:5173/**");
        }
    };
}
*/
/*
@Bean
CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
    configuration.setAllowedMethods(Arrays.asList("*"));
    configuration.setAllowedHeaders(Arrays.asList("*"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
}
*/
}