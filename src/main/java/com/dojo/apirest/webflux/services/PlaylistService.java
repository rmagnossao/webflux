package com.dojo.apirest.webflux.services;

import com.dojo.apirest.webflux.document.Playlist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaylistService {

    Flux<Playlist> findAll();
    Mono<Playlist> findById(String id);
    Mono<Playlist> save (Playlist playlist);

}
