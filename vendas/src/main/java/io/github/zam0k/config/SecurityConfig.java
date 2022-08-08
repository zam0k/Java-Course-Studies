package io.github.zam0k.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		// Aqui define a parte de autenticação
		auth.inMemoryAuthentication()
				.passwordEncoder(passwordEncoder()).withUser("Fulano")
				.password(passwordEncoder().encode("123"))
				.roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Aqui define a parte de autorização
		super.configure(http);
	}

}
