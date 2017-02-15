package com.doh.api.domain.user;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.doh.api.domain.base.AuditedEntity;

/**
 *
 */
@Entity
@Table(name = "USER")
public class User extends AuditedEntity {

}
