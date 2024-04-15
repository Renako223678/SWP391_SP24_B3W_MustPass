package Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "informationrecipient")
public class Informationrecipient {
    @Id
    @Column(name = "InforId", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "Dest_address")
    private String destAddress;

    @Column(name = "RecipientName", length = 30)
    private String recipientName;

    @Column(name = "PhoneNumber")
    private Integer phoneNumber;

}