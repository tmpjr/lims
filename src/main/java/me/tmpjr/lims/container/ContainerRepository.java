package me.tmpjr.lims.container;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "containers", path= "containers")
public interface ContainerRepository extends PagingAndSortingRepository<Container, UUID> {
    List<Container> findByContainerName(@Param("containerName") String containerName);
    Container findFirstByContainerName(@Param("containerName") String containerName);
}

