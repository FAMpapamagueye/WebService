/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package fall.lampdevs.rest_meteo.services;

import fall.lampdevs.rest_meteo.entities.Localite;
import fall.lampdevs.rest_meteo.services.facades.LocaliteFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
@WebService(serviceName = "LocatiteResource")
@Path("localite")
public class LocatiteResource {

    /**
     * This is a sample web service operation
     */
      @EJB
    private LocaliteFacade localitefacades;
 @GET
  @Operation(summary = "Renvoie la liste des Localite",
            description = "cette methode return  la liste des Localite de format JSON ou XML")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
 public List<Localite>  getLocalite(){
     return localitefacades.findAll();
 }
 
   @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Operation(summary = "ajout d'une Localite",
            description = "permet d'ajouter une filiere",
            responses = {
                @ApiResponse(description = " return la Filiere ajouter",
                        content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = Localite.class))),
                @ApiResponse(responseCode = "501", description = "erreur interne"),
                @ApiResponse(responseCode = "200", description = "save ok")
            })
 public Localite addLocalite(@RequestBody(description = "localite a enregistrer") Localite localite,@PathParam("id") int id){
     Localite localiteDB=localitefacades.find(id);
     if(localiteDB!=null){
         localitefacades.remove(localite);
     }
      localite.setId(id);
      localitefacades.create(localite);
      
          return localite;
     
 }
   @DELETE()
    @Path("/{id}")
    @Operation(summary = "Renvoie la Localite Supprimer",
            description = "cette methode return  la Localite Supprimer au  format JSON ou XML")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public Localite Supp(@PathParam("id") int code) {
        Localite localiteDB = localitefacades.find(code);
        if ( localiteDB== null) {
            throw new WebApplicationException("Id Localite not Found", Response.Status.NOT_FOUND);
        }
        localitefacades.remove(localiteDB);
        return localiteDB;
    }
        @GET
    @Path("/{id}")
         @Operation(summary = "Renvoie une Localite",
            description = "cette methode return une Localite de format JSON ou XML")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public Localite findByCode(@PathParam("id") int id) {
        return localitefacades.find(id);
    }

}
