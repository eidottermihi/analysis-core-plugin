package hudson.plugins.analysis.util.model.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author Michael Prankl
 */
@MappedSuperclass
public class BaseAnnotation {

    @Id
    @GeneratedValue
    private long id;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuildAnnotation> builds;
    @Column(length = 1024)
    private String message;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Tooltip tooltip;
    @Column
    private int primaryLineNumber;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private File file;
    @Column
    private String moduleName;
    @Column
    private String packageName;
    @Column
    private String origin;
    @Column
    private String type;
    @Column
    private long contextHashCode;
    @Column
    private int columnStart;
    @Column
    private int columnEnd;
    @Column
    private boolean isInConsoleLog = false;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public Tooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(final Tooltip tooltip) {
        this.tooltip = tooltip;
    }

    public int getPrimaryLineNumber() {
        return primaryLineNumber;
    }

    public void setPrimaryLineNumber(final int primaryLineNumber) {
        this.primaryLineNumber = primaryLineNumber;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(final Priority priority) {
        this.priority = priority;
    }

    public File getFile() {
        return file;
    }

    public void setFile(final File file) {
        this.file = file;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(final String moduleName) {
        this.moduleName = moduleName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(final String packageName) {
        this.packageName = packageName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public long getContextHashCode() {
        return contextHashCode;
    }

    public void setContextHashCode(final long contextHashCode) {
        this.contextHashCode = contextHashCode;
    }

    public int getColumnStart() {
        return columnStart;
    }

    public void setColumnStart(final int columnStart) {
        this.columnStart = columnStart;
    }

    public int getColumnEnd() {
        return columnEnd;
    }

    public void setColumnEnd(final int columnEnd) {
        this.columnEnd = columnEnd;
    }

    public boolean isInConsoleLog() {
        return isInConsoleLog;
    }

    public void setIsInConsoleLog(final boolean isInConsoleLog) {
        this.isInConsoleLog = isInConsoleLog;
    }

    public List<BuildAnnotation> getBuilds() {
        return builds;
    }

    public void setBuilds(List<BuildAnnotation> builds) {
        this.builds = builds;
    }
}
