package pl.bihuniak.piotr.example;

import org.springframework.stereotype.Service;
import pl.bihuniak.piotr.example.security_rules.ExampleAnn;
import pl.bihuniak.piotr.example.user.Role;

@Service
class ExampleService {

	@ExampleAnn(role = Role.ADMIN)
	public String adminLogIn(){
		return "You are logged in as admin";
	}

	@ExampleAnn(role = Role.USER)
	public String userLogIn(){
		return "You are logged in as user";
	}

	@ExampleAnn(role = Role.USER, ids = "resourceId")
	public String userResourceAccess(String resourceId) {
		return "You have access to this resource";
	}

	@ExampleAnn(role = Role.ADMIN, ids = "resourceId")
	public String adminResourceAccess(String resourceId) {
		return "You have access to this resource";
	}
}
