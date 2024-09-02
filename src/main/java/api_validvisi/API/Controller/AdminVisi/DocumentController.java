package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Document;
import api_validvisi.API.Repo.AdminVisi.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class DocumentController {
    @Autowired
    private DocumentRepo documentRepo;

    @GetMapping("/admin-visi/documents")
    public Map<String, Object> getDocuments() {
        List<Document> documentList = documentRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", documentList);
        return response;
    }

    @GetMapping("/admin-visi/documents/{id}")
    public Map<String, Object> getDocumentById(@PathVariable String id) {
        Optional<Document> document = documentRepo.findDocumentById(id);
        Map<String, Object> response = new HashMap<>();
        if (document.isPresent()) {
            response.put("success", true);
            response.put("message", "OK!");
            response.put("data", document.get());
        } else {
            response.put("success", false);
            response.put("message", "Document not found with id " + id);
            response.put("data", null);
        }
        return response;
    }

    @PostMapping("/admin-visi/documents")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveDocument(@RequestBody Document document) {
        documentRepo.save(document);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Document Berhasil Ditambahkan");
        response.put("data", null);
        return response;
    }

    @PutMapping("/admin-visi/documents/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateDocument(@PathVariable String id, @RequestBody Document document) {
        Optional<Document> existingDocument = documentRepo.findDocumentById(id);
        Map<String, Object> response = new HashMap<>();
        if (existingDocument.isPresent()) {
            Document updatedDocument = existingDocument.get();
            updatedDocument.setDocument_type_id(document.getDocument_type_id());
            updatedDocument.setName(document.getName());
            updatedDocument.setDesc(document.getDesc());
            updatedDocument.setFile(document.getFile());
            updatedDocument.setThumbnail(document.getThumbnail());
            updatedDocument.setSlug(document.getSlug());
            updatedDocument.setSource(document.getSource());
            updatedDocument.setMeta_keywords(document.getMeta_keywords());
            updatedDocument.setCreated_by(document.getCreated_by());
            updatedDocument.setUpdated_by(document.getUpdated_by());
            updatedDocument.setCreated_at(LocalDateTime.now());
            updatedDocument.setUpdated_at(LocalDateTime.now());
            updatedDocument.setStatus(document.getStatus());
            documentRepo.save(updatedDocument);
            response.put("success", true);
            response.put("message", "Document Berhasil Diubah");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Document not found with id " + id);
            response.put("data", null);
        }
        return response;
    }

    @DeleteMapping("/admin-visi/documents/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteDocument(@PathVariable String id) {
        Optional<Document> document = documentRepo.findDocumentById(id);
        Map<String, Object> response = new HashMap<>();
        if (document.isPresent()) {
            documentRepo.delete(document.get());
            response.put("success", true);
            response.put("message", "Document Berhasil Dihapus");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Document not found with id " + id);
            response.put("data", null);
        }
        return response;
    }
}
