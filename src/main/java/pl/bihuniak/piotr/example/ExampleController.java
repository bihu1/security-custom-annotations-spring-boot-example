package pl.bihuniak.piotr.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
class ExampleController {
	@Autowired
	private ExampleService exampleService;

	@GetMapping("/admin")
	public String adminLogIn(){
		return exampleService.adminLogIn();
	}

	@GetMapping("/user")
	public String userLogIn(){
		return exampleService.userLogIn();
	}

	@GetMapping("user/resource/{resourceId}")
	public String adminResourceAccess(@PathVariable String resourceId) {
		return exampleService.userResourceAccess(resourceId);
	}

	@GetMapping("admin/resource/{resourceId}")
	public String userResourceAccess(@PathVariable String resourceId) {
		return exampleService.adminResourceAccess(resourceId);
	}
}
