package ca.college.inventory.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity @Table(name="products")
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank(message="Product name is required") @Size(max=100,message="Name must be 100 characters or fewer") @Column(nullable=false,length=100) private String name;
 @NotBlank(message="SKU is required") @Pattern(regexp="[A-Za-z0-9-]{3,30}",message="SKU must be 3–30 letters, numbers or hyphens") @Column(nullable=false,unique=true,length=30) private String sku;
 @NotNull(message="Choose a category") @Enumerated(EnumType.STRING) @Column(nullable=false) private Category category;
 @NotNull(message="Quantity is required") @Min(value=0,message="Quantity cannot be negative") @Max(value=100000,message="Quantity must not exceed 100,000") @Column(nullable=false) private Integer quantity;
 @NotNull(message="Price is required") @DecimalMin(value="0.01",message="Price must be at least $0.01") @DecimalMax(value="1000000.00",message="Price must not exceed $1,000,000") @Digits(integer=7,fraction=2,message="Use at most 2 decimal places") @Column(nullable=false,precision=9,scale=2) private BigDecimal price;
 @NotNull(message="Reorder level is required") @Min(value=0,message="Reorder level cannot be negative") @Max(value=100000,message="Reorder level must not exceed 100,000") @Column(nullable=false) private Integer reorderLevel;
 @NotBlank(message="Supplier is required") @Size(max=80,message="Supplier must be 80 characters or fewer") @Column(nullable=false,length=80) private String supplier;
 @Column(nullable=false,updatable=false) private LocalDateTime createdAt;
 @PrePersist public void onCreate(){createdAt=LocalDateTime.now();}
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getSku(){return sku;} public void setSku(String v){sku=v;}
 public Category getCategory(){return category;} public void setCategory(Category v){category=v;}
 public Integer getQuantity(){return quantity;} public void setQuantity(Integer v){quantity=v;}
 public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal v){price=v;}
 public Integer getReorderLevel(){return reorderLevel;} public void setReorderLevel(Integer v){reorderLevel=v;}
 public String getSupplier(){return supplier;} public void setSupplier(String v){supplier=v;}
 public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime v){createdAt=v;}
 public boolean isLowStock(){return quantity!=null&&reorderLevel!=null&&quantity<=reorderLevel;}
}
