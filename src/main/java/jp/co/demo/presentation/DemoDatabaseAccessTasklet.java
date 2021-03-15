package jp.co.demo.presentation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.demo.application.DemoScenario;
import jp.co.demo.domain.DemoEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DemoDatabaseAccessTasklet implements Tasklet {

    @Autowired
    private DemoScenario demoScenario;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        List<String> demos = demoScenario.getAllDemoEntity()
                                         .stream()
                                         .map(DemoEntity::getDemoString)
                                         .collect(Collectors.toList());
        log.info(demos.toString());
        return RepeatStatus.FINISHED;
    }

}
