package jp.co.demo.domain;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Entity
public class DemoEntity {

    private Long demoId;
    private String demoString;

}
