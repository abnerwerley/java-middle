package com.token.services.repository;

import com.token.services.dto.Child;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepository extends CrudRepository<Child, Long> {

    @Modifying
    @Query("delete from child")
    void deleteChildren();

    @Query("select id from child c where c.father_id =:fatherId and c.mother_id = :motherId")
    List<Integer> findChildByParentsId(@Param("fatherId") Long fatherId,
                                       @Param("motherId") Long motherId);

    @Modifying
    @Query("insert into child(id, name, father_id, mother_id) values (6, 'John', :fatherId, :motherId)")
    void insertChildMathew(@Param("fatherId") Long fatherId,
                           @Param("motherId") Long motherId);
}
