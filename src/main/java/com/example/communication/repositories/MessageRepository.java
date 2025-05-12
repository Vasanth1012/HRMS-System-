package com.example.communication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.communication.models.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
