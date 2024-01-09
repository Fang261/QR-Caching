package pt.iade.joaotomas.qrcaching.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.joaotomas.qrcaching.models.Post;

public interface PostRepository extends CrudRepository<Post, Integer> { }
