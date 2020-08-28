package com.github.perscholas.services;

import com.github.perscholas.models.Guests;
import com.github.perscholas.models.MyModel;
import com.github.perscholas.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GuestsService {
    private GuestRepository guestRepository;

    @Autowired
    public GuestsService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public Iterable<Guests> index() {
        return guestRepository.findAll();
    }

    public Guests show(Long id) {
        return guestRepository.findById(id).get();
    }

    public Guests create(Guests guests) {
        return guestRepository.save(guests);
    }

    public Guests update(Long id, Guests newGuestData) {
        Guests originalGuest = guestRepository.findById(id).get();
        originalGuest.setName(newGuestData.getName());
        return guestRepository.save(originalGuest);
    }

    public Boolean delete(Long id) {
        guestRepository.deleteById(id);
        return true;
    }
}
