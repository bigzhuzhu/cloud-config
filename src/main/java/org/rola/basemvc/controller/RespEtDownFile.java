package org.rola.basemvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @author D
 * @date 2022/7/7
 * @Class RespEtDownFile
 * @description 使用  ResponseEntity 实现文件下载  ,  get 请求
 */
@RestController
public class RespEtDownFile {
    @RequestMapping("/downFile")
    public ResponseEntity<byte[]> downFile(HttpSession session) {
        ServletContext con = session.getServletContext();
        ResponseEntity<byte[]> respEt = null;
        // 获取要下载的文件路径
        String realPath = con.getRealPath("/static/js/img/fls.jpg");
        InputStream is = null;
        try {
            is = new FileInputStream(realPath);
            // is.available() 获取该文件的字节长度  放入 byte[] 中
            byte[] b = new byte[is.available()];
            // 将流读入字节数组中
            is.read(b);
            // 创建 HttpHeader 设置响应头信息
            MultiValueMap<String, String> multiHead = new HttpHeaders();
            // 设置下载文件的 响应头
            multiHead.add("Content-Disposition","attachment;filename=" + URLEncoder.encode("成龙历险记.jpg","UTF-8"));
            // 设置响应状态码
            HttpStatus status = HttpStatus.OK;
            // 创建 ResponseEntity
             respEt = new ResponseEntity(b,multiHead,status);
             is.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return respEt;
    }



    @PostMapping("/uploadFile")
    public  void upload(MultipartFile file,HttpSession session) {
        String filename = file.getOriginalFilename();
        // 获取上传的文件后缀
        String suffixName = filename.substring(filename.lastIndexOf("."));
        // 将 UUID 作为文件名
        String uuid = UUID.randomUUID().toString();
        filename = uuid + suffixName;
        ServletContext context = session.getServletContext();
        // 将上传的文件放入 photo 文件夹中，获取 photo 路径
        String photoPath = context.getRealPath("photo");
        File uploadFile = new File(photoPath);
        // 查看此文件夹是否存在
        if(!uploadFile.exists()) {
            uploadFile.mkdir();
        }
        // 最终上传的路径和文件
        String  finalPath = photoPath + File.separator + filename;
        try {
            // 将上传文件传输至 photo 中
            file.transferTo(new File(finalPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
