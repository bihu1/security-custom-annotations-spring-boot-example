package pl.bihuniak.piotr.example.user;

import java.util.Objects;
import java.util.Set;

public class ExampleUser {
	public final Set<Role> roles;
	public final Set<String> availableResources;

	public ExampleUser(Set<Role> roles, Set<String> availableResources) {
		this.roles = roles;
		this.availableResources = availableResources;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ExampleUser that = (ExampleUser) o;
		return Objects.equals(roles, that.roles) && Objects.equals(availableResources, that.availableResources);
	}

	@Override
	public int hashCode() {
		return Objects.hash(roles, availableResources);
	}

	@Override
	public String toString() {
		return "ExampleUser{" +
			"roles=" + roles +
			", availableResources=" + availableResources +
			'}';
	}
}
