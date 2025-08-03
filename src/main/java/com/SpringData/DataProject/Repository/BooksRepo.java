package com.SpringData.DataProject.Repository;
import com.SpringData.DataProject.Model.BooksModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface BooksRepo extends JpaRepository<BooksModel, Integer> {
            @Query("SELECT b FROM BooksModel b " +
                    "WHERE (UPPER(b.author) LIKE UPPER(CONCAT('%',:author,'%')) OR :author IS  NULL) " +
                    "AND (UPPER(b.title) LIKE UPPER(CONCAT('%',:title,'%')) OR :title IS  NULL) " +
                    "AND (:year IS NULL OR b.year = :year) ")
            Page<BooksModel> searchBooks(
                    @Param("author") String author,
                    @Param("title") String title,
                    @Param("year") Integer year,
                    Pageable pagable);
}
