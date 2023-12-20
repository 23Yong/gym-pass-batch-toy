package gym.pass_management.job.pass;

import gym.pass_management.config.TestBatchConfig;
import gym.pass_management.repository.gym.GymEntity;
import gym.pass_management.repository.gym.GymRepository;
import gym.pass_management.repository.packaze.PackageEntity;
import gym.pass_management.repository.packaze.PackageRepository;
import gym.pass_management.repository.pass.PassEntity;
import gym.pass_management.repository.pass.PassRepository;
import gym.pass_management.repository.pass.PassStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@Slf4j
@DisplayName("이용권 만료 테스트")
@ActiveProfiles("test")
@SpringBatchTest
@SpringBootTest
@ContextConfiguration(classes = {ExpirePassesJobConfig.class, TestBatchConfig.class})
class ExpirePassesJobConfigTest {
    @Autowired
    private GymRepository gymRepository;
    @Autowired
    private PassRepository passRepository;
    @Autowired
    private PackageRepository packageRepository;
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @DisplayName("이용기간이 지난 모든 이용권을 만료시킨다.")
    @Test
    void expirePassesStep() throws Exception {
        // given
        addPassEntities(10);

        // when
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        JobInstance jobInstance = jobExecution.getJobInstance();

        // then
        assertAll(
                () -> assertThat(jobExecution.getExitStatus()).isEqualTo(ExitStatus.COMPLETED),
                () -> assertThat(jobInstance.getJobName()).isEqualTo("expirePassesJob"),
                () -> assertThat(passRepository.findAll())
                        .allMatch(passEntity -> passEntity.getStatus() == PassStatus.EXPIRED && passEntity.getExpiredAt() != null)
        );
    }

    private void addPassEntities(int size) {
        var now = LocalDateTime.now();
        var random = new Random();

        var gymEntity = gymRepository.save(new GymEntity("세븐짐 : 강남 2호점"));
        var packageEntity = packageRepository.save(PackageEntity.builder()
                .gymEntity(gymEntity)
                .packageName("테스트 패키지")
                .count(10)
                .build());

        List<PassEntity> passEntities = IntStream.range(0, size).mapToObj(i -> PassEntity.builder()
                        .packageEntity(packageEntity)
                        .gymEntity(gymEntity)
                        .userId("A" + 1000 + i)
                        .status(PassStatus.PROGRESSED)
                        .remainingCount(random.nextInt(11))
                        .startedAt(now.minusDays(60))
                        .endedAt(now.minusDays(1))
                        .build())
                .toList();

        passRepository.saveAll(passEntities);
    }
}
