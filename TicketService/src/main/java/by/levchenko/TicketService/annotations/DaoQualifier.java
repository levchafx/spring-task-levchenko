package by.levchenko.TicketService.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Qualifier
@Autowired
@Repository
@Transactional
@Retention(RetentionPolicy.RUNTIME)
public @interface DaoQualifier {

}
