package com.example.gdg_project.badge;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class BadgeDto {
    public Long badgeId;
    public String badgeName;
    public String badgeIconUrl;
    public String badgeCondition;
    public boolean isActive;
}
