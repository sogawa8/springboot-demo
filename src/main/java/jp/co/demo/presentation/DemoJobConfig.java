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

    @Bean
    public Job demoJob(Step demoStep) {
        return jobBuilderFactory.get("demoJob")
                                .start(demoStep)
                                .build();
    }

    @Bean
    public Step demoStep() {
        return stepBuilderFactory.get("demoStep")
                                 .tasklet(demoTasklet)
                                 .build();
    }

}
