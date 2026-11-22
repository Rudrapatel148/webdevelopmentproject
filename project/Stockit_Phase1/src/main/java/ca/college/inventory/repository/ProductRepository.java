package ca.college.inventory.repository;
import ca.college.inventory.model.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
public interface ProductRepository extends JpaRepository<Product,Long> {
 boolean existsBySkuIgnoreCase(String sku);
 @Query("SELECT p FROM Product p WHERE (:category IS NULL OR p.category = :category) AND (:stock IS NULL OR (:stock = 'LOW' AND p.quantity <= p.reorderLevel) OR (:stock = 'OK' AND p.quantity > p.reorderLevel))")
 Page<Product> search(@Param("category") Category category,@Param("stock") String stock,Pageable pageable);
}
