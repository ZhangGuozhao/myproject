package cn.itit123.springdemo5;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BatchPurchaseService {

    @Autowired
    private PurchaseService purchaseService;

    // 批量采购书籍,事务里面有事务
    @Transactional
    public void batchPurchase(String username, List<String> skus) {
        for (String sku : skus) {
            purchaseService.purchase(username, sku);
        }
    }

}