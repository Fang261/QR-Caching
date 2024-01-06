package pt.iade.joaotomas.qrcaching.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.joaotomas.qrcaching.models.QrcodeItem;

@RestController
@RequestMapping(path = "/qrcode")
public class QrcodeController {

    private static ArrayList<QrcodeItem> qrcodeList = new ArrayList<>();

    @GetMapping
    public List<QrcodeItem> getAllNotes() {
        return qrcodeList;

    }

    @GetMapping(path = "/{id}")
    public QrcodeItem getQrcodeById(int id) {
        for (QrcodeItem qrcode : qrcodeList) {
            if (qrcode.getId() == id)
                return qrcode;
        }
        return null;
    }

    @GetMapping(path = "/{id}/{qrcode}/{localPhoto}/{latitude}/{longitude}/{altitude}")
    public QrcodeItem addQrcode(int id) {
        QrcodeItem qrcode = new QrcodeItem(id, null, null, 0, 0, 0);
        qrcodeList.add(qrcode);
        return qrcode;
    }

    @GetMapping(path = "/{id}/{qrcode}/{localPhoto}/{latitude}/{longitude}/{altitude}")
    public QrcodeItem deleteQrcode(int id, String qrcode, String localPhoto, float latitude, float longitude,
            float altitude) {
        for (QrcodeItem qrcode1 : qrcodeList) {
            if (qrcode1.getId() == id) {
                qrcodeList.remove(qrcode1);
                return qrcode1;
            }
        }
        return null;
    }

}
