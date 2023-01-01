package com.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bean.PlaceBene;
import com.dao.PlaceDao;

@RestController
public class PlaceController {
	@Autowired
	PlaceDao placeDao;
	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/place")
	public ResponseEntity<?> addPlace(@RequestBody PlaceBene place) {
		LocalDate today = LocalDate.now();
		place.setCreatedAt(today.toString());
		placeDao.addPlace(place);
		return ResponseEntity.ok(place);
	}

}
