package rdc.platform.java.mbg.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

public class ProjectDir implements Serializable {
    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "关联项目ID")
    private String projectId;

    @ApiModelProperty(value = "关联项目")
    private String projectName;

    @ApiModelProperty(value = "目录（文件）名称")
    private String name;

    @ApiModelProperty(value = "上级目录")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer parentId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ProjectDir> children;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ProjectDir child;

    @ApiModelProperty(value = "是否为文件")
    private Boolean isFile;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean getIsFile() {
        return isFile;
    }

    public void setIsFile(Boolean isFile) {
        this.isFile = isFile;
    }

    public List<ProjectDir> getChildren() {
        return this.children;
    }

    public void setChildren(List<ProjectDir> children) {
        this.children = children;
    }

    public ProjectDir getChild() {
        return this.child;
    }

    public void setChild(ProjectDir child) {
        this.child = child;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectId=").append(projectId);
        sb.append(", name=").append(name);
        sb.append(", parentId=").append(parentId);
        sb.append(", isFile=").append(isFile);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}