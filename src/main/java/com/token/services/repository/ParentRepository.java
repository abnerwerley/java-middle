package com.token.services.repository;

import com.token.services.dto.FamilyNames;
import com.token.services.dto.Parent;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentRepository extends CrudRepository<Parent, Long> {

    @Query("select name from parent where id in (1,2,5)")
    List<String> findAllFatherNames();

    @Query("select p.name from parent p inner join child c on p.id = c.father_id group by p.id having count(c.id) > 1")
    List<String> findFathersWithMoreThanOneChild();

    @Query("select c.name as child_name,f.name as father_name,m.name as mother_name from child c " +
            "left join parent f on c.father_id = f.id left join parent m on c.mother_id = m.id")
    List<FamilyNames> findFamilyNames();

    @Query("select count(*) from child where father_id = (select id from parent where name ='John')")
    int countJohnsChildren();

    @Query("select count(*) from child where mother_id = (select id from parent where name ='Mary')")
    int countMarysChildren();


    @Query("select id from parent where name=:name")
    List<Integer> findParentsByName(@Param("name") String name);

    @Modifying
    @Query("delete from parent")
    void deleteParents();

    @Modifying
    @Query("insert into parent(id, name) values (:id, 'John')")
    void insertParentJohn(@Param("id") Integer id);

    @Modifying
    @Query("insert into parent(id, name) values (:id, 'John')")
    void insertParentMary(@Param("id") Integer id);
}
