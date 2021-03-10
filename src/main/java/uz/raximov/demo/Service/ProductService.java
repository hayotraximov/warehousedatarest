package uz.raximov.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.raximov.demo.Entity.Attachment;
import uz.raximov.demo.Entity.Category;
import uz.raximov.demo.Entity.Measurement;
import uz.raximov.demo.Entity.Product;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Repository.ProductRepository;
import uz.raximov.demo.payload.ProductDTO;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    AttachmentService attachmentService;

    @Autowired
    MeasurementService measurementService;


    public Page<Product> getAll(Integer page){
        Pageable pageable = PageRequest.of(page,10);
        return productRepository.findAll(pageable);
    }

    public Product getAllById(Integer id){
        Optional<Product> byId = productRepository.findById(id);
        return byId.orElseGet(Product::new);
    }

    public Delete delete(Integer id){

        return new Delete();

        //code yozish kerak
    }

    public Product add(ProductDTO productDTO) throws IOException {

        Category byId = categoryService.getById(productDTO.getCategoryId());
        if (byId.getId() == null)
            return new Product();

        Measurement measurement = measurementService.measurementgetById(productDTO.getMeasurementId());
        if (measurement.getId()==null)
            return new Product();

        Optional<Attachment> attachment = attachmentService.attachmentRepository.findById(productDTO.getAttachmentId());
        if (!attachment.isPresent()) {
            return new Product();
        }

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setActive(productDTO.isActive());
        UUID uuid = UUID.randomUUID();
        product.setCode(uuid.toString());
        product.setMeasurement(measurement);
        product.setCategory(byId);
        product.setAttachment(attachment.get());

        return productRepository.save(product);
    }

    public Product edit(Integer id, ProductDTO productDTO) throws IOException {

        Category byId = categoryService.getById(productDTO.getCategoryId());
        if (byId.getId() == null)
            return new Product();

        Measurement measurement = measurementService.measurementgetById(productDTO.getMeasurementId());
        if (measurement.getId()==null)
            return new Product();

        Optional<Attachment> attachment = attachmentService.attachmentRepository.findById(productDTO.getAttachmentId());
        if (!attachment.isPresent()) {
            return new Product();
        }

        Product product = getAllById(id);
        product.setName(productDTO.getName());
        product.setActive(productDTO.isActive());
        product.setMeasurement(measurement);
        product.setCategory(byId);
        product.setAttachment(attachment.get());

        return productRepository.save(product);
    }
}
