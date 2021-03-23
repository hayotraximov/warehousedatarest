package uz.raximov.demo.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.raximov.demo.Entity.Client;

@Projection(name = "clientProjection", types = Client.class)
public interface ClientProjection {
    Integer getId();

    String getName();

    String getPhoneNumber();
}
