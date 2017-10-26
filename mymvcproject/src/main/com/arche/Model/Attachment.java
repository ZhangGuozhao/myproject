package arche.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ZhangGuozhao on 2017/9/22.
 */
@Entity
@Table(name = "t_attachment")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "t_attachmentId")
    private String attachmentId;//主键Id

    @Column(name = "t_file_type")
    private Integer fileType;//文件类型

    @Column(name = "t_file_path")
    private String filePath;//文件地址

    @Column(name = "t_file_name")
    private String fileName;//文件名字

    @Column(name = "t_create_date")
    private Date createDate;//文件创建时间

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }
}
