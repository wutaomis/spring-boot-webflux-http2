package io.github.helloworlde.redis.controller;

import io.github.helloworlde.redis.model.Post;
import io.github.helloworlde.redis.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @author HelloWood
 * @date 2019-01-08 14:28
 */
@RestController
@RequestMapping("/posts")
public class PostController {
    private static final Logger LOG = LoggerFactory.getLogger(PostController.class);
    @Autowired
    private PostRepository postRepository;

    @GetMapping("")
    public Flux<Iterable<Post>> list() {
        LOG.info("Call list");
        return Flux.just(postRepository.findAll());
    }

    @GetMapping("/{id}")
    public Mono<Optional<Post>> get(@PathVariable("id") String id) {
        LOG.info("Call get " + id);
        try{
            if (id.equals("878e43a2-b4cb-4205-ae35-75a22e881586")) {
                Thread.sleep(1000);
            }
            else {
                Thread.sleep(10000);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Mono.just(postRepository.findById(id));
    }

}
