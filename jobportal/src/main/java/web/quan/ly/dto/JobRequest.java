package web.quan.ly.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class JobRequest {

    @NotBlank(message = "title khong duoc de trong")
    private String title;

    @NotBlank(message = "position khong duoc de trong")
    private String position;

    @NotBlank(message = "description khong duoc de trong")
    private String description;

    @NotBlank(message = "requirement khong duoc de trong")
    private String requirement;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }
}