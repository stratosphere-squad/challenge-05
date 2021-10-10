package org.stratosphere.squad.planets.repository;

import org.stratosphere.squad.planets.entity.Planet;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class PlanetRepository {

    private List<Planet> planets = new ArrayList<>(List.of(
            Planet.builder().name("Earth").description("Our precious home planet").build(),
            Planet.builder().name("Mars").description("Elon musk's must have").build(),
            Planet.builder().name("Pluto").description("As Neil deGrasse Tyson would put it: It's not a planet").build()));

    public Optional<Planet> findByName(String name) {
        return planets.stream()
                .filter(planet -> planet.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public List<Planet> listAll() {
        return planets;
    }

    public void create(Planet planet) {
        Optional<Planet> existingPlanet = this.findByName(planet.getName());
        if (existingPlanet.isPresent()) {
            throw new RuntimeException("A planet already exists with the same name");
        }
        planets.add(planet);
    }

    public Planet update(Planet planet) {
        Optional<Planet> existingPlanet = this.findByName(planet.getName());
        if (existingPlanet.isPresent()) {
            Planet planetToUpdate = existingPlanet.get();
            planetToUpdate.setDescription(planet.getDescription());
            return planetToUpdate;
        } else {
            throw new RuntimeException("No planet found with name");
        }
    }

    public void deleteByName(String name) {
        planets.removeIf(planet -> planet.getName().equalsIgnoreCase(name));
    }
}
