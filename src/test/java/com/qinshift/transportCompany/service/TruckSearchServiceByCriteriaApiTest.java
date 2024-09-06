package com.qinshift.transportCompany.service;

import com.qinshift.transportCompany.dto.TruckDto;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class TruckSearchServiceByCriteriaApiTest {
        @Autowired
        @Qualifier("criteriaApi")
        private TruckSearchService searchService;

        @Autowired
        private EntityManager entityManager;

        @Test
        public void testSearchTrucks() {
            List<TruckDto> trucks = searchService.searchTrucks(
                    null,
                    "Freightliner",
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null);

            assertNotNull(trucks);
            assertFalse(trucks.isEmpty());
            assertEquals(3, trucks.size());
            assertEquals("Freightliner Cascadia", trucks.get(0).getModel());
        }

        @Test
        public void testSearchTrucksWithMultipleCriteria() {
            List<TruckDto> trucks = searchService.searchTrucks(
                    8,
                    "Kenworth",
                    null,
                    null,
                    null,
                    null,
                    null,
                    true,
                    null);


            assertNotNull(trucks);
            assertFalse(trucks.isEmpty());
            assertEquals(2, trucks.size());
            assertEquals("Kenworth T880", trucks.get(0).getModel());
        }
    }
