package tacoz.web.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
//import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import tacoz.Ingredient;

@Configuration
public class SpringDataRestConfiguration implements RepositoryRestConfigurer {

    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Ingredient.class);
    }

}
