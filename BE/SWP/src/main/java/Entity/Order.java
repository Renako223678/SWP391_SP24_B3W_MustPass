package Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "OrderId", nullable = false)
    private Integer id;

    @Column(name = "BookName", length = 50)
    private String bookName;

    @Lob
    @Column(name = "Description")
    private String description;

    @Column(name = "OrderDate")
    private LocalDate orderDate;

    @Column(name = "ShipFee", precision = 10)
    private BigDecimal shipFee;

    @Column(name = "LotusBub_using_amount")
    private Integer lotusbubUsingAmount;

    @Column(name = "TotalPrice", precision = 10)
    private BigDecimal totalPrice;

    @Column(name = "Status")
    private Byte status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "InforId")
    private Informationrecipient infor;

}