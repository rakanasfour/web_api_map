package net.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import net.radol.mapper.SalesCategoryMapper;
import net.radol.model.ItemSalesCategory;

@Repository
public interface ItemSalesCategoryRepository extends JpaRepository<ItemSalesCategory, Integer> {

    @Transactional
    void deleteAllByMappedSalesCategory(SalesCategoryMapper mappedSalesCategory);
}
