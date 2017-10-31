package cn.itit123.springdemo5;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseService {

    @Autowired
    private ShopDao shopDao;

    /**
     * ģ���û�������Ʒ��������ع�
     * ������÷���ֱ���ڷ�����������ʹ��ע��@Transactional��ֵ��ע����ǣ�ֻ���ڹ���������ʹ��
     * ��Ӧ�Ĳ��Է����� basicTransaction()
     */
//    @Transactional
    /**
     * ����Ĵ��� propagation=Propagation.REQUIRED
     * ���õ������� REQUIRED��REQUIRES_NEW
     * ��Ӧ�Ĳ��Է�����  propagationTransaction()
     */
//  @Transactional(propagation=Propagation.REQUIRED)
    /**
     *��������½�һ��С����
     */
//  @Transactional(propagation=Propagation.REQUIRES_NEW)
    /**
     * ����ĸ�����
     * ��������������������ڸ߲����ĳ����·��� ������ö��Ͳ����ظ���������
     * Ĭ��ֵ��READ_COMMITTED ֻ�ܱ�������������
     * ������ʾ��û�ж�Ӧ�Ĳ��Է�����
     */
//  @Transactional(isolation=Isolation.READ_COMMITTED)
    /**
     * �ع���������
     * Ĭ�����������ʽ��������е�����ʱ�쳣���лع���Ҳ����ָ��ĳЩ�쳣�ع���ĳЩ�쳣���ع��������岻��
     * noRollbackFor ָ���쳣���ع�
     * rollbackFor ָ���쳣�ع�
     */
//  @Transactional(noRollbackFor={UserException.class, ProductException.class})
//  @Transactional(rollbackFor={UserException.class, ProductException.class})
    /**
     * ��ʱ��ֻ������
     * ��ʱ����ָ��ʱ����û�����������ع������Լ�����Դռ�á�������λ����
     * �����ʱ������ʾ������Ϣ��
     * org.springframework.transaction.TransactionTimedOutException: Transaction timed out
     * ֻ�����ԣ�ָ�������Ƿ�Ϊֻ��. ������ֻ�����������������ݿ������Ż�����
     * ��Ϊ���������޸����ݵĲ�����������ֻ��true������ʾ������Ϣ
     * nested exception is java.sql.SQLException: Connection is read-only. Queries leading to data modification are not allowed
     * ��Ӧ�Ĳ��Է����� basicTransaction()
     */
  @Transactional(timeout=5, readOnly=false)
    public void purchase(String account, String sku) {
      // ���Գ�ʱ�õ�
      try {
          Thread.sleep(6000);
      } catch (InterruptedException e) {
      }
      //1. ��ȡ��ĵ���
      float price = shopDao.getBookPriceBySku(sku);

      //2. �������Ŀ��
      shopDao.updateBookStock(sku);

      //3. �����û����
      shopDao.updateUserBalance(account, price);

    }

}