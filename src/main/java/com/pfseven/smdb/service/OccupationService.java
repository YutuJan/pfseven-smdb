package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.RoleType;
import com.pfseven.smdb.domain.Occupation;

import java.util.List;

public interface OccupationService extends BaseService<Occupation, Long> {

    List<Occupation> findAll(RoleType role);
}
