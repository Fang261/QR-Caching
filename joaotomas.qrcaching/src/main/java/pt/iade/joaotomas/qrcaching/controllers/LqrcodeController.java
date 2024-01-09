package pt.iade.joaotomas.qrcaching.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.joaotomas.qrcaching.models.Lqrcode;
import pt.iade.joaotomas.qrcaching.models.exceptions.NotFoundException;
import pt.iade.joaotomas.qrcaching.models.repositories.LqrcodeRepository;
import pt.iade.joaotomas.qrcaching.models.responses.Response;

import java.util.List;

@RestController
@RequestMapping(path = "/qrcode")
public class LqrcodeController {

    private static final Logger logger = LoggerFactory.getLogger(LqrcodeController.class);

    @Autowired
    private LqrcodeRepository qrcodeRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Lqrcode> getAllQrcodes() {
        logger.info("Sending all qrcodes");
        return (List<Lqrcode>) qrcodeRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getQrcode(@PathVariable("id") int id) {
        logger.info("Sending qrcode with ID " + id);
        Lqrcode qrcode = qrcodeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("" + id, "Qrcode", "id"));

        return ResponseEntity.ok(new Response("Qrcode found", qrcode));
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteQrcode(@PathVariable("id") int id) {
        logger.info("Deleting qrcode with ID " + id);
        if (qrcodeRepository.existsById(id)) {
            qrcodeRepository.deleteById(id);
            return ResponseEntity.ok(new Response("Qrcode deleted", null));
        } else {
            return ResponseEntity.ok(new Response("Qrcode not found", null));
        }
    }

    @PostMapping(path = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> addQrcode(@RequestBody Lqrcode qrcode) {
        logger.info("Including new qrcode " + qrcode);
        Lqrcode savedQrcode = qrcodeRepository.save(qrcode);
        return ResponseEntity.ok(new Response("Qrcode added", savedQrcode));
    }

    // Add other custom queries if needed
}
