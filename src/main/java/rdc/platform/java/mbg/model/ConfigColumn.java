package rdc.platform.java.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ConfigColumn implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "模板中定位")
    private Short order;

    @ApiModelProperty(value = "列名称")
    private String name;

    @ApiModelProperty(value = "值类型")
    private String valueType;

    @ApiModelProperty(value = "分隔符")
    private String divider;

    @ApiModelProperty(value = "列长，-1表示可变长度")
    private Short length;

    @ApiModelProperty(value = "默认值")
    private String defaultValue;

    @ApiModelProperty(value = "关联枚举")
    private Integer linkEnumId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getOrder() {
        return order;
    }

    public void setOrder(Short order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getDivider() {
        return divider;
    }

    public void setDivider(String divider) {
        this.divider = divider;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Integer getLinkEnumId() {
        return linkEnumId;
    }

    public void setLinkEnumId(Integer linkEnumId) {
        this.linkEnumId = linkEnumId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", order=").append(order);
        sb.append(", name=").append(name);
        sb.append(", valueType=").append(valueType);
        sb.append(", divider=").append(divider);
        sb.append(", length=").append(length);
        sb.append(", defaultValue=").append(defaultValue);
        sb.append(", linkEnumId=").append(linkEnumId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}