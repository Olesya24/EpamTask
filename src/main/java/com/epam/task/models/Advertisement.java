package com.epam.task.models;

import javax.ws.rs.core.Response;

public class Advertisement {

    private long adId;
    private String adTitle;
    private String adCategory;
    private String adDescription;
    private String adPhone;
    private String adCreationDate;
    private long authorId;

    public Advertisement() {
    }

    public Advertisement(long adId, String adTitle, String adCategory, String adDescription, String adPhone, String adCreationDate, long authorId) {
        this.adId = adId;
        this.adTitle = adTitle;
        this.adCategory = adCategory;
        this.adDescription = adDescription;
        this.adPhone = adPhone;
        this.adCreationDate = adCreationDate;
        this.authorId = authorId;
    }

    public Advertisement(Advertisement object) {
        this(object.getId(), object.getAdTitle(), object.getAdCategory(), object.getAdDescription(), object.getAdPhone(), object.getAdCreationDate(), object.getAuthorId());

    }

    public void setId(long adId) {
        this.adId = adId;
    }

    public long getId() {
        return adId;
    }

    public void setAuthorId(long authorId) {
        this.adId = authorId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdCategory(String adCategory) {
        this.adCategory = adCategory;
    }

    public String getAdCategory() {
        return adCategory;
    }

    public void setAdDescription(String adDescription) {
        this.adDescription = adDescription;
    }

    public String getAdDescription() {
        return adDescription;
    }

    public void setAdPhone(String adPhone) {
        this.adPhone = adPhone;
    }

    public String getAdPhone() {
        return adPhone;
    }

    public void setAdCreationDate(String adCreationDate) {
        this.adCreationDate = adCreationDate;
    }

    public String getAdCreationDate() {
        return adCreationDate;
    }
}
