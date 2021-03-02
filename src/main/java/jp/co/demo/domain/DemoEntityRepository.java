package jp.co.demo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DemoEntityRepository extends CrudRepository<DemoEntity, Long> {

    @Override
    List<DemoEntity> findAll();

}
