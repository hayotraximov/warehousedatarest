package uz.raximov.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.raximov.demo.Entity.Category;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Repository.CategoryRepository;
import uz.raximov.demo.payload.CategoryDTO;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    //Barchasini qaytarish
    public Page<Category> page(Integer page){
        Pageable pageable = PageRequest.of(page,10);
        return categoryRepository.findAll(pageable);
    }

    //Id bo'yicha qaytarish
    public Category getById(Integer id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElseGet(Category::new);
    }

    //O'chirish
    public Delete delete(Integer id){
        return new Delete();
        //kod yozish kerak
    }

    //Qo'shish
    public Category add(CategoryDTO categoryDTO){
        Optional<Category> categoryOptional = categoryRepository.findByName(categoryDTO.getName());
        Optional<Category> categoryOptional1 = categoryRepository.findById(categoryDTO.getParentId());
        if (!categoryOptional.isPresent()){
            Category category = new Category();
            category.setName(categoryDTO.getName());
            category.setActive(categoryDTO.isActive());
            categoryOptional1.ifPresent(category::setCategory);
            return categoryRepository.save(category);
        }
        return new Category();
    }

    //Tahrirlash
    public Category edit(Integer id, CategoryDTO categoryDTO){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        Optional<Category> categoryOptional1 = categoryRepository.findById(categoryDTO.getParentId());
        if (categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            category.setName(categoryDTO.getName());
            category.setActive(categoryDTO.isActive());
            categoryOptional1.ifPresent(category::setCategory);
            return categoryRepository.save(category);
        }
        return new Category();
    }
}
