package gym.pass_management.job.pass;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class PassJobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step passStep() {
        return this.stepBuilderFactory.get("passStep")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println("Execution PassStep");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Job passJob() {
        return this.jobBuilderFactory.get("passJob")
                .start(passStep())
                .build();
    }
}
