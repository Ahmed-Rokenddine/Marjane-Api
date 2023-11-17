package com.example.marjane;

import Entity.PromotionsEntity;
import dao.AbstractDao;
import dao.PromotionDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.Impl.PromotionsServiceImp;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PromotionsServiceImpTest {

    @Mock
    private AbstractDao promotionDao;

    @Mock
    private PromotionDao promotionDao1;

    @InjectMocks
    private PromotionsServiceImp promotionsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSave() {
        // Mock data
        PromotionsEntity promotion = new PromotionsEntity();
        promotion.setIdproduct(1);
        promotion.setStatus("ACTIVE");
        promotion.setPourcentage(10);

        // Mock behavior
        when(promotionDao.getPromotionByProductId(1)).thenReturn(null);
        when(promotionDao.getPromotionByCategoryId(anyInt())).thenReturn(null);
        when(promotionDao.save(promotion)).thenReturn(1);

        // Test
        int savedId = promotionsService.save(promotion);

        // Verify interactions
        verify(promotionDao, times(1)).getPromotionByProductId(1);
        verify(promotionDao, times(1)).getPromotionByCategoryId(anyInt());
        verify(promotionDao, times(1)).save(promotion);

        // Assertions
        assertEquals(1, savedId);
    }

    @Test
    void testSaveWithExistingPromotion() {
        // Mock data
        PromotionsEntity promotion = new PromotionsEntity();
        promotion.setIdproduct(1);
        promotion.setStatus("ACTIVE");
        promotion.setPourcentage(10);

        // Mock behavior
        PromotionsEntity existingPromotion = new PromotionsEntity();
        existingPromotion.setId(1);
        when(promotionDao.notify(1)).thenReturn(existingPromotion);
        when(promotionDao.save(existingPromotion)).thenReturn(1);

        // Test
        int savedId = promotionsService.save(promotion);

        // Verify interactions
        verify(promotionDao, times(1)).notify(1);
        verify(promotionDao, times(1)).getPromotionByCategoryId(anyInt());
        verify(promotionDao, times(1)).update(existingPromotion.getId(), existingPromotion);

        // Assertions
        assertEquals(1, savedId);
    }

   
}
