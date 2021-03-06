package org.debugroom.wedding.domain.repository.cassandra.message;

import java.util.List;

import org.debugroom.wedding.domain.entity.message.Group;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CassandraGroupRepository extends CrudRepository<Group, Long>{
	
	public List<Group> findByGroupIdIn(List<Long> groupIds);

	@Query("select max(group_id) from group")
	public long findTopByOrderByGroupId();

}
