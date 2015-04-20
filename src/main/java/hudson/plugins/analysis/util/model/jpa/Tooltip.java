package hudson.plugins.analysis.util.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * @author Michael Prankl
 */
@Entity
public class Tooltip {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 4096)
    private String tooltip;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }
}
