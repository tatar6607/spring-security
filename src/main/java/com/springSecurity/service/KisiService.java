package com.springSecurity.service;

import java.util.List;
import java.util.Optional;

import com.springSecurity.model.Kisi;
import com.springSecurity.repository.KisiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class KisiService {

	public static KisiRepository kisiRepo;

	// Dependency Injection
	@Autowired // Bastan create etmiyor ihtiyac halinde olusturuyor
	public KisiService(KisiRepository kisiRepo) {
		this.kisiRepo = kisiRepo;
	}

	public List<Kisi> getAllKisi() {
		return kisiRepo.findAll();
	}

	// veri tabanina kisi ekleyen service
	public Kisi kisiEkle(Kisi kisi) {
		return kisiRepo.save(kisi);
	}

	public Optional<Kisi> getKisiWithId(int id) {
		return kisiRepo.findById(id);

	}

	public String kisiSil(Integer id) {
		Optional<Kisi> kisi = kisiRepo.findById(id);
		if (kisi == null) {
			throw new IllegalStateException(id + " li kisi bulunamadi");
		}

		kisiRepo.deleteById(id);
		return id + " li kisi silindi";
	}

	public Kisi idIleKisiGuncelle(Integer id, Kisi guncelKisi) {
		Optional<Kisi> kisi = kisiRepo.findById(id);
		kisi.orElseThrow(() -> new IllegalStateException(id + " li kisi bulunamdi"));
		guncelKisi.setId(kisi.get().getId());
		return kisiRepo.save(guncelKisi);
	}
	
	public Kisi idIleKismiGuncelle(Integer id , Kisi yeniKisi) {
//		Kisi eskiKisi = kisiRepo.findById(id).orElseThrow(() -> new IllegalStateException(id + " li kisi bulunamadi"));
		
		////
		
//		if(yeniKisi.getAd()!=null) {
//			eskiKisi.setAd(yeniKisi.getAd());
//		}
//		if(yeniKisi.getSoyad()!=null) {
//			eskiKisi.setSoyad(yeniKisi.getSoyad());
//		}
//		if(yeniKisi.getYas()!=0) {
//			eskiKisi.setYas(yeniKisi.getYas());
//		}

		
		
		//
		
//		if(yeniKisi.getAd() != null) {
//			eskiKisi.setAd(yeniKisi.getAd());
//		}
//		
//		if(yeniKisi.getSoyad() != null) {
//			eskiKisi.setSoyad(yeniKisi.getSoyad());;
//		}
//		
//		if(yeniKisi.getYas() != 0) {
//			eskiKisi.setYas(yeniKisi.getYas());;
//		}
		
//		return kisiRepo.save(eskiKisi);
		
		Kisi eskiKisi = kisiRepo.findById(id).
				orElseThrow( () -> new IllegalStateException(id + " li kisi bulunamadi"));
				if(yeniKisi.getAd()!=null) {
					eskiKisi.setAd(yeniKisi.getAd());
				}
				if(yeniKisi.getSoyad()!=null) {
					eskiKisi.setSoyad(yeniKisi.getSoyad());
				}
				if(yeniKisi.getYas()!=0) {
					eskiKisi.setYas(yeniKisi.getYas());
				}
				return kisiRepo.save(eskiKisi);
			}		

	}


