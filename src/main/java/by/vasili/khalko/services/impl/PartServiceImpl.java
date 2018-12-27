package by.vasili.khalko.services.impl;

import by.vasili.khalko.dataaccess.PartDao;
import by.vasili.khalko.services.PartService;
import by.vasili.khalko.datamodel.Part;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {

    private PartDao partDao;

    public Part get(Long id) {
        return this.partDao.get(id);
    }

    @Override
    @Transactional
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


}
