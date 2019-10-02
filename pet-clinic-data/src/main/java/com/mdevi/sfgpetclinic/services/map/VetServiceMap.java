package com.mdevi.sfgpetclinic.services.map;

import com.mdevi.sfgpetclinic.model.Speciality;
import com.mdevi.sfgpetclinic.model.Vet;
import com.mdevi.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialitiesMapService specialitiesMapService;

    public VetServiceMap(SpecialitiesMapService specialitiesMapService) {
        this.specialitiesMapService = specialitiesMapService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        if (vet.getSpecialities().size() > 0) {
            vet.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpeciality = specialitiesMapService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }

        return super.save(vet);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }
}
