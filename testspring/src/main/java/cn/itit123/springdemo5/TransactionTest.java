package cn.itit123.springdemo5;

import java.util.Arrays;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {

    private ApplicationContext ctx = null;
    private PurchaseService purchaseService = null;
    private BatchPurchaseService batchPurchaseService = null;

    {
        ctx = new ClassPathXmlApplicationContext("demo5/applicationContext.xml");
        purchaseService = (PurchaseService) ctx.getBean("purchaseService");
        batchPurchaseService = (BatchPurchaseService) ctx.getBean("batchPurchaseService");
    }

    /**
     * �û���һ����
     * �����÷�-����ع�
     * ��@Transactional ע�͡����赱ǰ�û����ֻ��10Ԫ����Ԫ���Ժ��û����û�б䣬spring�Ŀ��ȴ�����ˡ�׬�ˣ�����
     * ��@Transactional ע�ʹ򿪡����赱ǰ�û����ֻ��10Ԫ����Ԫ���Ժ��û����û�б䣬spring�Ŀ��Ҳû�м��١�����ǻع���
     * �ع�������ҵ���߼����ȸ��¿�棬�ٸ����������ǿ����³ɹ��ˣ���������߼��׳��쳣��������ݿ��ֵ��û�б䡣Ҳ���ǿ��ع��ˡ�
     */
    @Test
    public void basicTransaction() {
        System.out.println("^^^^^^^^^^^^^^^^^@Transactional �������ʹ�÷���");
        purchaseService.purchase("itdragon", "spring");
    }

    /**
     * �û���౾��
     * ����Ĵ����� -�������У���С����С����ı�����ʽ
     * ��@Transactional, ��ǰ�û����50���ǿ�����һ����ġ����н��������ݿ����û���û�м��٣�������Ŀ��Ҳ��û�м��١�
     * ��@Transactional(propagation=Propagation.REQUIRED), ���н����һ���ġ�
     * ��REQUIRED ���� REQUIRES_NEW ������ �������һ������������
     * Ϊʲô�أ������� ��Ϊ��Ū���ˣ���������
     * ��Ȼ������Ĵ����ԣ��ǵ�Ȼ��һ�����񴫲�����һ������
     * ��Ҫ����һ���������������� batchPurchase���� ������purchase����
     * �� REQUIRED ���� REQUIRES_NEW ���еĽ���ǣ��û��������ˣ���һ����Ŀ��Ҳ�����ˡ�
     * REQUIRED����������������У���ǰ�ķ�������������������С����򣬾�����һ���µ����񣬲����Լ������������С�������ع��ˣ�С�������һ��ع���
     * REQUIRES_NEW����ǰ�ķ����������������񣬲����Լ������������С���������������У�Ӧ�ý������𡣴�������Ȼ�ع��ˣ�����С�����Ѿ������ˡ�
     * �����REQUIRES_NEW���������һ����
     */
    @Test
    public void propagationTransaction() {
        System.out.println("^^^^^^^^^^^^^^^^^@Transactional(propagation) ����Ĵ�����");
        batchPurchaseService.batchPurchase("itdragon", Arrays.asList("java", "spring"));
    }

    /**
     * �����쳣���ع������ⳬ�򣨲����ã�
     * ��ǰ�û����10Ԫ������һ����ֵ40Ԫ��java�顣���н��������û���٣�java��Ŀ������ˣ�׬�ˣ�������Ϊ����ָ���쳣���ع���
     * ָ���쳣�ع��Ͳ����ˡ�
     */
    @Test
    public void noRollbackForTransaction() {
        System.out.println("^^^^^^^^^^^^^^^^^@Transactional(noRollbackFor) ���ûع���������");
        purchaseService.purchase("itdragon", "java");
    }
}