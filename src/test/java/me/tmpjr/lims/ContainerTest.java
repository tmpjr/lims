package me.tmpjr.lims;

import me.tmpjr.lims.container.Container;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@DataJpaTest
public class ContainerTest {
    private static Validator validator;

    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void whenBlankName_thenOneConstraintViolation() {
        Container container = new Container();
        Set<ConstraintViolation<Container>> violations = validator.validate(container);
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void whenNotBlankName_thenNoConstraintViolation() {
        Container container = new Container();
        container.setContainerName("Vile 1");
        Set<ConstraintViolation<Container>> violations = validator.validate(container);
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void whenEmptyName_thenOneConstraintViolation() {
        Container container = new Container();
        container.setContainerName("");
        Set<ConstraintViolation<Container>> violations = validator.validate(container);
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void whenNullName_thenOneConstraintViolation() {
        Container container = new Container();
        container.setContainerName(null);
        Set<ConstraintViolation<Container>> violations = validator.validate(container);
        assertThat(violations.size()).isEqualTo(1);
    }
}
