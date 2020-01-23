package com.epam.task.service;

import com.epam.task.models.Advertisement;
import com.epam.task.repositories.AdvertisementRepository;

import java.util.List;

public class AdvertisementService {
    AdvertisementRepository advertisementRepository = new AdvertisementRepository();

    public Advertisement add (Advertisement advert) {
        return advertisementRepository.add(advert);
    }

    public Advertisement get (long id) {
        return advertisementRepository.get(id);
    }

    public List<Advertisement> get () {
        return advertisementRepository.get();
    }

    public List<Advertisement> findAllByUserId (long id) {
        return advertisementRepository.findAllByUserId(id);
    }

    public boolean removeById(long id) {
        return advertisementRepository.removeById(id);
    }
}
