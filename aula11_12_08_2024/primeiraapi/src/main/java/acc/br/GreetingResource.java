package acc.br;

import java.util.List;
import java.util.logging.Logger;

import io.quarkus.logging.Log;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import acc.br.model.Fruta;
import jakarta.ws.rs.core.Response;

@Path("/frutas")
public class GreetingResource {

    private static final Logger LOG = Logger.getLogger(GreetingResource.class.getName());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruta> list() {
        return Fruta.listAll();
    }

    @POST
    @Transactional
    public Response novaFruta(Fruta fruta) {
        LOG.info("Criando Fruta: " + fruta.toString());
        fruta.persist();
        Log.info("Fruta criada com sucesso!");
        return Response.status(Response.Status.CREATED).entity(fruta).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteFruta(@PathParam("id") long id) {
        Fruta fruta = Fruta.findById(id);
        LOG.info("Deletando Fruta: " + fruta.toString());
        fruta.delete();
        Log.info("Fruta " + fruta + " deletado com sucesso.");
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
