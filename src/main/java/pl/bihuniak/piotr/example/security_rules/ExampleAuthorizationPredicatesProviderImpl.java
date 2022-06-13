package pl.bihuniak.piotr.example.security_rules;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import pl.bihuniak.piotr.autoconfigure.api.AuthorizationRuleProvider;
import pl.bihuniak.piotr.autoconfigure.api.MainRule;
import pl.bihuniak.piotr.autoconfigure.api.Rule;
import pl.bihuniak.piotr.example.user.ExampleUser;
import pl.bihuniak.piotr.example.user.Role;
import pl.bihuniak.piotr.example.user.UserProvider;

import java.util.Collection;
import java.util.Set;

@Component
class ExampleAuthorizationPredicatesProviderImpl implements AuthorizationRuleProvider<ExampleAnn> {

	@Override
	public MainRule<ExampleAnn> mainRule() {
		return new MainRule<>(
			(Authentication auth, ExampleAnn ann) ->
				((UserProvider) auth.getPrincipal()).getUser().roles.contains(ann.role())
		);
	}

	@Override
	public Collection<Rule<ExampleAnn, ?>> preRulesForSpecificArgumentsTypes() {
		return Set.of(
			new Rule<>(String.class,
					(Authentication auth, ExampleAnn ann, String id) -> {
						ExampleUser current = ((UserProvider) auth.getPrincipal()).getUser();
						return current.roles.contains(ann.role()) && current.availableResources.contains(id);
					}
				)
			);
	}
}
