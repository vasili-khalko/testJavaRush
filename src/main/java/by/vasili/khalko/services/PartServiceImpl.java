package by.vasili.khalko.services;

import by.vasili.khalko.dataaccess.PartDao;
import by.vasili.khalko.datamodel.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class PartServiceImpl implements PartService {

    @Autowired
    private PartDao partDao;

    public Part get(Long id) {
        return this.partDao.get(id);
    }

    @Override
    public void add(Part part) {
        this.partDao.add(part);
    }

    @Override
    public void update(Part part) {
        this.partDao.update(part);
    }

    @Override
    public void delete(Long id) {
        this.partDao.delete(id);
    }

    @Override
    public List<Part> getAllParts() {
        return this.partDao.getAll();
    }

    @Override
    public List<Part> getAllPartsByName(String name) {
        return this.partDao.getAllByName(name);
    }

    @Override
    public Integer getNumberPcCanBeAssembled() {
        List<Part> partsIsNeed = this.partDao.getAllByNeed(true);
        Integer numberPcCanBeAssemled = Collections.min(partsIsNeed, Comparator.comparingInt(Part::getQuantity)).getQuantity();
        return numberPcCanBeAssemled;
    }

    @Override
    public List<Part> getAllPartsByNeed(Boolean isNeed) {
        return this.partDao.getAllByNeed(isNeed);
    }


}
