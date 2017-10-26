package arche.Service;

import arche.Dao.AttachmentDao;
import arche.Model.Attachment;

/**
 * Created by ZhangGuozhao on 2017/9/22.
 */
public class AttachmentServiceImpl implements AttachmentService {
    private AttachmentDao attachmentDao;
    public void save(Attachment attachment) {
        attachmentDao.save(attachment);
    }
}
