//http://blog.avenuecode.com/simple-jaxrs-application-with-cdi-javaee

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("valida")
public class ValidaEndPoint {

    @Inject
    private Verificador verificador;

    @GET
    @Path("CPF/{number}")
    @Produces(MediaType.TEXT_PLAIN)
    public String valid(@PathParam("number") int number){
        return verificador.verifica(number);
    }
}
