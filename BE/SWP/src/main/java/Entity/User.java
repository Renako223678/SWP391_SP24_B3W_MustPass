package Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "UserId", nullable = false)
    private Integer id;

    @Column(name = "Email", length = 100)
    private String email;

    @Column(name = "Password", length = 100)
    private String password;

    @Column(name = "Fullname", length = 100)
    private String fullname;

    @Column(name = "Number_of_Lotus")
    private Integer numberOfLotus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoleID")
    private Role roleID;

}