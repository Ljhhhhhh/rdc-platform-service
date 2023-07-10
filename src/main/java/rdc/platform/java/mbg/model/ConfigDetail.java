package rdc.platform.java.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ConfigDetail implements Serializable {
    @ApiModelProperty(value = "关联项目ID")
    private String projectId;

    private Integer dirId;

    private Integer id;

    private Integer templateId;

    private ConfigTemplate templateInfo;

    private String comment;

    private Object detail;

    private Short sort;

    private static final long serialVersionUID = 1L;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Integer getDirId() {
        return dirId;
    }

    public void setDirId(Integer dirId) {
        this.dirId = dirId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }
    public ConfigTemplate getTemplateInfo() {
        return templateInfo;
    }

    public void setTemplateInfo(ConfigTemplate templateInfo) {
        this.templateInfo = templateInfo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectId=").append(projectId);
        sb.append(", dirId=").append(dirId);
        sb.append(", id=").append(id);
        sb.append(", templateId=").append(templateId);
        sb.append(", comment=").append(comment);
        sb.append(", detail=").append(detail);
        sb.append(", sort=").append(sort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}