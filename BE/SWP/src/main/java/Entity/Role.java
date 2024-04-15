package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "RoleId", nullable = false)
    private Integer id;

    @Column(name = "RoleName", length = 50)
    private String roleName;

    @Column(name = "Descriptions", length = 100)
    private String descriptions;

}