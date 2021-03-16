package jp.co.demo.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.demo.domain.DemoEntity;

@SpringBootTest
public class DemoScenarioTest {

    @Autowired
    private DemoScenario demoScenario;

    @Test
    public void getHoge_メッセージを返す() {
        assertThat(demoScenario.getHoge()).isEqualTo("Hoge from application layer");
    }

    @Test
    public void demoTest1() {
        assertThat(demoScenario.demoTest1()).isTrue();
    }

    @Test
    public void demoTest2() {
        assertThat(demoScenario.demoTest2()).contains("a");
        assertThat(demoScenario.demoTest2()).contains("b");
        assertThat(demoScenario.demoTest2()).contains("c");
        assertThat(demoScenario.demoTest2()).containsOnly("a", "b", "c");
        assertThat(demoScenario.demoTest2()).containsExactly("a", "b", "c");
    }

    @Test
    public void demoTest3() {
        // good
        assertThat(demoScenario.demoTest3()).hasSize(2)
                                            .allSatisfy(entity -> {
                                                assertThat(entity.getDemoString()).isEqualTo("demo1");
                                            });

        // bad
        demoScenario.demoTest3()
                    .forEach(entity -> {
                        assertThat(entity.getDemoString()).isEqualTo("demo1");
                    });
    }

    @Test
    public void demoTest4() {
        // good
        assertThat(demoScenario.demoTest4()).extracting(entity -> entity.getDemoString())
                                            .isEqualTo("demo1");

        // bad
        assertThat(demoScenario.demoTest4()
                               .getDemoString()).isEqualTo("demo1");
        // bad
        assertThat(demoScenario.demoTest4()).isEqualTo(new DemoEntity(1L, "demo1"));
    }

}
