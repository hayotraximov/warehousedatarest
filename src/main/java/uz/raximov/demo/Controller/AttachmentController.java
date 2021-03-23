package uz.raximov.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.raximov.demo.Entity.Attachment;
import uz.raximov.demo.service.AttachmentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @GetMapping("/{id}")
    public void getById(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        attachmentService.getById(id,response);
    }

    @PostMapping
    public Attachment add(MultipartHttpServletRequest request) throws IOException {
        return attachmentService.add(request);
    }
}
