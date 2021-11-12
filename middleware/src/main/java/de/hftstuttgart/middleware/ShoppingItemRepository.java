package de.hftstuttgart.middleware;

import org.springframework.data.repository.CrudRepository;

public interface ShoppingItemRepository extends CrudRepository<ShoppingItem, Long> {
    
}
