package pojos;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "title",
        "coupon_code",
        "coupon_type",
        "start_date",
        "end_date",
        "discount",
        "discount_type",
        "minimum_shopping",
        "maximum_discount",
        "created_by",
        "updated_by",
        "is_expire",
        "is_multiple_buy",
        "created_at",
        "updated_at"
})

public class CouponDetail {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("coupon_code")
    private String couponCode;
    @JsonProperty("coupon_type")
    private Integer couponType;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
    @JsonProperty("discount")
    private Integer discount;
    @JsonProperty("discount_type")
    private Integer discountType;
    @JsonProperty("minimum_shopping")
    private Integer minimumShopping;
    @JsonProperty("maximum_discount")
    private Object maximumDiscount;
    @JsonProperty("created_by")
    private Integer createdBy;
    @JsonProperty("updated_by")
    private Integer updatedBy;
    @JsonProperty("is_expire")
    private Integer isExpire;
    @JsonProperty("is_multiple_buy")
    private Integer isMultipleBuy;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("coupon_code")
    public String getCouponCode() {
        return couponCode;
    }

    @JsonProperty("coupon_code")
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    @JsonProperty("coupon_type")
    public Integer getCouponType() {
        return couponType;
    }

    @JsonProperty("coupon_type")
    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }

    @JsonProperty("start_date")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("start_date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("end_date")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("end_date")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("discount")
    public Integer getDiscount() {
        return discount;
    }

    @JsonProperty("discount")
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @JsonProperty("discount_type")
    public Integer getDiscountType() {
        return discountType;
    }

    @JsonProperty("discount_type")
    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    @JsonProperty("minimum_shopping")
    public Integer getMinimumShopping() {
        return minimumShopping;
    }

    @JsonProperty("minimum_shopping")
    public void setMinimumShopping(Integer minimumShopping) {
        this.minimumShopping = minimumShopping;
    }

    @JsonProperty("maximum_discount")
    public Object getMaximumDiscount() {
        return maximumDiscount;
    }

    @JsonProperty("maximum_discount")
    public void setMaximumDiscount(Object maximumDiscount) {
        this.maximumDiscount = maximumDiscount;
    }

    @JsonProperty("created_by")
    public Integer getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("created_by")
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("updated_by")
    public Integer getUpdatedBy() {
        return updatedBy;
    }

    @JsonProperty("updated_by")
    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    @JsonProperty("is_expire")
    public Integer getIsExpire() {
        return isExpire;
    }

    @JsonProperty("is_expire")
    public void setIsExpire(Integer isExpire) {
        this.isExpire = isExpire;
    }

    @JsonProperty("is_multiple_buy")
    public Integer getIsMultipleBuy() {
        return isMultipleBuy;
    }

    @JsonProperty("is_multiple_buy")
    public void setIsMultipleBuy(Integer isMultipleBuy) {
        this.isMultipleBuy = isMultipleBuy;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "CouponDetail{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", couponCode='" + couponCode + '\'' +
                ", couponType=" + couponType +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", discount=" + discount +
                ", discountType=" + discountType +
                ", minimumShopping=" + minimumShopping +
                ", maximumDiscount=" + maximumDiscount +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", isExpire=" + isExpire +
                ", isMultipleBuy=" + isMultipleBuy +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}