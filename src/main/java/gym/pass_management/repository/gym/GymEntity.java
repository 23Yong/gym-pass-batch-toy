package gym.pass_management.repository.gym;

import gym.pass_management.repository.AuditingFields;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "gym")
@Entity
public class GymEntity extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gymSeq;

    @Column(nullable = false, length = 50)
    private String gymName;

    public GymEntity(String gymName) {
        this.gymName = gymName;
    }
}
