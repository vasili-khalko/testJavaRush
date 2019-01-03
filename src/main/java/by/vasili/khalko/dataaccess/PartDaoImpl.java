package by.vasili.khalko.dataaccess;

import by.vasili.khalko.datamodel.Part;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PartDaoImpl implements PartDao {

    private SessionFactory sessionFactory;

    public PartDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Part> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Part> parts = session.createQuery("from Parts").list();

        return parts;
    }

    @Override
    public List<Part> getAllByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Parts where partsName = :name");
        query.setParameter("name", name);
        List<Part> parts = query.list();
        return parts;
    }

    @Override
    public Part get(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Part part = session.load(Part.class, id);
        return part;
    }

    @Override
    public void add(Part part) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(part);
    }

    @Override
    public void update(Part part) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(part);
    }

    @Override
    public void delete(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Part part = session.load(Part.class, id);

        if(part != null){
            session.delete(part);
        }
    }
}
