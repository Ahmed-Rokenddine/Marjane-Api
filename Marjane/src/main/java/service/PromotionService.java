package service;

import Entity.PromotionsEntity;

import java.util.List;

public interface PromotionService {
    PromotionsEntity getPromotionByProductId(int productId);
    PromotionsEntity getPromotionByCategoryId(int categoryId);
    List<PromotionsEntity> getPromotionsCategory() ;
    List<PromotionsEntity> getPromotionsProduct() ;

}
