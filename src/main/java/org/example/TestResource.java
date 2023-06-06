package org.example;

import jakarta.inject.Inject;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/test")
public class TestResource {
    @RestClient SelfClient selfClient;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("callMeFromSwagger")
    public String callMeFromSwagger() {
        return selfClient.callMeWithRestClient("");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("callMeWithRestClient")
    public String callMeWithRestClient(@NotBlank @RestQuery String queryParam) {
        return selfClient.callMeWithRestClient(queryParam);
    }
}

@Path("/test")
@RegisterRestClient(baseUri = "http://localhost:8080")
interface SelfClient {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("callMeWithRestClient")
    String callMeWithRestClient(@RestQuery String queryParam);
}
