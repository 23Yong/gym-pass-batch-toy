package gym.pass_management.repository.packaze;

import gym.pass_management.repository.AuditingFields;
import gym.pass_management.repository.gym.GymEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "package")
@Entity
public class PackageEntity extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer packageSeq;

    @Column(nullable = false, length = 50)
    private String packageName;

    private Integer count;

    private Integer period;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gym_seq", nullable = false)
    private GymEntity gymEntity;

    @Builder
    private PackageEntity(String packageName, Integer count, Integer period, GymEntity gymEntity) {
        this.packageName = packageName;
        this.count = count;
        this.period = period;
        this.gymEntity = gymEntity;
    }
}
