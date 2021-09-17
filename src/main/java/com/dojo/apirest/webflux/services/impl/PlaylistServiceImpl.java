package com.dojo.apirest.webflux.services.impl;

import com.dojo.apirest.webflux.document.Playlist;
import com.dojo.apirest.webflux.repository.PlaylistRepository;
import com.dojo.apirest.webflux.services.PlaylistService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository){
        this.playlistRepository = playlistRepository;
    }

    @Override
    public Flux<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Mono<Playlist> findById(String id) {
        return playlistRepository.findById(id);
    }

    @Override
    public Mono<Playlist> save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }
}
