package com.thinkgem.jeesite.modules.student.web;

import com.thinkgem.jeesite.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;


@Controller
@RequestMapping("${adminPath}/student")
public class UploadController extends BaseController {

    @RequestMapping("/download")
    public void download(HttpSession session,HttpServletResponse response){
        // path是指欲下载的文件的路径。
        String path="template/xyxx_template.xls";
        //获取目标文件的绝对路径
        String fullFileName = session.getServletContext().getRealPath(path);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型  response.setContentType("multipart/form-data");
        response.setContentType("application/octet-stream");
        //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
        response.setHeader("Content-Disposition", "attachment;fileName="+"xyxx_template.xls");
        try {
            if(null != fullFileName && !fullFileName.equals("")){
            /* 根据文件路径获取文件 */
            File file=new File(fullFileName);
            if(file.exists()){// 文件存在
                 InputStream inputStream=new FileInputStream(file);
                 OutputStream out = response.getOutputStream();
                //写文件
                int b;
                byte[] buffer = new byte[1024];
                while((b=inputStream.read(buffer))!= -1)
                {
                    out.write(buffer,0,b);
                }

                inputStream.close();
                out.close();
                out.flush();
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
