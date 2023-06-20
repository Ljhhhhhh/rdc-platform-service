package rdc.platform.java.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ConfigEnum implements Serializable {
    @ApiModelProperty(value = "ID")
    private String id;

    @ApiModelProperty(value = "枚举名称")
    private String name;

    @ApiModelProperty(value = "枚举包含值，用, 分割")
    private String options;

    @ApiModelProperty(value = "枚举值类型")
    private Short type;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", options=").append(options);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}