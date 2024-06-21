package com.kalanso.coaching.Controller;

import com.kalanso.coaching.Model.BaseDeConnaissances;
import com.kalanso.coaching.Service.BaseDeConnaissancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/base-de-connaissances")
public class BaseDeConnaissancesController {

    @Autowired
    private BaseDeConnaissancesService baseDeConnaissancesService;

    @GetMapping
    public ResponseEntity<List<BaseDeConnaissances>> getAllArticles() {
        List<BaseDeConnaissances> articles = baseDeConnaissancesService.getAllArticles();
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseDeConnaissances> getArticleById(@PathVariable Long id) {
        BaseDeConnaissances article = baseDeConnaissancesService.getArticleById(id);
        return article != null ? ResponseEntity.ok(article) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<BaseDeConnaissances> createArticle(@RequestBody BaseDeConnaissances article) {
        BaseDeConnaissances createdArticle = baseDeConnaissancesService.createArticle(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdArticle);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        baseDeConnaissancesService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}
