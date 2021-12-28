/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package fall.lampdevs.rest_meteo.services;

import fall.lampdevs.rest_meteo.entities.Meteo;
import fall.lampdevs.rest_meteo.services.facades.LocaliteFacade;
import fall.lampdevs.rest_meteo.services.facades.MeteoFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author CLASS LAMP
 */
@WebService(serviceName = "MeteoResource")
@Path("meteo")
public class MeteoResource {

     @EJB
    private MeteoFacade meteoFacade;
     @EJB
     private LocaliteFacade localitefacades;
    @GET
    
    @Operation(summary = "Renvoie la liste des meteo",
            description = "cette methode return  la liste des meteo de format JSON ou XML")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Meteo> getMeteo() {
        return meteoFacade.findAll();

    }

    @PUT
    @Path("/{date}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Operation(summary = "ajout d'une  donnee meteo",
            description = "permet d'ajouter une donnes meteo",
            responses = {
                @ApiResponse(description = " return le meteo ajouter",
                        content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = Meteo.class))),
                @ApiResponse(responseCode = "501", description = "erreur interne"),
                @ApiResponse(responseCode = "200", description = "save ok")
            })

    public Meteo addMeteo(@RequestBody(description = "donnees meteo  a enregistrer") Meteo meteo, @PathParam("date") int date) {
        System.out.println("ajout meteo" + meteo);
        System.out.println("date" + date);
        Meteo meteoDB = meteoFacade.find(date);
        if (meteoDB != null) {
            meteoFacade.remove(meteo);
        }
        

        meteo.setJourDate(date);

        meteoFacade.create(meteo);

        return meteo;
    }

    @DELETE()
    @Path("/{date}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public Meteo Supp(@PathParam("date") int date) {
        Meteo meteoDB = meteoFacade.find(date);
        if (meteoDB == null) {
            throw new WebApplicationException("date jour meteo not Found", Response.Status.NOT_FOUND);
        }
        meteoFacade.remove(meteoDB);
        return meteoDB;
    }
 
    @GET
    @Path("/{date}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public Meteo findByCode(@PathParam("date") int date) {
        return meteoFacade.find(date);
    }
     @GET
    @Path("/{idville}/{date}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public Meteo findByVille(@PathParam("date") int date,@PathParam("idville") int idville) {
        Meteo test= meteoFacade.find(date);
        if(test.getLocalite()!=localitefacades.find(idville)){
            return null;
        }
        return test;
    }
}
