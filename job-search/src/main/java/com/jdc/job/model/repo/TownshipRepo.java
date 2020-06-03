package com.jdc.job.model.repo;

import java.util.List;

import com.jdc.job.model.BaseRepository;
import com.jdc.job.model.entity.Township;

public interface TownshipRepo extends BaseRepository<Township, Integer>{

	List<Township> findByDivisionId(int id);

}
