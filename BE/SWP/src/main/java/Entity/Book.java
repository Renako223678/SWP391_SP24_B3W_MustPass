package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "BookId", nullable = false)
    private Integer id;

    @Column(name = "BookName", length = 50)
    private String bookName;

    @Column(name = "Description", length = 100)
    private String description;

    @Column(name = "Author", length = 30)
    private String author;

    @Column(name = "PublishingCompany", length = 50)
    private String publishingCompany;

    @Column(name = "IssusingCompany", length = 50)
    private String issusingCompany;

    @Column(name = "Translator", length = 30)
    private String translator;

    @Column(name = "PublishDate")
    private LocalDate publishDate;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Price", precision = 10)
    private BigDecimal price;

    @Column(name = "Status")
    private Byte status;

    @Column(name = "TotalFeedback")
    private Integer totalFeedback;

}