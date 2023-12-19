package gym.pass_management.repository.pass;

import gym.pass_management.repository.AuditingFields;
import gym.pass_management.repository.gym.GymEntity;
import gym.pass_management.repository.packaze.PackageEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "pass")
@Entity
public class PassEntity extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer passSeq;

    private String userId;

    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private PassStatus status;

    private Integer remainingCount;

    @Column(nullable = false)
    private LocalDateTime startedAt;

    private LocalDateTime endedAt;

    private LocalDateTime expiredAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gym_seq", nullable = false)
    private GymEntity gymEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_seq", nullable = false)
    private PackageEntity packageEntity;
}
