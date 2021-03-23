package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.raximov.demo.Entity.AttachmentContent;

import java.util.Optional;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Integer> {
    Optional<AttachmentContent> findByAttachmentId(Integer id);
}
