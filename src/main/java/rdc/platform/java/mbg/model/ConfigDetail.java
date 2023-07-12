package rdc.platform.java.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ConfigDetail implements Serializable {
    @ApiModelProperty(value = "关联项目ID")
    private String projectId;

    @ApiModelProperty(value = "关联目录ID")
    private Integer dirId;

    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "关联模板ID")
    private Integer templateId;

    @ApiModelProperty(value = "关联模板详情")
    private ConfigTemplate templateInfo;

    @ApiModelProperty(value = "注释")
    private String comment;

    @ApiModelProperty(value = "配置详情")
    private Object detail;

    @ApiModelProperty(value = "配置文件中排序")
    private Short sort;

    @ApiModelProperty(value = "关联模板更新")
    private Boolean templateUpdated;

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
    public Boolean getTemplateUpdated() {
        return templateUpdated;
    }

    public void setTemplateUpdated(Boolean templateUpdated) {
        this.templateUpdated = templateUpdated;
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