package ninckblokje.spring.admin.discovery;

import de.codecentric.boot.admin.server.cloud.discovery.DefaultServiceInstanceConverter;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CredentialsServiceInstanceConverter extends DefaultServiceInstanceConverter {

    private static final String propertyString = "spring.boot.admin.%s.metadata.%s";

    private Environment env;

    public CredentialsServiceInstanceConverter(Environment env) {
        this.env = env;
    }

    @Override
    protected Map<String, String> getMetadata(ServiceInstance instance) {
        Map<String, String> metadata = instance.getMetadata() != null ? instance.getMetadata() : new HashMap<>();

        metadata.put("user.name", getPropertyValue(instance.getServiceId(), "user.name"));
        metadata.put("user.password", getPropertyValue(instance.getServiceId(), "user.password"));

        return metadata;
    }

    String getPropertyValue(String serviceId, String metadataProperty) {
        String value = env.getProperty(String.format(propertyString, serviceId, metadataProperty));
        if (value == null) {
            value = env.getProperty(String.format(propertyString, "global", metadataProperty));
        }
        return value;
    }
}
