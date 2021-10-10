package org.stratosphere.squad.planets;

import com.google.common.net.HttpHeaders;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.stratosphere.squad.planets.entity.Planet;

import javax.ws.rs.core.MediaType;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlanetResourceTest {

    private final String planetName = "Earth";

    @Test
    @Order(1)
    public void shouldGetAllInitialPlanets() {
        List<Planet> planets = given()
                .when().get("/api/v1/planets")
                .then()
                .statusCode(200)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .extract().body().as(getBooksTypeRef());

        assertEquals(3, planets.size());
    }

    @Test
    @Order(2)
    public void shouldGetNoPlanetByName() {
        given()
                .when().get("/api/v1/planets/name/not-a-planet-name")
                .then()
                .statusCode(204);
    }

    @Test
    @Order(3)
    public void shouldAddPlanet() {
        Planet planet = Planet.builder().name("New Planet").description("desc").build();
        given()
                .body(planet)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .when().post("/api/v1/planets")
                .then()
                .statusCode(201);
    }

    @Test
    @Order(4)
    public void shouldGetAllPlanets() {
        List<Planet> planets = given()
                .when().get("/api/v1/planets")
                .then()
                .statusCode(200)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .extract().body().as(getBooksTypeRef());

        assertEquals(4, planets.size());
    }

    @Test
    @Order(5)
    public void shouldGetPlanetByName() {
        Planet planet = given()
                .when().get("/api/v1/planets/name/"+planetName)
                .then()
                .statusCode(200)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .extract().body().as(getBookTypeRef());
        assertEquals(planetName, planet.getName());
    }

    @Test
    @Order(6)
    public void shouldUpdatePlanet() {
        Planet planet = Planet.builder().name(planetName).description("new description").build();
        Planet retrievedPlanet = given()
                .body(planet)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .when().put("/api/v1/planets")
                .then()
                .statusCode(200)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .extract().body().as(getBookTypeRef());
        assertEquals(planet.getName(), retrievedPlanet.getName());
        assertEquals(planet.getDescription(), planet.getDescription());
    }



    TypeRef<List<Planet>> getBooksTypeRef() {
        return new TypeRef<List<Planet>>() {};
    }

    TypeRef<Planet> getBookTypeRef() {
        return new TypeRef<Planet>() {};
    }

}