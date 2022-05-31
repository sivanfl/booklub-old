package com.finalProject.booklub;
import com.finalProject.booklub.repository.entities.Book;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;



@And({
        @Spec(params="name", path="title", spec = Equal.class),
        @Spec(params="name", path = "authorFirstName", spec = Equal.class),
        @Spec(params="name", path = "authorLastName", spec = Equal.class),
        @Spec(params="name", path = "yearOfPublish", spec = Equal.class),
        @Spec(params="name", path = "publisherName", spec = Equal.class)
})

public interface BookSpec extends Specification <Book> {
}
