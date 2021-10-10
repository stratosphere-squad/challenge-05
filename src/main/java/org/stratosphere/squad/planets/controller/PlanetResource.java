package org.stratosphere.squad.planets.controller;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.stratosphere.squad.planets.entity.Planet;
import org.stratosphere.squad.planets.service.PlanetService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.Optional;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Slf4j
@Path("/api/v1/planets")
@Produces(APPLICATION_JSON)
public class PlanetResource {

    @Inject
    PlanetService planetService;

    @Operation(summary = "Returns all planets", description = "Get all planets")
    @APIResponse(responseCode = "200",
            content = @Content(mediaType = APPLICATION_JSON,
                    schema = @Schema(implementation = Planet.class, type = SchemaType.ARRAY)))
    @GET
    @Path("/")
    public Response getAllPlanets() {
        List<Planet> planets = planetService.findAllBooks();
        log.debug("Total number of planets {}", planets);
        return Response.ok(planets).build();
    }

    @Operation(summary = "Returns a planet by the name", description = "Get single planet")
    @APIResponse(responseCode = "200",
            content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Planet.class)))
    @GET
    @Path("/name/{name}")
    public Response getPlanetByName(@Parameter(description = "Planet name", required = true) @PathParam("name") String name) {
        Optional<Planet> planet = planetService.findPlanetByName(name);
        if (planet.isPresent()) {
            log.debug("Found planet {}", planet);
            return Response.ok(planet).build();
        } else {
            log.debug("Planet not found: {}", name);
            return Response.noContent().build();
        }
    }

    @Operation(summary = "Create a new Planet", description = "Create planet")
    @APIResponse(responseCode = "201",
            content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Planet.class)))
    @POST
    public Response createPlanet(@Valid Planet planet, @Context UriInfo uriInfo) {
        planet = planetService.createPlanet(planet);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(planet.getName());
        log.debug("New planet created {}", builder.build().toString());
        return Response.created(builder.build()).build();
    }

    @Operation(summary = "Update an existing planet description", description = "Update Planet")
    @APIResponse(responseCode = "200", description = "The updated Planet",
            content = @Content(mediaType = APPLICATION_JSON,
                    schema = @Schema(implementation = Planet.class)))
    @PUT
    public Response updatePlanet(@Valid Planet planet) {
        planet = planetService.updatePlanet(planet);
        log.debug("Planet updated");
        return Response.ok(planet).build();
    }

    @Operation(summary = "Deletes an exiting Planet", description = "Delete Planet")
    @APIResponse(responseCode = "204", description = "No content", content = @Content(schema = @Schema(implementation = Void.class)))
    @DELETE
    @Path("/{name}")
    public Response deletePlanet(@PathParam("name") String name) {
        planetService.deletePlanet(name);
        return Response.noContent().build();
    }
}
