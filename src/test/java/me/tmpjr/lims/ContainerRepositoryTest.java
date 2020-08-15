package me.tmpjr.lims;

import static org.assertj.core.api.Assertions.assertThat;

import me.tmpjr.lims.container.Container;
import me.tmpjr.lims.container.ContainerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

@DataJpaTest
public class ContainerRepositoryTest {
    @Autowired
    private ContainerRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testSaveNewContainer() {
        String containerName = "Test Vial 1";
        Container newContainer = new Container();
        newContainer.setContainerName(containerName);
        entityManager.persist(newContainer);
        Container savedContainer = repository.findFirstByContainerName(containerName);
        assertThat(savedContainer.getContainerName()).isEqualTo(containerName);
    }

}
