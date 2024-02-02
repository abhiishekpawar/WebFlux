package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {

    public Flux<String> namesFlux() {
        return Flux.fromIterable(List.of("Name1", "Name2", "Name3"));
    }

    public Mono<String> namesMono(){
        return Mono.just("Name1");
    }

    public Flux<String> namesFluxMap(){
        return Flux.just("alex","james","mock")
                .map(String::toUpperCase);
    }

    public Flux<String> namesFluxFilterMap(){
        return Flux.just("alex","james","mock")
                .filter(n -> n.length() > 4)
                .map(String::toUpperCase);
    }

    public static void main(String[] args) {
        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();
//        //1st way
//        fluxAndMonoGeneratorService.namesFlux()
//                .subscribe(name -> {
//                    System.out.println("name is "+ name);
//                });

        //2nd way
//        fluxAndMonoGeneratorService.namesFlux()
//                .subscribe(System.out::println);
//
//        fluxAndMonoGeneratorService.namesMono()
//                .subscribe(name -> {
//                    System.out.println("only name is "+name);
//                });

//        fluxAndMonoGeneratorService.namesFluxMap()
//                .subscribe(System.out::println);

        fluxAndMonoGeneratorService.namesFluxFilterMap()
                .subscribe(System.out::println);
    }

}
