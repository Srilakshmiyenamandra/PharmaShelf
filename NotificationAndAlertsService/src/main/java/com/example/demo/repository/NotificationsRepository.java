package com.example.demo.repository;

import java.util.List;
import com.example.demo.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Long> {

	List<Notifications> findByUserID(Long userID);
}