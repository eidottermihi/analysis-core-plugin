package hudson.plugins.analysis.util.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.jenkinsci.plugins.database.jpa.PerItemTable;

/**
 * @author Michael Prankl
 */
@Entity
@Table(name = "File", uniqueConstraints = @UniqueConstraint(name = "UNI_FilePath", columnNames = "filePath"))
@PerItemTable
public class File {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 1024, unique = true)
    private String filePath;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(final String filePath) {
        this.filePath = filePath;
    }
}
