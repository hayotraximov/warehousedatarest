package uz.raximov.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.raximov.demo.Entity.Output;
import uz.raximov.demo.Entity.OutputProduct;
import uz.raximov.demo.Entity.Product;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Repository.OutputProductRepository;
import uz.raximov.demo.payload.OutputProductDto;

import java.util.Optional;

@Service
public class OutputProductService {

    @Autowired
    OutputProductRepository outputProductRepository;

    @Autowired
    ProductService productService;

    @Autowired
    OutputService outputService;

    public Page<OutputProduct> page(Integer page){
        Pageable pageable = PageRequest.of(page, 10);
        return outputProductRepository.findAll(pageable);
    }

    public OutputProduct getById(Integer id){
        Optional<OutputProduct> outputProduct = outputProductRepository.findById(id);
        return outputProduct.orElseGet(OutputProduct::new);
    }

    public Delete delete(Integer id){
        return new Delete();
        //code
    }

    public OutputProduct add(OutputProductDto outputProductDto){

        Optional<Product> byId1 = productService.productRepository.findById(outputProductDto.getProductId());
        if (!byId1.isPresent()) {
            return new OutputProduct();
        }

        Optional<Output> byId2 = outputService.outputRepository.findById(outputProductDto.getOutputId());
        if (!byId2.isPresent()) {
            return new OutputProduct();
        }

        OutputProduct outputProduct = new OutputProduct();
        outputProduct.setProduct(byId1.get());
        outputProduct.setOutput(byId2.get());
        outputProduct.setPrice(outputProductDto.getPrice());
        outputProduct.setAmount(outputProductDto.getAmount());
        return outputProductRepository.save(outputProduct);
    }

    public OutputProduct edit(Integer id, OutputProductDto outputProductDto){
        Optional<OutputProduct> outputProductOptional = outputProductRepository.findById(id);

        if (outputProductOptional.isPresent()){
            Optional<Product> byId1 = productService.productRepository.findById(outputProductDto.getProductId());
            if (!byId1.isPresent()) {
                return new OutputProduct();
            }

            Optional<Output> byId2 = outputService.outputRepository.findById(outputProductDto.getOutputId());
            if (!byId2.isPresent()) {
                return new OutputProduct();
            }

            OutputProduct outputProduct = outputProductOptional.get();
            outputProduct.setProduct(byId1.get());
            outputProduct.setOutput(byId2.get());
            outputProduct.setPrice(outputProductDto.getPrice());
            outputProduct.setAmount(outputProductDto.getAmount());
            return outputProductRepository.save(outputProduct);
        }

        return new OutputProduct();
    }
}
