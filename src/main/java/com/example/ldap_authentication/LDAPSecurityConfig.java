package com.example.ldap_authentication;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;

@Configuration
public class LDAPSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login**").anonymous().antMatchers("/resources/**").permitAll()
				.antMatchers("/assets/**").permitAll().antMatchers("/").authenticated().antMatchers("/home")
				.authenticated().and().formLogin().loginPage("/login").permitAll().and().logout().permitAll().and()
				.csrf().disable();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.ldapAuthentication().userDnPatterns("uid={0},ou=people").contextSource()
				.url("ldap://localhost:10389/dc=example,dc=com").and().passwordCompare()
				.passwordEncoder(new LdapShaPasswordEncoder()).passwordAttribute("userPassword");
	}
}