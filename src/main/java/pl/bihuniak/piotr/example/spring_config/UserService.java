package pl.bihuniak.piotr.example.spring_config;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.bihuniak.piotr.example.user.ExampleUser;
import pl.bihuniak.piotr.example.user.Role;

import java.util.Map;
import java.util.Set;

@Service
class UserService implements UserDetailsService {
	private final Map<String, ExampleUserPrincipal> usernameToPassword;

	UserService(BCryptPasswordEncoder encoder) {
		usernameToPassword = Map.of(
			"admin", new ExampleUserPrincipal(
				"admin", encoder.encode("admin"),
				Set.of(new SimpleGrantedAuthority("ROLE_USER")),
				new ExampleUser(Set.of(Role.ADMIN), Set.of("1234"))
			),
			"user", new ExampleUserPrincipal(
				"user", encoder.encode("user"),
				Set.of(new SimpleGrantedAuthority("ROLE_USER")),
				new ExampleUser(Set.of(Role.USER), Set.of("4321"))
			)
		);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ExampleUserPrincipal principal = usernameToPassword.get(username);
		if(principal == null)
			throw new UsernameNotFoundException("USER NOT FOUND");
		return principal;
	}
}
