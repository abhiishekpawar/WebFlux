package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoGeneratorServiceTest {

    @Mock
    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();
    @Test
    void namesFlux(){
        Flux<String> stringFlux = fluxAndMonoGeneratorService.namesFlux();

        StepVerifier.create(stringFlux)
                .expectNext("Name1")
                .expectNext("Name2")
                .expectNext("Name3")
                .verifyComplete();

    }
    @Test
    void namesMono(){
        Mono<String> stringMono = fluxAndMonoGeneratorService.namesMono();

        StepVerifier.create(stringMono)
                .expectNextCount(1)
                .verifyComplete();
    }
    @Test
    void namesFluxMap(){
        Flux<String> stringFlux = fluxAndMonoGeneratorService.namesFluxMap();

        StepVerifier.create(stringFlux)
                .expectNext("ALEX")
                .expectNextCount(3)
                .expectComplete();
    }
    @Test
    void namesFluxFilterMap(){
        Flux<String> stringFlux = fluxAndMonoGeneratorService.namesFluxFilterMap();

        StepVerifier.create(stringFlux)
                .expectNextCount(1)
                .expectComplete();

    }


}