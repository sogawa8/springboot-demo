package jp.co.demo.presentation;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@EnableBatchProcessing
@Configuration
@RequiredArgsConstructor
public class DemoJobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DemoTasklet demoTasklet;
    private final DemoDatabaseAccessTasklet demoDatabaseAccessTasklet;

    @Bean
    public Job demoJob(Step demoStep1, Step demoStep2) {
        return jobBuilderFactory.get("demoJob")
                                .start(demoStep1)
                                .next(demoStep2)
                                .build();
    }

    @Bean
    public Step demoStep1() {
        return stepBuilderFactory.get("demoStep1")
                                 .tasklet(demoTasklet)
                                 .build();
    }

    @Bean
    public Step demoStep2() {
        return stepBuilderFactory.get("demoStep2")
                                 .tasklet(demoDatabaseAccessTasklet)
                                 .build();
    }

}
