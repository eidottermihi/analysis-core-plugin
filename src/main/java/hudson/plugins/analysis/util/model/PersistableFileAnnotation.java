package hudson.plugins.analysis.util.model;

import hudson.model.AbstractBuild;
import org.jenkinsci.plugins.database.jpa.PerItemTable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * JPA Entity for {@link FileAnnotation}
 *
 * @author Michael Prankl
 */
@PerItemTable
@Entity
public class PersistableFileAnnotation implements FileAnnotation, Serializable {

    @Id
    @GeneratedValue
    private long id;
    @Column
    private long key;
    @Column(length = 4096)
    private String message;
    @Column(length = 4096)
    private String toolTip;
    @Column
    private int primaryLineNumber;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Collection<PersistableLineRange> lineRanges;
    @Column
    private Priority priority;
    @Column
    private String fileName;
    @Column
    private String linkName;
    @Column
    private String shortFileName;
    @Column
    private String moduleName;
    @Column
    private String packageName;
    @Column
    private String pathName;
    @Column
    private String category;
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
    private boolean isInConsoleLog;

    public PersistableFileAnnotation(){
    }

    public PersistableFileAnnotation(FileAnnotation fileAnnotation){
        setKey(fileAnnotation.getKey());
        setMessage(fileAnnotation.getMessage());
        setToolTip(fileAnnotation.getToolTip());
        setPrimaryLineNumber(fileAnnotation.getPrimaryLineNumber());
        setPriority(fileAnnotation.getPriority());
        setFileName(fileAnnotation.getFileName());
        setLinkName(fileAnnotation.getLinkName());
        setShortFileName(fileAnnotation.getShortFileName());
        setModuleName(fileAnnotation.getModuleName());
        setPackageName(fileAnnotation.getPackageName());
        setCategory(fileAnnotation.getCategory());
        setOrigin(fileAnnotation.getOrigin());
        setType(fileAnnotation.getType());
        setContextHashCode(fileAnnotation.getContextHashCode());
        setColumnStart(fileAnnotation.getColumnStart());
        setColumnEnd(fileAnnotation.getColumnEnd());
        final List<PersistableLineRange> persistableLineRanges = new ArrayList<PersistableLineRange>();
        for (LineRange lineRange : fileAnnotation.getLineRanges()) {
            persistableLineRanges.add(new PersistableLineRange(lineRange));
        }
        setLineRanges(persistableLineRanges);

    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String getToolTip() {
        return this.toolTip;
    }

    @Override
    public int getPrimaryLineNumber() {
        return this.primaryLineNumber;
    }

    @Override
    public Collection<LineRange> getLineRanges() {
        final List<LineRange> ranges = new ArrayList<LineRange>();
        for (PersistableLineRange range : this.lineRanges){
            ranges.add(new LineRange(range.getStart(), range.getEnd()));
        }
        return ranges;
    }

    @Override
    public long getKey() {
        return this.key;
    }

    @Override
    public Priority getPriority() {
        return this.priority;
    }

    @Override
    public String getFileName() {
        return this.fileName;
    }

    @Override
    public String getLinkName() {
        return this.linkName;
    }

    @Override
    public String getTempName(AbstractBuild<?, ?> owner) {
        return null;
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void setPathName(String workspacePath) {
        this.pathName = workspacePath;
    }

    @Override
    public boolean canDisplayFile(AbstractBuild<?, ?> owner) {
        return false;
    }

    @Override
    public String getShortFileName() {
        return this.shortFileName;
    }

    @Override
    public String getModuleName() {
        return this.moduleName;
    }

    @Override
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Override
    public String getPackageName() {
        return this.packageName;
    }

    @Override
    public boolean hasPackageName() {
        return false;
    }

    @Override
    public String getPathName() {
        return this.pathName;
    }

    @Override
    public String getOrigin() {
        return this.origin;
    }

    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public long getContextHashCode() {
        return this.contextHashCode;
    }

    @Override
    public void setContextHashCode(long contextHashCode) {
        this.contextHashCode = contextHashCode;
    }

    @Override
    public int getColumnStart() {
        return this.columnStart;
    }

    @Override
    public int getColumnEnd() {
        return this.columnEnd;
    }

    @Override
    public boolean isInConsoleLog() {
        return this.isInConsoleLog;
    }

    @Override
    public int compareTo(FileAnnotation fileAnnotation) {
        return 0;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setToolTip(String toolTip) {
        this.toolTip = toolTip;
    }

    public void setPrimaryLineNumber(int primaryLineNumber) {
        this.primaryLineNumber = primaryLineNumber;
    }

    public void setLineRanges(Collection<PersistableLineRange> lineRanges) {
        this.lineRanges = lineRanges;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public void setShortFileName(String shortFileName) {
        this.shortFileName = shortFileName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColumnStart(int columnStart) {
        this.columnStart = columnStart;
    }

    public void setColumnEnd(int columnEnd) {
        this.columnEnd = columnEnd;
    }

    public void setIsInConsoleLog(boolean isInConsoleLog) {
        this.isInConsoleLog = isInConsoleLog;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
