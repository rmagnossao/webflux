package com.dojo.apirest.webflux.controller.funcional;

import com.dojo.apirest.webflux.document.Playlist;
import com.dojo.apirest.webflux.services.PlaylistService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

//@Component
public class PlaylistHandler {

    private final PlaylistService playlistService;

    public PlaylistHandler(PlaylistService playlistService){
        this.playlistService = playlistService;
    }

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playlistService.findAll(), Playlist.class);
    }

    public Mono<ServerResponse>findById(ServerRequest request){
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playlistService.findById(request.pathVariable("id")), Playlist.class);
    }

    public Mono<ServerResponse>save(ServerRequest request){
        Mono<Playlist> playlist = request.bodyToMono(Playlist.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(playlist.flatMap(playlistService::save), Playlist.class));
    }

}
