package com.rigtrack.tracker.Dao;

import com.rigtrack.tracker.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDao extends JpaRepository<Image, String> {
}
