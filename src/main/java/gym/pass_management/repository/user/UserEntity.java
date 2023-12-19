package gym.pass_management.repository.user;

import gym.pass_management.repository.AuditingFields;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
@Entity
public class UserEntity extends AuditingFields {

    @Id
    private String userId;

    @Column(nullable = false, length = 50)
    private String userName;

    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(length = 50)
    private String phone;

    private String meta;
}
