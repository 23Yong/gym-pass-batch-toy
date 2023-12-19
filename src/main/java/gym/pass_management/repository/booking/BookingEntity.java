package gym.pass_management.repository.booking;

import gym.pass_management.repository.AuditingFields;
import gym.pass_management.repository.gym.GymEntity;
import gym.pass_management.repository.pass.PassEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "booking")
@Entity
public class BookingEntity extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingSeq;

    private String userId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @Column(nullable = false, columnDefinition = "TINYINT(1) default 0")
    private boolean usedPass;

    @Column(nullable = false, columnDefinition = "TINYINT(1) default 0")
    private boolean attended;

    @Column(nullable = false)
    private LocalDateTime startedAt;

    @Column(nullable = false)
    private LocalDateTime endedAt;

    private LocalDateTime cancelledAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gym_seq", nullable = false)
    private GymEntity gymEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pass_seq", nullable = false)
    private PassEntity passEntity;
}
