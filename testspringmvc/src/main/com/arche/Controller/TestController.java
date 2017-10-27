package arche.Controller;

import arche.Model.Person;
import arche.Model.User;
import arche.Model.UserList;
import arche.Service.AttachmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import arche.Model.Attachment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ZhangGuozhao on 2017/9/11.
 */
@Controller
@RequestMapping("/mvc")
public class TestController {
    private AttachmentService attachmentService;

    //传入对象User
//input的name值需要与User的属性名一致
    @RequestMapping("test1")
    public String test(User user) {
        System.out.println("===");
        System.out.println(new Date());
        System.out.println(user.toString());
        return "/common/success";
    }

    //    页面中传递的名字应与形参的变量名字一致；
//    若无法一致可以用@RequestParam声明 ：如下
    @RequestMapping("test2")
    public String test(@RequestParam("cout") Integer count) {

        System.out.println("============");
        System.out.println(count);
        return "/common/success";
    }

    //    传入：复合对象
    @RequestMapping("test3")
    public String test(Person person) {
        System.out.println("============");
        System.out.println(person);
        return "/common/success";

    }

    //传入：List泛型对象
//    使用@RequestParam（）  可以将前台的变量和 形参变量对应起来；
    @RequestMapping("test4")
    public String test(@RequestParam("userList") UserList users) {
        System.out.println("============");
        for (User u : users.getUserList()) {
            System.out.println(u);
        }
        return "/common/success";
    }
//上传组件；需要在SpringMVC中进行配置；CommonsMultipartResolver
// HttpServletRequest需要在pom.xml中引入servlet-api
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest req, MultipartFile[] multipartFiles) throws IOException {
            System.out.println("============");
            MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
            MultipartFile file = mreq.getFile("file");
            String fileName = file.getOriginalFilename();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            FileOutputStream fos = new FileOutputStream(req.getSession().getServletContext().getRealPath("/") +
                    "upload/" + sdf.format(new Date()) + fileName.substring(fileName.lastIndexOf('.')));
            fos.write(file.getBytes());
            fos.flush();
            fos.close();
            return "/common/success";
    }

    @RequestMapping(value = "addAttachment", method = RequestMethod.POST)
    public void addAttachment(Attachment attachment){
        attachmentService.save(attachment);

    }
}

