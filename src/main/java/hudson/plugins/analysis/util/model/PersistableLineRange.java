package hudson.plugins.analysis.util.model;

import org.jenkinsci.plugins.database.jpa.PerItemTable;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by michael on 31.03.15.
 */
@Entity
@PerItemTable
public class PersistableLineRange implements Serializable {

    private long id;
    private int start;
    private int end;

    public PersistableLineRange() {
    }

    public PersistableLineRange(LineRange lineRange) {
        setStart(lineRange.getStart());
        setEnd(lineRange.getEnd());
    }


    @Column
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    @Column
    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
