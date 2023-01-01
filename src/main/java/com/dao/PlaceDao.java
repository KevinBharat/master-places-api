package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.PlaceBene;

@Repository
public class PlaceDao {
	@Autowired
	JdbcTemplate stmt;

	public void addPlace(PlaceBene place) {
		stmt.update(
				"insert into places(userid,title,location,speciality,best_time_to_visit,approved,createdAt,category) values (?,?,?,?,?,?,?,?)",
				place.getUserid(),place.getTitle(), place.getLocation(), place.getSpeciality(), place.getBestTimeToVisit(),
				place.isApproved(), place.getCreatedAt(),place.getCategory());

	}
}
