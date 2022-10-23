package com.example.demoprodbwriter.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoProRepository extends JpaRepository<DemoPro001, Long> {
}
