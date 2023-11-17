package dao;

import Entity.PromotionsEntity;

import java.util.List;

public interface PromotionDao {
    PromotionsEntity getPromotionByProductId(int productId);
    PromotionsEntity getPromotionByCategoryId(int categoryId);
    List<PromotionsEntity> getPromotionsCategory() ;
    List<PromotionsEntity> getPromotionsProduct() ;

}
