package hudson.plugins.analysis.util.model.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.jenkinsci.plugins.database.jpa.PerItemTable;

/**
 * @author Michael Prankl
 */
@Entity
@PerItemTable
public class Build {

    @Id
    private int buildNr;

    public int getBuildNr() {
        return buildNr;
    }

    public void setBuildNr(int buildNr) {
        this.buildNr = buildNr;
    }
}
