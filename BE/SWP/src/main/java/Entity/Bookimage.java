package Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bookimages")
public class Bookimage {
    @Id
    @Column(name = "ImageId", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "Url")
    private String url;

    @Column(name = "Status")
    private Byte status;

}