package rdc.platform.java.mbg.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class ProjectDir implements Serializable {
    private Integer id;

    @ApiModelProperty(dataType = "String")
    private String projectId;

    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer parentId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ProjectDir> children;

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

    public List<ProjectDir> getChildren() {
        return this.children;
    }

    public void setChildren(List<ProjectDir> children) {
        this.children = children;
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}