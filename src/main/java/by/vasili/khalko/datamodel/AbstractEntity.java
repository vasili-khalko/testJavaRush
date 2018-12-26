package by.vasili.khalko.datamodel;

public abstract class AbstractEntity {

    public abstract Long getId();

    @Override
    public int hashCode() {
        if (getId() != null) {
            return getId().hashCode();
        } else {
            return super.hashCode();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || !(obj instanceof AbstractEntity)) {
            return false;
        }

        final AbstractEntity other = (AbstractEntity) obj;

        // if the id is missing, return false
        if (getId() == null) {
            return false;
        }

        //equivalence by id
        return getId().equals(other.getId());
    }
}
