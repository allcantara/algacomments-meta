package com.algaworks.comment.infrastructure.persistence.jpa;

import com.algaworks.comment.infrastructure.persistence.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentJpaRepository extends JpaRepository<CommentEntity, UUID> {
}
