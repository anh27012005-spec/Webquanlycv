package web.quan.ly.dto;

import jakarta.validation.constraints.NotBlank;

public class CompanyRequest {

    @NotBlank(message = "Ten cong ty khong duoc de trong")
    private String companyName;

    @NotBlank(message = "Mieu ta khong duoc bo trong")
    private String description;

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
