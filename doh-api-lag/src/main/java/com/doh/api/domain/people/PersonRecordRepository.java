package com.doh.api.domain.people;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.doh.api.domain.people.PersonRecord;
/**
 *
 */
@Repository
public interface PersonRecordRepository extends CrudRepository<PersonRecord, Long> {
}
