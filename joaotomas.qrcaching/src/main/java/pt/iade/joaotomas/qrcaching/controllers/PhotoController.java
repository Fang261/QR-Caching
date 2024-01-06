package pt.iade.joaotomas.qrcaching.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.joaotomas.qrcaching.models.PhotoItem;

@RestController
@RequestMapping(path = "/photo")
public class PhotoController {

    private static ArrayList<PhotoItem> photoList = new ArrayList<>();

    @GetMapping
    public List<PhotoItem> getAllNotes() {
        return photoList;

    }

    @GetMapping(path = "/{id}/{photo}/{text}")
    public PhotoItem getPhotoById(int id, String photo, String text) {
        for (PhotoItem photo1 : photoList) {
            if (photo1.getId() == id)
                return photo1;
        }
        return null;
    }

    @GetMapping(path = "/{id}/{photo}/{text}")
    public PhotoItem addPhoto(int id, String photo, String text) {
        PhotoItem photo1 = new PhotoItem(id, text, text);
        photoList.add(photo1);
        return photo1;
    }

    @GetMapping(path = "/{id}/{final_date}")
    public PhotoItem deletePhoto(int id, LocalDate final_date) {
        for (PhotoItem photo1 : photoList) {
            if (photo1.getId() == id) {
                photoList.remove(photo1);
                return photo1;
            }
        }
        return null;
    }

    @GetMapping
    public PhotoItem updatePhoto(int id, String photo, String text) {
        for (PhotoItem photo1 : photoList) {
            if (photo1.getId() == id) {
                photo1.setPhoto(photo);
                photo1.setText(text);
                return photo1;
            }
        }
        return null;
    }

}
