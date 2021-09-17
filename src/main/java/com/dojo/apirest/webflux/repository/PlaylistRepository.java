package com.dojo.apirest.webflux.repository;

import com.dojo.apirest.webflux.document.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {
}

