package hudson.plugins.analysis.util.model.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.jenkinsci.plugins.database.jpa.PerItemTable;

/**
 * @author Michael Prankl
 */
@Entity
@PerItemTable
public class BuildAnnotation {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Build build;
    @ManyToOne
    private BaseAnnotation annotation;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public Build getBuild() {
        return build;
    }

    public void setBuild(final Build build) {
        this.build = build;
    }

    public BaseAnnotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(final BaseAnnotation annotation) {
        this.annotation = annotation;
    }
}
