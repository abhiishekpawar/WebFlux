package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {

    public Flux<String> listOfNames() {
        return Flux.fromIterable(List.of("Name1", "Name2", "Name3"));
    }

    public Mono<String> name(){
        return Mono.just("Name1");
    }

    public static void main(String[] args) {
        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();
        //1st way
        fluxAndMonoGeneratorService.listOfNames()
                .subscribe(name -> {
                    System.out.println("name is "+ name);
                });

        //2nd way
        fluxAndMonoGeneratorService.listOfNames()
                .subscribe(System.out::println);

        fluxAndMonoGeneratorService.name()
                .subscribe(name -> {
                    System.out.println("only name is "+name);
                });
    }

}
