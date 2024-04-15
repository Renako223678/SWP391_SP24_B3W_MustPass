package Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "banner")
public class Banner {
    @Id
    @Column(name = "BannerId", nullable = false)
    private Integer id;

    @Column(name = "BannerName", length = 50)
    private String bannerName;

    @Lob
    @Column(name = "Url")
    private String url;

    @Lob
    @Column(name = "Context")
    private String context;

    @Column(name = "StartDate")
    private LocalDate startDate;

    @Column(name = "EndDate")
    private LocalDate endDate;

}