package com.kos.cafe.domain;


import org.springframework.web.multipart.MultipartFile;

public class PhotoDTO {
    MultipartFile photo;

    public PhotoDTO(MultipartFile photo) {
        this.photo = photo;
    }

    public PhotoDTO() {
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }
}
