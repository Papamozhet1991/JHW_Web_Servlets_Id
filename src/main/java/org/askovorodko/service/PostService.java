package org.askovorodko.service;

import lombok.AllArgsConstructor;
import org.askovorodko.exception.NotFoundException;
import org.askovorodko.model.Post;
import org.askovorodko.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PostService {
    private final PostRepository repository;

    public List<Post> all() {
        return repository.all();
    }

    public Post getById(long id) {
        return repository.getById(id).orElseThrow(NotFoundException::new);
    }

    public Post save(Post post) {
        return repository.saveUpdate(post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }
}