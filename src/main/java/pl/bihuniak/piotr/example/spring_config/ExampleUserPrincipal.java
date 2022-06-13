package pl.bihuniak.piotr.example.spring_config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import pl.bihuniak.piotr.example.user.ExampleUser;
import pl.bihuniak.piotr.example.user.UserProvider;

import java.util.Collection;

class ExampleUserPrincipal extends User implements UserProvider {

	private final ExampleUser appUser;

	public ExampleUserPrincipal(String username, String password, Collection<? extends GrantedAuthority> authorities,
	                            ExampleUser appUser) {
		super(username, password, authorities);
		this.appUser = appUser;
	}

	@Override
	public ExampleUser getUser() {
		return appUser;
	}
}
