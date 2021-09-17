package com.dojo.apirest.webflux.controller;

import com.dojo.apirest.webflux.document.Playlist;
import com.dojo.apirest.webflux.services.PlaylistService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService){
        this.playlistService = playlistService;
    }
    @GetMapping("/playlist")
    public Flux<Playlist> getPlaylist(){
        return playlistService.findAll();
    }

    @GetMapping("/playlist/{id}")
    public Mono<Playlist> getPlaylistById(@PathVariable String id){
        return playlistService.findById(id);
    }

    @PostMapping("/playlist")
    public Mono<Playlist>savePlaylist(@RequestBody Playlist playlist){
        return playlistService.save(playlist);
    }

    @GetMapping(value = "playlist/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Playlist>>getPlaylistPerEvents(){
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Playlist> events = playlistService.findAll();
        return Flux.zip(interval, events);
    }

}
