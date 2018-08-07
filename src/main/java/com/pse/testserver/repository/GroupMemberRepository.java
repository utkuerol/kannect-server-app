package com.pse.testserver.repository;

import com.pse.testserver.entities.GroupMember;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface GroupMemberRepository extends CrudRepository<GroupMember, Integer> {

    @Query(value = "Select * from group_members gm where gm.user_id = :userId and gm.group_id = :groupId", nativeQuery = true)
    GroupMember findAllByUserAndGroupId(@Param("userId") int userId, @Param("groupId") int groupId);
}
