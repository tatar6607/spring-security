package com.springSecurity.controller;

import java.util.List;
import java.util.Optional;

import com.springSecurity.model.Kisi;
import com.springSecurity.service.KisiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/kisiler")
@CrossOrigin(origins = "http://localhost:8091")
public class KisiController {

	public KisiService kisiService;

	@Autowired
	public KisiController(KisiService kisiService) {
		this.kisiService = kisiService;
	}

	@GetMapping
	public List<Kisi> getAllPerson() {
		return kisiService.getAllKisi();
	}
	
	
	@GetMapping(path = "/{id}")
	public Optional<Kisi> getPersonWithId(@PathVariable("id")  int id) {
		return kisiService.getKisiWithId(id);
	}
	

	@PostMapping(path = "/ekle")
	public Kisi yeniKisiEkle(@RequestBody Kisi kisi) {
		return kisiService.kisiEkle(kisi);
	}
	
	@DeleteMapping(path = "/sil/{id}")
	public String kisiSil(@PathVariable("id") Integer id) {
		return kisiService.kisiSil(id);
	}
	
	@PutMapping(path = "/guncelle/{id}")
	public Kisi idIleGuncelle(@PathVariable Integer id, @RequestBody Kisi yeniKisi) {
		return kisiService.idIleKisiGuncelle(id, yeniKisi);
	}
	
//	@PatchMapping(path = "/kisiler/patch/{id}")
//	public Kisi idIleKismiGuncelle(@PathVariable Integer id,  @Validated @RequestBody Kisi yeniKisi) {
//		return kisiService.idIleKisiGuncelle(id, yeniKisi);
//	}
	
	@PatchMapping(path = "/yenile/{id}")
	public Kisi idIleKismiGuncelle(@PathVariable Integer id, @Validated @RequestBody Kisi yeniKisi) {
		return kisiService.idIleKismiGuncelle(id, yeniKisi);
	}
}
