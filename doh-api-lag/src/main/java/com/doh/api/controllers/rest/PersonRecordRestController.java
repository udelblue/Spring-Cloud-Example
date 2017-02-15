package com.doh.api.controllers.rest;



import com.doh.api.domain.people.PersonRecord;
import com.doh.api.domain.people.PersonRecordRepository;
import com.google.common.collect.Lists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 *
 */

@Transactional
@RestController
@RequestMapping("/records")
//@PreAuthorize(value = "hasRole('ROLE_USER')")
public class PersonRecordRestController {

    private static final Logger log = LoggerFactory.getLogger(PersonRecordRestController.class);

    @Autowired
    private PersonRecordRepository personRecordRepository;

    @PostConstruct
    public void fillData() {
        List<PersonRecord> records = this.getRecords();
        if (records.isEmpty()) {
            for (int i = 1; i <= 10; i++) {
            	PersonRecord record = new PersonRecord("Tom ", "Tester " , "testing");
            	personRecordRepository.save(record);
                log.warn(record.toString());
            }
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<PersonRecord> getRecords() {
        return Lists.newArrayList(personRecordRepository.findAll());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public PersonRecord saveRecord(@RequestBody PersonRecord personRecord) {
        return personRecordRepository.save(personRecord);
    }

    @RequestMapping(value = "/{recordId}", method = RequestMethod.DELETE)
    public PersonRecord deleteRecord(@PathVariable("recordId") Long recordId) {
    	PersonRecord personRecord = personRecordRepository.findOne(recordId);
        if (personRecord != null) {
        	personRecordRepository.delete(personRecord);
        }
        return personRecord;
    }

}
