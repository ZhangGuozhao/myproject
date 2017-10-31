package cn.itit123.springdemo5;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BatchPurchaseService {

    @Autowired
    private PurchaseService purchaseService;

    // �����ɹ��鼮,��������������
    @Transactional
    public void batchPurchase(String username, List<String> skus) {
        for (String sku : skus) {
            purchaseService.purchase(username, sku);
        }
    }

}