package org.stratosphere.squad.planets.service;

import org.stratosphere.squad.planets.entity.Planet;
import org.stratosphere.squad.planets.repository.PlanetRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class PlanetService {

    @Inject
    private PlanetRepository planetRepository;

    public List<Planet> findAllBooks() {
        return planetRepository.listAll();
    }

    public Optional<Planet> findPlanetByName(String name) {
        return planetRepository.findByName(name);
    }

    public Planet createPlanet(@Valid Planet planet) {
        planetRepository.create(planet);
        return planet;
    }

    @Transactional
    public Planet updatePlanet(@Valid Planet planet) {
        return planetRepository.update(planet);
    }

    public void deletePlanet(String name) {
        planetRepository.deleteByName(name);
    }
}
