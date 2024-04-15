package Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "ordersdetail")
public class Ordersdetail {
    @Id
    @Column(name = "OrderDetailId", nullable = false)
    private Integer id;

    @Column(name = "BookName", length = 50)
    private String bookName;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Price", precision = 10)
    private BigDecimal price;

    @Column(name = "TotalPrice", precision = 10)
    private BigDecimal totalPrice;

    @Column(name = "Status")
    private Byte status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BookId")
    private Book book;

}