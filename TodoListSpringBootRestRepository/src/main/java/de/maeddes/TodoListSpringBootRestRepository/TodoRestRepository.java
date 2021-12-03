package de.maeddes.TodoListSpringBootRestRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "todos", path = "todos-hal")
public interface TodoRestRepository extends CrudRepository<Todo,String>{
    
}
